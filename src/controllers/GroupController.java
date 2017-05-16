package controllers;

import entities.UserGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserGroupService;

/**
 * Created by johan on 2017-05-10.
 */
public class GroupController {

    @FXML
    private TextField groupNameField;

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) groupNameField.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent actionEvent) {
        String groupName = groupNameField.getText();
        System.out.println("groupName = " + groupName);
        if(groupName.length()>0){
            UserGroupService userGroupService = new UserGroupService();
            userGroupService.addUserGroup(groupName);
            groupNameField.setText("");
        }else{

        }
    }
}
