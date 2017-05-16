package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Leon on 2017-05-04.
 */

@Entity
public class StudentQuestion {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )

    private int questionId;
    private String studentAnswer;
    private int studentTestId;


    public StudentQuestion() {

    }

    public StudentQuestion(int questionId, String studentAnswer, int studentTestId) {
        this.questionId = questionId;
        this.studentAnswer = studentAnswer;
        this.studentTestId = studentTestId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public int getStudentTestId() {
        return studentTestId;
    }

    public void setStudentTestId(int studentTestId) {
        this.studentTestId = studentTestId;
    }

}
