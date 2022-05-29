package exerciseSys3.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import exerciseSys3.questionnaire.Questions;
import exerciseSys3.questionnaire.QuestionsAnswers;
import exerciseSys3.questionnaire.Survey;

import java.io.IOException;
import java.util.*;

public class ParserSurvey implements Survey {

    private static final String ANSWERS_JSON = "ex3/answer.json";

    @Override
    public Questions parser() {

        final ObjectMapper mapper = new ObjectMapper();
        Questions questions = new Questions();
        List<QuestionsAnswers> list = new ArrayList<>();

        try {
            JsonNode jsonSurvey = mapper.readTree(ParserSurvey.class.getClassLoader().getResourceAsStream(ANSWERS_JSON));

            for (Object obj : jsonSurvey) {
                Map<String, List<String>> result = new Gson().fromJson(obj.toString(), LinkedHashMap.class);

                for (Map.Entry<String, List<String>> entry : result.entrySet()) {
                    String key = entry.getKey();
                    List<String> values = entry.getValue();
                    QuestionsAnswers questionsAnswers = new QuestionsAnswers(key, values);
                    list.add(questionsAnswers);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        questions.setQuestions(list);
        return questions;
    }
}
