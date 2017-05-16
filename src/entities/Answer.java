package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int answerId;
    private String answer;
    private int answerOrder;
    private boolean correct;

    /*Constructors*/
    public Answer(){

    }

    /*Getters and setters*/
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getAnswerOrder() {
        return answerOrder;
    }

    public void setAnswerOrder(int order) {
        this.answerOrder = order;
    }

}
