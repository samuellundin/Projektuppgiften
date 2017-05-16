package controllers;

import entities.Answer;
import entities.Question;
import entities.Test;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import modules.CheckAnswerField;
import modules.RadioAnswerField;
import modules.RankAnswerField;
import modules.TextAnswerField;
import services.TestService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {

    @FXML
    private TextField questionField;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField pointField;
    @FXML
    private VBox answerBox;
    @FXML
    private Label messageLabel;

    private int questionType;
    private int questionCount = 0;
    private int answerCount = 0;

    private ToggleGroup toggleGroup;
    private Test test;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeComboBox.getItems().addAll("Single Choice", "Multiple Choice", "Ranking", "Text");
        typeComboBox.setPromptText("Select type...");
        typeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            questionType = typeComboBox.getSelectionModel().getSelectedIndex();
            answerBox.getChildren().clear();
            answerCount = 0;
        });

        pointField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                pointField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        toggleGroup = new ToggleGroup();
    }


    public void saveTestAction() {
        nextQuestionAction();
        TestService service = new TestService();
        service.addTest(test);
    }

    public void addAnswerAction() {
        if (answerCount < 4) {
            switch (questionType) {
                case 0:
                    answerCount++;
                    RadioAnswerField radioField = new RadioAnswerField();
                    radioField.setRadioGroup(toggleGroup);
                    radioField.setAnswerCount(answerCount);
                    answerBox.getChildren().add(radioField);
                    break;
                case 1:
                    answerCount++;
                    CheckAnswerField checkField = new CheckAnswerField();
                    checkField.setAnswerCount(answerCount);
                    answerBox.getChildren().add(checkField);
                    break;
                case 2:
                    answerCount++;
                    RankAnswerField rankField = new RankAnswerField();
                    rankField.setAnswerCount(answerCount);
                    answerBox.getChildren().add(rankField);
                    break;
                case 3:
                    if (answerCount < 1) {
                        answerCount++;
                        TextAnswerField textField = new TextAnswerField();
                        answerBox.getChildren().add(textField);
                        break;
                    }
                default:
                    messageLabel.setText("No Question Type Selected!");
            }

        }
    }

    public void removeAnswerAction() {
        if (answerCount > 1) {
            answerCount--;
            answerBox.getChildren().remove(answerCount);
        }
    }

    public void nextQuestionAction() {
        if (validation()) {
            String questionText = questionField.getText();
            int type = typeComboBox.getSelectionModel().getSelectedIndex();
            int points = Integer.parseInt(pointField.getText());

            Question question = new Question();
            question.setQuestion(questionText);
            question.setType(type);
            question.setPoints(points);
            question.setQuestionOrder(questionCount);
            question.setAnswerList(getAnswerList());

            test.getQuestionList().add(question);
            reset();
        }
    }

    private boolean validation() {
        String question = questionField.getText();
        int type = typeComboBox.getSelectionModel().getSelectedIndex();
        String points = pointField.getText();
        if (question != null && question.length() > 0) {
            if (type > -1) {
                if (points != null && points.length() > 0) {
                    if (answerCount > 0 || answerCount == -1) {
                        return true;
                    } else {
                        messageLabel.setText("Must have atleast 1 Answer!");
                    }
                } else {
                    messageLabel.setText("Points Field cannot be blank!");
                }
            } else {
                messageLabel.setText("No Question Type selected!");
            }
        } else {
            messageLabel.setText("Question Field cannot be blank!");
        }
        return false;
    }

    private void reset() {
        questionField.clear();
        pointField.clear();
        typeComboBox.getSelectionModel().clearSelection();
        answerBox.getChildren().clear();
        answerCount = 0;
    }

    private List<Answer> getAnswerList() {
        List<Answer> answerList = new ArrayList<>();
        int answerOrder = 0;
        for (Node node : answerBox.getChildren()) {
            Answer answer = new Answer();
            switch (questionType) {
                case 0:
                    RadioAnswerField radioField = (RadioAnswerField) node;
                    answer.setAnswer(radioField.getText());
                    answer.setAnswerOrder(answerOrder);
                    answer.setCorrect(radioField.isCorrect());
                    break;
                case 1:
                    CheckAnswerField checkField = (CheckAnswerField) node;
                    answer.setAnswer(checkField.getText());
                    answer.setAnswerOrder(answerOrder);
                    answer.setCorrect(checkField.isCorrect());
                    break;
                case 2:
                    RankAnswerField rankField = (RankAnswerField) node;
                    answer.setAnswer(rankField.getText());
                    answer.setAnswerOrder(answerOrder);
                    answer.setCorrect(false);
                    break;
                case 3:
                    TextAnswerField textField = (TextAnswerField) node;
                    answer.setAnswer(textField.getText());
                    answer.setAnswerOrder(0);
                    answer.setCorrect(true);
                    break;
            }
            answerList.add(answer);
            answerOrder++;
        }
        return answerList;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
