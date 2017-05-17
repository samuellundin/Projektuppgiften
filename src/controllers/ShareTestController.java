package controllers;

import entities.Test;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import services.TestService;
import services.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class ShareTestController implements Initializable {

    @FXML
    private ComboBox<Test> testComboBox;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private ListView userListView;
    @FXML
    private ListView selectedListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TestService testService = new TestService();
        UserService userService = new UserService();

        testComboBox.getItems().addAll(testService.getTest());
        testComboBox.setCellFactory(new Callback<ListView<Test>,ListCell<Test>>(){
            @Override
            public ListCell<Test> call(ListView<Test> p) {
                return new ListCell<Test>(){
                    @Override
                    protected void updateItem(Test t, boolean bln) {
                        super.updateItem(t, bln);
                        if(t != null){
                            setText(t.getTitle());
                        }else{
                            setText(null);
                        }
                    }
                };
            }
        });
        testComboBox.setConverter(new StringConverter<Test>() {
            @Override
            public String toString(Test test) {
                if (test == null){
                    return null;
                } else {
                    return test.getTitle();
                }
            }
            @Override
            public Test fromString(String userId) {
                return null;
            }
        });

        typeComboBox.getItems().addAll("Student", "Group");
        typeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(typeComboBox.getItems().get(0))){
                userListView.getItems().clear();
                userListView.getItems().addAll(userService.getUsers());
            } else if(newValue.equals(typeComboBox.getItems().get(1))) {
                userListView.getItems().clear();
                userListView.getItems().addAll(userService.getUserGroups());
            }
        });
    }

    public void addAction() {
        Object selected = userListView.getSelectionModel().getSelectedItem();
        selectedListView.getItems().add(selected);
        userListView.getItems().remove(selected);
    }

    public void removeAction() {
        Object selected = selectedListView.getSelectionModel().getSelectedItem();
        userListView.getItems().add(selected);
        selectedListView.getItems().remove(selected);
    }

    public void cancelAction() {
        Stage stage = (Stage) testComboBox.getScene().getWindow();
        stage.close();
    }

    public void shareAction() {

    }
}
