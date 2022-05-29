package exerciseSys3.parser;

import exerciseSys3.answers.Answers;
import exerciseSys3.answers.AnswersGet;
import exerciseSys3.questionnaire.Questions;
import exerciseSys3.questionnaire.QuestionsAnswers;

import java.util.List;

public class ParserAnswer implements AnswersGet {

//    @Override
//    public Answers parser() {
//
//
//
//        return null;
//    }

    @Override
    public Answers parser(Questions questions) {

        Answers answers = new Answers();
        return answers;
    }
}
