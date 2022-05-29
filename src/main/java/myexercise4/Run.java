package myexercise4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

public class Run {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode jsonRequest = mapper.readTree(Run.class.getClassLoader().getResourceAsStream("myEx4/request.json"));

            JsonNode requestData = jsonRequest.get("request");
            String chang = requestData.get("chang").asText();
            String get = requestData.get("get").asText();
            String operation = requestData.get("operation").asText();
            double buyData = requestData.get("sum").asDouble();
            double result = 0;
            boolean flag = false;

            if (operation.equals("buy")) {
                Map<String, Map<String, Double>> currenciesData = mapper.readValue(Run.class.getClassLoader().
                        getResourceAsStream("myEx4/buy.json"), Map.class);

                for (Map.Entry<String, Map<String, Double>> currency : currenciesData.entrySet()) {
                    for (Map.Entry<String, Double> values : currency.getValue().entrySet()) {

                        if (chang.equals(currency.getKey())) {
                            if (get.equals(values.getKey())) {
                                result = buyData * values.getValue();
                                flag = true;
                            }
                        }
                    }
                    if (flag != false) {
                        break;
                    }
                }

            } else {
                Map<String, Map<String, Double>> currenciesData = mapper.readValue(Run.class.getClassLoader().
                        getResourceAsStream("myEx4/sale.json"), Map.class);
            }

//            Gson gson = new Gson();
//            String json = gson.toJson(new Money(chang, get, Math.floor(result*100)/100.0));

            Money money = new Money(chang, get, operation, Math.floor(result*100)/100.0);
            mapper.writeValue(new File("D://Study//Java//SysGears//src//main//resources//myEx4//buyWriter.json"), money);
            System.out.println(mapper.writeValueAsString(money));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
