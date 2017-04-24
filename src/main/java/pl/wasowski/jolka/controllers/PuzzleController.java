package pl.wasowski.jolka.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.wasowski.jolka.services.PuzzleService;

@Controller
public class PuzzleController {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private Label messageLabel;
    @FXML private Button myButton;
    
    @Autowired
    PuzzleService puzzleService;

    public void sayHello() {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isEmpty(firstName)) {
            builder.append(firstName);
        }

        if (!StringUtils.isEmpty(lastName)) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(lastName);
        }

        if (builder.length() > 0) {
            String name = builder.toString();
            messageLabel.setText("Hello " + name);
        } else {
            messageLabel.setText("Hello mysterious person");
        }
    }

    @FXML
    private void save(){
    	
    }
}
