package modules;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class TextAnswerField extends HBox {

    private Label answerLabel;
    private TextArea answerArea;

    public TextAnswerField() {
        answerLabel = new Label("Answer:");
        answerArea = new TextArea();
        answerArea.setMaxWidth(370);
        answerArea.setMaxHeight(150);
        setSpacing(10);
        setAlignment(Pos.TOP_CENTER);
        getChildren().addAll(answerLabel, answerArea);
    }

    public String getText() {
        return answerArea.getText();
    }
}
