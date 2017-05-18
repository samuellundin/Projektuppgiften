package controllers;

import entities.Question;
import entities.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by josef on 5/17/2017.
 */
public class doTestController {


    @FXML
    private Label doTestTopLabel;
    @FXML
    private Label doTestBottomLabel;
    @FXML
    private GridPane doTest; //Modulerna med olika typer av frågor placeras inne i GridPane.

    private static Test test;



    public void setTest(Test test) {

        this.test = test;

    }
private static Question[] InitializeQuestion(int questionNo){


     ArrayList doTestList = new ArrayList();

        doTestList.add(test.getQuestionList());



        Question question = new Question();
        int questionType = question.getType();




        for (int i = 0; i < doTestList.size(); i++) {
            Question[]theQuestion = new Question[i];§




            //Bläddrar fram frågor i tur och ordning, "i" är Index.


        }
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


