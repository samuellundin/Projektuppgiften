
package controllers;

import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.SettingsService;
import services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Leon on 2017-05-11.
 */
public class SettingsController {

    @FXML
    private PasswordField currentPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private TextField settingsField;
    @FXML
    private PasswordField confirmNewPasswordField;

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) settingsField.getScene().getWindow();
        stage.close();

    }

    public void saveAction() {
        String currentPassword = currentPasswordField.getText().trim();
        String newPassword = newPasswordField.getText().trim();
        String confirmNewPassword = confirmNewPasswordField.getText().trim();
        SettingsService service = new SettingsService();
        service.settings(currentPassword, newPassword, confirmNewPassword);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/settings.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 200));
            stage.setTitle("Settings");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeAction() {
        System.exit(0);
    }
}

