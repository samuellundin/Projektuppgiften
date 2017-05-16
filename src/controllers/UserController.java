package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private ComboBox roleComboBox;
    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleComboBox.getItems().addAll("Student", "Teacher");
    }

    public void saveAction() {
        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        int role = roleComboBox.getSelectionModel().getSelectedIndex() +1;
        if(firstname.length() > 0 && lastname.length() > 0 && email.length() > 0 && password.length() > 0 && role != 0) {
            UserService service = new UserService();
            service.addUser(firstname, lastname, email, password, role);
        } else {
            messageLabel.setText("");
        }
    }

    public void cancelAction() {
        Stage stage = (Stage) firstnameField.getScene().getWindow();
        stage.close();
    }

}
