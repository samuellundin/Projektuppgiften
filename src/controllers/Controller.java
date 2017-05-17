package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    @FXML
    private Label welcomeLabel;

    public void addTestAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/test.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 640, 480));
            stage.setTitle("Add Test");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editTestAction() {
    }

    public void gradeTestAction() {
    }

    public void shareTestAction() {
    }

    public void addUserAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/user.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 400));
            stage.setTitle("Add User");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editUserAction() {
    }

    public void addGroupAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/addGroup.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750, 600));
            stage.setTitle("Add group");

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void editGroupAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/editGroupFirst.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750, 600));
            stage.setTitle("Edit group");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void takeTestAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/chooseTest.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("Add group");
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
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

}
