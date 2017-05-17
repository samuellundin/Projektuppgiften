package controllers;

import entities.User;
import entities.UserGroup;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by johan on 2017-05-16.
 */
public class EditGroupControllerSecond implements Initializable{

    private ObservableList<User> observableCandidatesUsers;

    private ObservableList<User> observableChosenUsers;

    private int userGroupId;

    private UserGroup userGroupToEdit;


    @FXML
    private ListView<User> candidates;

    @FXML
    private ListView<User> chosen;

    @Override public void initialize(URL location, ResourceBundle resources){

        //List<User> userList = userGroupToEdit.getUserList();
        /*
        for(User u: userList){
            observableChosenUsers.add(u);
        }
        */
        //chosen.setItems(observableChosenUsers);

    }

    public void left(ActionEvent actionEvent) {
    }

    public void right(ActionEvent actionEvent) {
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) candidates.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {
        System.out.println(userGroupToEdit.getUserGroupId());
        List<User> userList = userGroupToEdit.getUserList();
    }

    public void backAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/editGroupFirst.fxml"));
            Stage stage = (Stage) candidates.getScene().getWindow();
            stage.setScene(new Scene(root, 750, 600));
            stage.setTitle("Edit group");
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public UserGroup getUserGroupToEdit() {
        return userGroupToEdit;
    }

    public void setUserGroupToEdit(UserGroup userGroupToEdit) {
        this.userGroupToEdit = userGroupToEdit;
    }
}
