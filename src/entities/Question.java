package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    private String question;
    private int type;
    private int points;
    private int questionOrder;

    @OneToMany(cascade = CascadeType.PERSIST, targetEntity = Answer.class)
    private List<Answer> answerList = new ArrayList<>();

    /*Constructors*/
    public Question(){

    }

    /*Getters and setters*/
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int order) {
        this.questionOrder = order;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

}
