package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Label welcomeLabel;

    public void addTestAction() {
        fxmlLoader("../view/test.fxml", "Add Test", 640, 480);
    }

    public void editTestAction() {
    }

    public void gradeTestAction() {
    }

    public void shareTestAction() {
        fxmlLoader("../view/shareTest.fxml", "Share Test", 640, 480);
    }

    public void addUserAction() {
        fxmlLoader("../view/user.fxml", "Add User", 400, 400);
    }

    public void editUserAction() {
    }

    public void addGroupAction() {
        fxmlLoader("../view/addGroup.fxml", "Add Group", 750, 600);
    }

    public void editGroupAction() {
        fxmlLoader("../view/editGroupFirst.fxml", "Edit Group", 750, 600);
    }

    public void takeTestAction() {
        fxmlLoader("../view/chooseTest.fxml", "Take Test", 800, 600);
    }

    public void showResultAction() {
    }

    public void settingsAction() {
    }

    public void logoutAction() {
        try {
            Stage thisStage = (Stage) welcomeLabel.getScene().getWindow();
            thisStage.close();
            Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 200));
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void fxmlLoader(String url, String title, int width, int height) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, width, height));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
