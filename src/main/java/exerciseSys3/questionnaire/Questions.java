package exerciseSys3.questionnaire;

import java.util.List;

public class Questions {

    private List<QuestionsAnswers> questions;

    public Questions() {
    }

    public Questions(List<QuestionsAnswers> questions) {
        this.questions = questions;
    }

    public List<QuestionsAnswers> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsAnswers> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "paths :{" +
                "questions=" + questions +
                '}';
    }
}
