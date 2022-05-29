package exerciseSys3;

import exerciseSys3.answers.Answers;
import exerciseSys3.answers.AnswersGet;
import exerciseSys3.parser.ParserAnswer;
import exerciseSys3.parser.ParserSurvey;
import exerciseSys3.questionnaire.Questions;
import exerciseSys3.questionnaire.QuestionsAnswers;
import exerciseSys3.questionnaire.Survey;

import java.util.List;

public class Run {

    public static void main(String[] args) {

        Questions questions = new ParserSurvey().parser();
        Answers answers = new ParserAnswer().parser(questions);
        System.out.println(answers);
    }
}
