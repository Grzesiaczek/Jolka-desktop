package pl.wasowski.jolka.desktop;

import java.io.IOException;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.fxml.FXMLLoader;

public class SpringFxmlLoader {

    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    public Object load(String url, String resources) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
        loader.setLocation(getClass().getResource(url));
        loader.setResources(ResourceBundle.getBundle(resources));
        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}