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
import services.UserGroupService;
import services.UserService;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by johan on 2017-05-16.
 */
public class EditGroupControllerSecond implements Initializable{

    private ObservableList<User> observableCandidates;

    private ObservableList<User> observableChosen;

    private UserGroup userGroupToEdit;


    @FXML
    private ListView<User> candidates;

    @FXML
    private ListView<User> chosen;

    @FXML
    private TextField groupNameField;

    @Override public void initialize(URL location, ResourceBundle resources){

        groupNameField.setText(userGroupToEdit.getUser());

        //Populate observable list with users from choosen group
        List<User> userList = userGroupToEdit.getUserList();
        observableChosen = FXCollections.observableArrayList();
        for(User u: userList){
            observableChosen.add(u);
        }
        chosen.setItems(observableChosen);

        observableCandidates = FXCollections.observableArrayList();
        UserService userService = new UserService();
        List<User> allUsers = userService.getUsers();
        for(User u: allUsers){
            if(!userList.contains(u)){
                observableCandidates.add(u);
            }
        }
        candidates.setItems(observableCandidates);


    }

    public void left(ActionEvent actionEvent) {
        User potential = candidates.getSelectionModel().getSelectedItem();
        if(potential != null){
            candidates.getSelectionModel().clearSelection();
            observableCandidates.remove(potential);
            observableChosen.add(potential);

        }
    }

    public void right(ActionEvent actionEvent) {

        User potential = chosen.getSelectionModel().getSelectedItem();
        if(potential != null){
            candidates.getSelectionModel().clearSelection();
            observableChosen.remove(potential);
            observableCandidates.add(potential);
        }
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) candidates.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {
        if(groupNameField.getText().length()>0 && !observableChosen.isEmpty()) {
            UserGroupService userGroupService = new UserGroupService();
            userGroupService.updateUserGroup(userGroupToEdit.getUserGroupId(), groupNameField.getText(), observableChosen);
        }
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
