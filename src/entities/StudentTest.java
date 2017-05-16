package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by josef on 5/4/2017.
 */


@Entity
public class StudentTest {

    @OneToMany(targetEntity = StudentQuestion.class)
    private List StudentQuestionList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentTestId;

    private int date;

    public StudentTest() {

    }
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}
