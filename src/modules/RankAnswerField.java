package modules;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class RankAnswerField extends HBox {

    private Label answerLabel;
    private TextField answerField;

    public RankAnswerField() {
        answerLabel = new Label("Answer:");
        answerLabel.setAlignment(Pos.CENTER_RIGHT);
        answerField = new TextField();
        answerField.setMinWidth(340);
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(answerLabel, answerField);
    }

    public String getText() {
        return answerField.getText();
    }

    public void setAnswerCount(int answerCount) {
        answerLabel.setText("Answer "+ answerCount +":");
    }

}
