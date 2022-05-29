package exercise1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise1.converter.BaseConverter;
import exercise1.converter.ConvertData;
import exercise1.converter.Converter;
import exercise1.rules.ConvertRule;
import exercise1.unit.UnitData;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class Run {

    public static final String DISTANCE = "distance";
    public static final String UNIT = "unit";
    public static final String VALUE = "value";
    public static final String CONVERT_TO = "convert_to";

    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();

        try {

            final JsonNode jsonNode = mapper.readTree(Run.class.getClassLoader().getResourceAsStream("ex1/data.json"));

            final JsonNode distanceNode = jsonNode.get(DISTANCE);
            final String unitName = distanceNode.get(UNIT).asText();
            final double value = distanceNode.get(VALUE).asDouble();
            final String convertTo = distanceNode.get(CONVERT_TO).asText();

            final ConvertData convertData = new ConvertData(new UnitData(unitName, value), convertTo);

            final Map<String,Map<String, Double>> rulesData = mapper.readValue(Run.class.getClassLoader().getResourceAsStream
                    ("ex1/rules.json"), Map.class);

            final Map<String, ConvertRule> convertRules = rulesData.entrySet().stream().collect
                    (Collectors.toMap(Map.Entry::getKey, entry -> new ConvertRule(entry.getKey(),entry.getValue())));

            final Converter converter = new BaseConverter(convertRules);
            final UnitData converted = converter.convert(convertData);

            System.out.println(mapper.writeValueAsString(converted));

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

