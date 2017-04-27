package pl.wasowski.jolka.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.wasowski.jolka.model.Puzzle;
import pl.wasowski.jolka.services.PuzzleService;

public class MainController extends SceneController {
	@FXML private Button newButton;
	@FXML private Button editButton;
	@FXML private Button deleteButton;
	
	@FXML private TableView<Puzzle> puzzleTable;
	@FXML private TableColumn<Puzzle, Integer> numberColumn;
	@FXML private TableColumn<Puzzle, Integer> questionsColumn;
	
	@Autowired
	PuzzleService service;
	
	@Autowired
	PuzzleController puzzleController;
	
	ObservableList<Puzzle> data;
	
	@Override
	public void show() {
		Runnable task = () -> {
			data = service.getData();
			puzzleTable.setItems(data);
		};
		
		new Thread(task).start();
		super.show();
	}
	
	private String getNextNumber() {
		return String.valueOf(data.stream().map(p -> p.getNumber()).max(Integer::max).orElse(1) + 1);
	}
	
	@FXML
    private void initialize() {
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        questionsColumn.setCellValueFactory(new PropertyValueFactory<>("count"));        
    }
	
	@FXML
	private void create() {		
		TextInputDialog dialog = new TextInputDialog(getNextNumber());
		dialog.setTitle("New Puzzle");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> edit(name));
	}
	
	@FXML
	private void edit() {
		Puzzle puzzle = getSelectedPuzzle();
		puzzleController.setPuzzle(puzzle);
		puzzleController.show();
	}
	
	@FXML
	private void delete() {
		Puzzle puzzle = getSelectedPuzzle();
		service.remove(puzzle);
	}
	
	private Puzzle getSelectedPuzzle() {
		return puzzleTable.getSelectionModel().getSelectedItem();
	}
	
	private void edit(String name) {
		Puzzle puzzle = new Puzzle(Integer.valueOf(name));
		puzzleController.setPuzzle(puzzle);
		puzzleController.show();
	}
}
