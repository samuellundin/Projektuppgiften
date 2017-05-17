package controllers;

import entities.User;
import entities.UserGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

    private UserGroup userGroupToEdit;


    @FXML
    private ListView<User> candidates;

    @FXML
    private ListView<User> chosen;

    @FXML
    private TextField groupNameField;

    @Override public void initialize(URL location, ResourceBundle resources){

        List<User> userList = userGroupToEdit.getUserList();
        observableChosenUsers = FXCollections.observableArrayList();
        for(User u: userList){
            observableChosenUsers.add(u);
            System.out.println("u = " + u.getFirstName());
        }
        chosen.setItems(observableChosenUsers);

        groupNameField.setText(userGroupToEdit.getUser());

        observableCandidatesUsers = FXCollections.observableArrayList();

        candidates.setItems(observableCandidatesUsers);


    }

    public void left(ActionEvent actionEvent) {
        User potential = candidates.getSelectionModel().getSelectedItem();
        if(potential != null){
            candidates.getSelectionModel().clearSelection();
            observableCandidatesUsers.remove(potential);
            observableChosenUsers.add(potential);

        }
    }

    public void right(ActionEvent actionEvent) {

        User potential = chosen.getSelectionModel().getSelectedItem();
        if(potential != null){
            candidates.getSelectionModel().clearSelection();
            observableChosenUsers.remove(potential);
            observableCandidatesUsers.add(potential);
        }
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

    public UserGroup getUserGroupToEdit() {
        return userGroupToEdit;
    }

    public void setUserGroupToEdit(UserGroup userGroupToEdit) {
        this.userGroupToEdit = userGroupToEdit;
    }
}
