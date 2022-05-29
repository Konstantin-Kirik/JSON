package exerciseSys2.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exerciseSys2.condition.Condition;
import exerciseSys2.condition.ConditionDataParser;
import exerciseSys2.condition.ConditionExclude;
import exerciseSys2.condition.ConditionInclude;
import java.io.IOException;

public class ParserCondition implements ConditionDataParser {

    private static final String CONDITION_JSON = "ex2/condition.json";

    @Override
    public Condition parserCondition() {

        ObjectMapper mapper = new ObjectMapper();
        Condition conditionObject = null;
        try {
            JsonNode jsonCondition = mapper.readTree(ParserCondition.class.getClassLoader().getResourceAsStream(CONDITION_JSON));
            JsonNode condition = jsonCondition.get(Tags.CONDITION.getValues());
            JsonNode sortData = condition.get(Tags.SORT_BY.getValues());
            String sortName = sortData.get(0).asText();
            JsonNode conditionExclude = condition.get(Tags.EXCLUDE.getValues());
            JsonNode conditionInclude = condition.get(Tags.INCLUDE.getValues());

            if (conditionExclude != null) {
                boolean disabled = true;
                for (JsonNode node : conditionExclude) {
                    disabled = node.get(Tags.DISABLED.getValues()).asBoolean();
                }
                conditionObject = new ConditionExclude(sortName, disabled);
            }
            if (conditionInclude != null) {
                String nameInclude = null;
                for (JsonNode node : conditionInclude) {
                    nameInclude = node.get(Tags.NAME.getValues()).asText();
                }
                conditionObject = new ConditionInclude(sortName, nameInclude);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
        return conditionObject;
    }
}
