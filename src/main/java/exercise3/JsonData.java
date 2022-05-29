package exercise3;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.*;

public class JsonData {

    public static final String QUESTION = "question";
    public static final String ISNOT = "Isn`t married";
    public static final String ISMARRIED = "Is married";
    public static final String READER_QUESTION = "D://Study//Java//SysGears//src//main//resources//ex3//question.json";

    public Survey parser() {

        Scanner scanner = new Scanner(System.in);
        Survey survey = new Survey();
        JSONParser parser = new JSONParser();

        try {
            FileReader fileReaderQuestion = new FileReader(READER_QUESTION);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReaderQuestion);
            JSONArray jsonArray = (JSONArray) jsonObject.get(QUESTION);
            List<Questions> entryQuestions = new ArrayList<>();
            Questions questions = null;
            Questions questions1 = null;

            for (Object obj : jsonArray) {
                HashMap<String, List<String>> stringHashMap = new Gson().fromJson(obj.toString(), HashMap.class);
                for (Map.Entry<String, List<String>> entry : stringHashMap.entrySet()) {
                    String key = entry.getKey();
                    List<String> values = entry.getValue();
                    System.out.println(key + " : " + values);
                    String str = scanner.nextLine();

                    int count=0;

                    if (values.get(0).equals(str)) {
                        questions1 = new Questions(key, values.get(0));
                        entryQuestions.add(questions1);
                        JSONArray jsonArrayIsNotMarried = (JSONArray) jsonObject.get(ISNOT);

                        for (Object objIsNot : jsonArrayIsNotMarried) {
                            if (count == 0) {
                                HashMap<String, List<String>> stringHashMapIsNot = new Gson().fromJson(objIsNot.toString(), HashMap.class);
                                for (Map.Entry<String, List<String>> entryIsNot : stringHashMapIsNot.entrySet()) {
                                    String keyIsNot = entryIsNot.getKey();
                                    List<String> valuesIsNot = entryIsNot.getValue();
                                    System.out.println(keyIsNot + " : " + valuesIsNot);

                                    String strIsNot = scanner.nextLine();

                                    if (valuesIsNot.get(0).equals(strIsNot)) {
                                        questions = new Questions(keyIsNot, valuesIsNot.get(0));
                                        count++;
                                    } else {
                                        questions = new Questions(keyIsNot, valuesIsNot.get(1));
                                    }
                                    entryQuestions.add(questions);
                                }
                            }else {
                                break;
                            }
                        }

                    } else {
                        questions1 = new Questions(key, values.get(1));
                        entryQuestions.add(questions1);
                        JSONArray jsonArrayIsMarried = (JSONArray) jsonObject.get(ISMARRIED);

                        for (Object objIsMarried : jsonArrayIsMarried) {
                            if (count == 0) {
                                HashMap<String, List<String>> stringHashMapIsNot = new Gson().fromJson(objIsMarried.toString(), HashMap.class);
                                for (Map.Entry<String, List<String>> entryIsMarried : stringHashMapIsNot.entrySet()) {
                                    String keyIsMarried = entryIsMarried.getKey();
                                    List<String> valuesIsMarried = entryIsMarried.getValue();
                                    System.out.println(keyIsMarried + " : " + valuesIsMarried);

                                    String strIsNot = scanner.nextLine();

                                    if (valuesIsMarried.get(0).equals(strIsNot)) {
                                        questions = new Questions(keyIsMarried, valuesIsMarried.get(0));
                                        count++;

                                    } else {
                                        questions = new Questions(keyIsMarried, valuesIsMarried.get(1));
                                    }
                                    entryQuestions.add(questions);
                                }
                            }else {
                                break;
                            }
                        }
                    }
                    survey.setSurveyQ(entryQuestions);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return survey;
    }
}
