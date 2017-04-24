package pl.wasowski.jolka.desktop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component 
public class MainApp extends Application {    
    //private static final SpringFxmlLoader loader = new SpringFxmlLoader();

    public static void main(String[] args) throws Exception {   	
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
    	try {
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @Override
    public void start(Stage stage) throws Exception {
    	ApplicationContext context = 
	    		new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	
        Parent rootNode = (Parent) FXMLLoader.load(getClass().getResource("/fxml/main.fxml"), null, null, context::getBean);

        Scene scene = new Scene(rootNode, 640, 640);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void stop() throws Exception {
    }
}
