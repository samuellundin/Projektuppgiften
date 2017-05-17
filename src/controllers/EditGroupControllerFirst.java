package controllers;

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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.UserGroupService;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by johan on 2017-05-16.
 */
public class EditGroupControllerFirst implements Initializable{

    private ObservableList<UserGroup> observableUserGroups;


    @FXML
    private ListView<UserGroup> candidates;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        UserGroupService userGroupService = new UserGroupService();
        List<UserGroup> userGroups = userGroupService.getAllUserGroups();
        observableUserGroups = FXCollections.observableArrayList();
        for(UserGroup g: userGroups){
            observableUserGroups.add(g);
        }
        candidates.setItems(observableUserGroups);

    }


    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) candidates.getScene().getWindow();
        stage.close();
    }


    public void edit(ActionEvent actionEvent) {
        try {
            UserGroup userGroupToEdit = candidates.getSelectionModel().getSelectedItem();
            if(userGroupToEdit != null) {

                /*
                //Parent root = FXMLLoader.load(getClass().getResource("../view/editGroupSecond.fxml"));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/editGroupSecond.fxml"));

                Parent root = loader.load();

                //Pass id to second controller
                EditGroupControllerSecond editGroupControllerSecond = loader.<EditGroupControllerSecond>getController();
                //editGroupControllerSecond.setUserGroupId(userGroupToEdit.getUserGroupId());
                editGroupControllerSecond.setUserGroupToEdit(userGroupToEdit);


                Stage stage = (Stage) candidates.getScene().getWindow();
                stage.setScene(new Scene(root, 750, 600));
                stage.setTitle("Edit group");
                stage.show();
                */

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/editGroupSecond.fxml"));
                Stage stage = (Stage) candidates.getScene().getWindow();

                EditGroupControllerSecond editGroupControllerSecond = new EditGroupControllerSecond();
                editGroupControllerSecond.setUserGroupToEdit(userGroupToEdit);

                loader.setController(editGroupControllerSecond);

                GridPane root = loader.load();

                stage.setScene(new Scene(root, 750, 600));

                stage.show();



            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
