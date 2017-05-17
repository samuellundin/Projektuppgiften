package controllers;

import entities.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddTestController implements Initializable {

    @FXML
    private TextField titleField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TextField timeField;
    @FXML
    private CheckBox selfCorrectingCheckBox;
    @FXML
    private CheckBox showResultCheckBox;
    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeField.setPromptText("Minutes");
        timeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                timeField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void nextAction() {
        if(validation()) {
            String title = titleField.getText();
            LocalDate startDate = startDatePicker.getValue();
            LocalDate endDate = endDatePicker.getValue();
            boolean selfCorrecting = selfCorrectingCheckBox.isSelected();
            boolean showResult = showResultCheckBox.isSelected();
            int time;
            try {
                time = Integer.parseInt(timeField.getText());
            } catch (NumberFormatException ex) {
                time = 0;
            }

            Test test = new Test();
            test.setTitle(title);
            test.setStartDate(startDate);
            test.setEndDate(endDate);
            test.setSelfCorrecting(selfCorrecting);
            test.setShowResult(showResult);
            test.setTime(time);
            test.setQuestionList(new ArrayList<>());

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/question.fxml"));
                Parent root = fxmlLoader.load();
                QuestionController questionController = fxmlLoader.getController();
                questionController.setTest(test);
                Stage stage = (Stage) titleField.getScene().getWindow();
                stage.setTitle("Add Question");
                stage.setScene(new Scene(root, 640, 480));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelAction() {
        Stage stage = (Stage) titleField.getScene().getWindow();
        stage.close();
    }

    private boolean validation() {
        String title = titleField.getText();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();

        if(title != null && title.length() > 0) {
            if(startDate != null && endDate != null) {
                if(startDate.isBefore(endDate)) {
                    return true;
                } else {
                    messageLabel.setText("Start Date must be before End Date!");
                }
            } else {
                messageLabel.setText("Date fields cannot be blank!");
            }
        } else {
            messageLabel.setText("Title field cannot be blank!");
        }
        return false;
    }

}
