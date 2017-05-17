package controllers;

import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserGroupService;
import services.UserService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by johan on 2017-05-10.
 */
public class AddGroupController implements Initializable{

    private ObservableList<User> observableCandidates;
    private ObservableList<User> observableChosen;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        UserService userService = new UserService();
        List<User> users = userService.getUsers();
        observableCandidates = FXCollections.observableArrayList();
        for(User u: users){
            observableCandidates.add(u);
        }
        candidates.setItems(observableCandidates);

        observableChosen = FXCollections.observableArrayList();
        chosen.setItems(observableChosen);


    }

    @FXML
    private ListView<User> candidates;

    @FXML
    private ListView<User> chosen;

    @FXML
    private TextField groupNameField;

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) groupNameField.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {
        String groupName = groupNameField.getText();
        if(groupName.length()>0){
            UserGroupService userGroupService = new UserGroupService();
            userGroupService.addUserGroup(groupName, observableChosen);
            groupNameField.setText("");
        }else{

        }
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
}
