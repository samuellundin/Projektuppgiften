package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int testId;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private int time;
    private boolean selfCorrecting;
    private boolean showResult;

    @OneToMany(targetEntity = Question.class, cascade = CascadeType.PERSIST)
    private List<Question> questionList = new ArrayList<>();

    /*Constructors*/
    public Test() {

    }

    /*Getters and setters*/
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isSelfCorrecting() {
        return selfCorrecting;
    }

    public void setSelfCorrecting(boolean selfCorrecting) {
        this.selfCorrecting = selfCorrecting;
    }

    public boolean isShowResult() {
        return showResult;
    }

    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

}
