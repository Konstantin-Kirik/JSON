package exerciseSys2.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exerciseSys2.condition.ConditionExclude;
import exerciseSys2.data.SortUser;
import exerciseSys2.data.UserTwo;
import exerciseSys2.dataUser.DataUser;
import exerciseSys2.dataUser.GetDataUser;
import exerciseSys2.exception.NoFoundRatingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParserDataUser implements GetDataUser {
    private static final String DATA_JSON = "ex2/data.json";
    @Override
    public DataUser parserDataUser() {

        ObjectMapper mapper = new ObjectMapper();
        DataUser dataUser = new DataUser();
        List<UserTwo> userTwoList = new ArrayList<>();
        ConditionExclude exclude = (ConditionExclude) new ParserCondition().parserCondition();

        try {
            JsonNode jsonRequest = mapper.readTree(ParserData.class.getClassLoader().getResourceAsStream(DATA_JSON ));
            JsonNode requestData = jsonRequest.get(Tags.DATA.getValues());

            for (JsonNode node : requestData) {
                String userName = node.get(Tags.USER.getValues()).asText();
                int rating = node.get(Tags.RATING.getValues()).asInt();
                boolean disabled = node.get(Tags.DISABLED.getValues()).asBoolean();

                if (exclude.isExcludeDisabled() != disabled) {
                    userTwoList.add(new UserTwo(userName, rating, disabled));
                }
            }
            if (exclude.getSortBy().equals(Tags.RATING.getValues())) {
                Collections.sort(userTwoList, new SortUser.ratingSort());
            }else {
                throw new NoFoundRatingException();
            }

            dataUser.setUserList(userTwoList);

        } catch (IOException e) {
            System.err.println(e);
        }

        return dataUser;
    }
}
