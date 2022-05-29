package exerciseSys3.questionnaire;

import java.util.List;

public class QuestionsAnswers {

    private String question;
    private List<String> answers;

    public QuestionsAnswers(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return
                 question + '\'' +
                 answers +
                '}' + "\n";
    }
}
