package exerciseSys2.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exerciseSys2.condition.ConditionInclude;
import exerciseSys2.data.SortUser;
import exerciseSys2.data.User;
import exerciseSys2.dataUser.Data;
import exerciseSys2.dataUser.GetData;
import exerciseSys2.exception.NoFoundEmailException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParserData implements GetData {

    private static final String DATA_JSON = "ex2/data.json";

    @Override
    public Data parserData() {

        ObjectMapper mapper = new ObjectMapper();
        Data data = new Data();
        List<User> userList = new ArrayList<>();
        ConditionInclude include = (ConditionInclude) new ParserCondition().parserCondition();

        try {
            JsonNode jsonRequest = mapper.readTree(ParserData.class.getClassLoader().getResourceAsStream(DATA_JSON));
            JsonNode requestData = jsonRequest.get(Tags.DATA.getValues());

            for (JsonNode node : requestData) {
                String userName = node.get(Tags.NAME.getValues()).asText();
                String userEmail = node.get(Tags.EMAIL.getValues()).asText();

                if (include.getIncludeUser().equals(userName)) {
                    userList.add(new User(userName, userEmail));
                }
            }
            if (include.getSortBy().equals(Tags.EMAIL.getValues())) {
                Collections.sort(userList, new SortUser.emailSort());
            }else {
                throw new NoFoundEmailException();
            }

            data.setList(userList);

        } catch (IOException e) {
            System.err.println(e);
        }
        return data;
    }
}
