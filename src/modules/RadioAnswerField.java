package modules;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class RadioAnswerField extends HBox {

    private Label answerLabel;
    private TextField answerField;
    private RadioButton correctRadio;

    public RadioAnswerField() {
        answerLabel = new Label("Answer:");
        answerLabel.setAlignment(Pos.CENTER_RIGHT);
        answerField = new TextField();
        answerField.setMinWidth(340);
        correctRadio = new RadioButton();
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(answerLabel, answerField, correctRadio);
    }

    public String getText() {
        return answerField.getText();
    }

    public boolean isCorrect() {
        return correctRadio.isSelected();
    }

    public void setRadioGroup(ToggleGroup group) {
        correctRadio.setToggleGroup(group);
    }

    public void setAnswerCount(int answerCount) {
        answerLabel.setText("Answer "+ answerCount +":");
    }
}
