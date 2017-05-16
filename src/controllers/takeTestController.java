package controllers;

import entities.Test;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import services.TestService;

import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.util.Callback;

import java.util.Set;

/**
 * Created by josef on 5/11/2017.
 */

public class takeTestController implements Initializable {


    @FXML
    private ListView chooseTestList;

    private int studentTestId;
    private String name;

    private List relationTest;
    protected List<String> listofTests = new ArrayList<>();

    ObservableList testsToDo = FXCollections.observableArrayList();


//gettest i servuiceklassen


    public void chooseTest() throws RuntimeException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(".../view/chooseTest.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent root = (Parent) fxmlLoader.load();
            Scene testScene = new Scene(root, 640, 490);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TestService service = new TestService();
        chooseTestList.setItems(FXCollections.observableArrayList(service.getTest()));
        chooseTestList.setCellFactory(new Callback<ListView<Test>, ListCell<Test>>(){
            @Override
            public ListCell<Test> call(ListView<Test> p) {
                ListCell<Test> cell = new ListCell<Test>(){
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
    }
}




    /*

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
*/
//TestService.getTest()

         /*

} catch(IOException e){
        e.printStackTrace();
        }
        }


public int noQuestions(){

        for(int i=0;i<test.size();i++){

        }
        return 3;  //Ändras till rätt värde
        }

@Override
public void initialize(URL location,ResourceBundle resources){
        //Hämta från serviceklassen.
        }
        }
*/