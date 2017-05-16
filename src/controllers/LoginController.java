package controllers;

import entities.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    public void loginAction() {
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();
        UserService service = new UserService();
        User user = service.login(email, password);
        if(user != null) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/start.fxml"));
                Stage stage = (Stage) messageLabel.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.setTitle("Start");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Wrong Email or Password.");
            passwordField.clear();
        }
    }

    public void closeAction() {
        System.exit(0);
    }
}
