package pl.wasowski.jolka.desktop;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.wasowski.jolka.controllers.MainController;
import pl.wasowski.jolka.controllers.PuzzleController;
import pl.wasowski.jolka.controllers.SceneController;
import pl.wasowski.jolka.controllers.SolutionController;

@Controller
public class StageController {
	private Stage stage;
	private ApplicationContext context;
	
	private int width = 640;
	private int height = 640;
	
	@Autowired
	MainController mainController;
	
	@Autowired
	PuzzleController puzzleController;
	
	@Autowired
	SolutionController solutionController;
	
	public void initialize(Stage stage, ApplicationContext context) {
		this.stage = stage;
		this.context = context;
    	
		try {
			setScene(mainController, "main");
			setScene(puzzleController, "puzzle");
			setScene(solutionController, "solution");
		} catch (IOException e) {
			e.printStackTrace();
		}

        stage.setTitle("Jolka, Jolka");
        mainController.show();
        stage.show();
	}
	
	public void show(Scene scene) {
		stage.setScene(scene);
	}
	
	private void setScene(SceneController sceneController, String name) throws IOException {
		Scene scene = getScene("/fxml/" + name + ".fxml");
		sceneController.setScene(scene);
	}
	
	private Scene getScene(String file) throws IOException {
		Parent node = (Parent) FXMLLoader.load(getClass().getResource(file), null, null, context::getBean);
		return new Scene(node, width, height);
	}
}
