package modules;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CheckAnswerField extends HBox {

    private Label answerLabel;
    private TextField answerField;
    private CheckBox correctCheck;

    public CheckAnswerField() {
        answerLabel = new Label("Answer:");
        answerLabel.setAlignment(Pos.CENTER_RIGHT);
        answerField = new TextField();
        answerField.setId("answerField");
        answerField.setMinWidth(340);
        correctCheck = new CheckBox();
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(answerLabel, answerField, correctCheck);
    }

    public String getText() {
        return answerField.getText();
    }

    public boolean isCorrect() {
        return correctCheck.isSelected();
    }

    public void setAnswerCount(int answerCount) {
        answerLabel.setText("Answer "+ answerCount +":");
    }
}
