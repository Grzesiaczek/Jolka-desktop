package pl.wasowski.jolka.desktop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.wasowski.jolka.controllers.MainController;
import pl.wasowski.jolka.controllers.PuzzleController;
import pl.wasowski.jolka.controllers.SolutionController;
import pl.wasowski.jolka.services.PuzzleService;

@Configuration
public class ApplicationConfig {
	@Bean
	public PuzzleService puzzleService() {
		return new PuzzleService();
	}
	
	@Bean
	public StageController stageController() {
		return new StageController();
	}
	
	@Bean
	public MainController mainController() {
		return new MainController();
	}
	
	@Bean
	public PuzzleController puzzleController() {
		return new PuzzleController();
	}
	
	@Bean
	public SolutionController solutionController() {
		return new SolutionController();
	}
}
