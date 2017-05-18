package controllers;

import entities.Test;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.TestService;

import javax.persistence.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.util.Callback;

import java.util.Set;

/**
 * Created by josef on 5/11/2017.
 */

public class chooseTestController implements Initializable {


    @FXML
    private ListView<Test> chooseTestList;

    public void chooseTest() throws RuntimeException {

        FXMLLoader fxmlChooseTestLoader = new FXMLLoader(getClass().getResource(".../view/chooseTest.fxml"));
        fxmlChooseTestLoader.setController(this);
        try {
            Parent root = (Parent) fxmlChooseTestLoader.load();
            Scene testScene = new Scene(root, 800, 600);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialize(URL location, ResourceBundle resources) {  //Hämtar titlarna till prov som ska göras
        TestService service = new TestService();
        chooseTestList.setItems(FXCollections.observableArrayList(service.getTest()));
        chooseTestList.setCellFactory(new Callback<ListView<Test>, ListCell<Test>>() {
            @Override
            public ListCell<Test> call(ListView<Test> p) {
                ListCell<Test> cell = new ListCell<Test>() {
                    @Override
                    protected void updateItem(Test t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getTitle());
                        }
                    }
                };
                return cell;
            }
        });
        chooseTestList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            doTestController controller = new doTestController();
            controller.setTest(newValue);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/doTest.fxml"));
            loader.setController(controller);
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.getRoot(), 800, 600));
            stage.show();
            //kallar på doTestMetoden här, för att FXML ska laddas upp först.


        });
    }
}


