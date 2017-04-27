package pl.wasowski.jolka.desktop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.stage.Stage;

@Component 
public class MainApp extends Application {
    public static void main(String[] args) throws Exception {   	
        launch(args);
    }

	@Override
    public void start(Stage stage) throws Exception {
    	 ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	 StageController stageController = context.getBean(StageController.class);
    	 stageController.initialize(stage, context);
    }
    
    @Override
    public void stop() throws Exception {
    }
}
