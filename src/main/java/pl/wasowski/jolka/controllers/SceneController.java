package pl.wasowski.jolka.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.Scene;
import pl.wasowski.jolka.desktop.StageController;

public abstract class SceneController {
	@Autowired
	StageController stageController;
	
	Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void show() {
		stageController.show(scene);
	}
}
