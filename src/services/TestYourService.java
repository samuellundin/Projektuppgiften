package services;

import entities.Answer;
import entities.Question;
import entities.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestYourService {

    public static void main(String[] args){

        Answer answerA = new Answer();
        answerA.setAnswer("A");
        answerA.setAnswerOrder(0);
        answerA.setCorrect(true);

        Answer answerB = new Answer();
        answerB.setAnswer("B");
        answerB.setAnswerOrder(1);
        answerB.setCorrect(false);

        Answer answerC = new Answer();
        answerC.setAnswer("C");
        answerC.setAnswerOrder(2);
        answerC.setCorrect(false);

        List<Answer> answerList = new ArrayList<>();
        answerList.add(answerA);
        answerList.add(answerB);
        answerList.add(answerC);

        Question question = new Question();
        question.setQuestion("A, B, C?");
        question.setPoints(10);
        question.setQuestionOrder(0);
        question.setType(0);
        question.setAnswerList(answerList);

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);

        Test test = new Test();
        test.setTitle("Testet");
        test.setStartDate(LocalDate.now());
        test.setStartDate(LocalDate.now().plusDays(1));
        test.setShowResult(false);
        test.setSelfCorrecting(false);
        test.setQuestionList(questionList);

        TestService service = new TestService();
        service.addTest(test);
    }
}
