package pl.wasowski.jolka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import pl.wasowski.jolka.desktop.StageController;
import pl.wasowski.jolka.model.Puzzle;
import pl.wasowski.jolka.model.Question;
import pl.wasowski.jolka.services.PuzzleService;

@Controller
public class PuzzleController extends SceneController {
    @FXML private Button addButton;
    @FXML private Button backButton;
    @FXML private Button saveButton;
    
    @FXML private TableView<Question> questionsTable;
	@FXML private TableColumn<Question, Integer> numberColumn;
	@FXML private TableColumn<Question, String> questionColumn;
	
	@FXML private BorderPane test;
    
    @Autowired
    PuzzleService service;
    
    @Autowired
    StageController stageController;
    
    @Autowired
    MainController mainController;
    
    Puzzle puzzle;
    
    public void setPuzzle(Puzzle puzzle) {
    	this.puzzle = puzzle;
    	questionsTable.setItems(puzzle.getQuestions());
    }
    
    public void refreshList() {
    	questionsTable.setItems(puzzle.getQuestions());
    }
	
	@FXML
    private void initialize() {
        numberColumn.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Integer>(questionsTable.getItems().indexOf(column.getValue()) + 1));
		
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        questionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        questionColumn.setOnEditCommit(
            new EventHandler<CellEditEvent<Question, String>>() {
                @Override
                public void handle(CellEditEvent<Question, String> event) {
                	event.getRowValue().setQuestion(event.getNewValue());
                }
            }
        );
    }
    
    @FXML
    private void add(){
    	puzzle.addQuestion(new Question());
    }
    
    @FXML
    private void back(){
    	mainController.show();
    }

    @FXML
    private void save(){
    	service.save(puzzle);
    }
}
