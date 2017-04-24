package pl.wasowski.jolka.desktop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pl.wasowski.jolka.controllers.MainController;
import pl.wasowski.jolka.controllers.PuzzleController;
import pl.wasowski.jolka.services.PuzzleService;

@Configuration
public class ApplicationConfig {
	@Bean
	public PuzzleService puzzleService() {
		return new PuzzleService();
	}
	
	@Bean
	@Scope(value = "prototype")
	public MainController mainController() {
		return new MainController();
	}
	
	@Bean
	@Scope(value = "prototype")
	public PuzzleController puzzleController() {
		return new PuzzleController();
	}
}
