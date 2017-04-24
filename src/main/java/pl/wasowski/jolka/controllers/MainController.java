package pl.wasowski.jolka.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.wasowski.jolka.model.Puzzle;
import pl.wasowski.jolka.model.Question;
import pl.wasowski.jolka.services.PuzzleService;

public class MainController {
	@FXML private Button newButton;
	@FXML private Button editButton;
	@FXML private Button deleteButton;
	
	@FXML private TableView<Puzzle> puzzleTable;
	@FXML private TableColumn<Puzzle, Integer> numberColumn;
	@FXML private TableColumn<Puzzle, Integer> questionsColumn;
	
	@Autowired
	PuzzleService service;
	
	ObservableList<Puzzle> data;
	
	public MainController() {
		//System.out.println(puzzleTable.);
	}
	
	@FXML
    private void initialize() {
		data = service.getData();
		puzzleTable.setItems(data);
        // Initialize the person table with the two columns.
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        questionsColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        
    }
	
	@FXML
	private void create() {
		Puzzle puzzle = new Puzzle(4);
		puzzle.addQuestion(new Question("who?"));
		service.save(puzzle);
	}
	
	@FXML
	private void edit() {
		//puzzle.addQuestion(new Question("tak", "nie"));
	}
	
	@FXML
	private void delete() {
		
	}
}
