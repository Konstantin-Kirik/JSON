package exercise2.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise2.Sort;
import exercise2.dataUser.DataUser;
import exercise2.dataBaseUser.DataBaseUser;
import exercise2.user.User;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ParserDataTwo extends DataBaseUser implements Tags {

    public final static String READER = "D://Study//Java//SysGears//src//main//resources//ex2//dataTwo.json";

    @Override
    public DataUser parser() {
        DataUser dataUser = new DataUser();
        ObjectMapper mapper = new ObjectMapper();

        try {
            FileReader reader = new FileReader(READER);

            JsonNode jsonNode = mapper.readValue(reader, JsonNode.class);
            JsonNode dataNode = jsonNode.get(DATA);
            JsonNode conditionNode = jsonNode.get(CONDITION);

            JsonNode excludeData = conditionNode.get(EXCLUDE);
            JsonNode sortData = conditionNode.get(SORT_BY);
            String sortName = sortData.get(0).asText();
            boolean nameExclude = false;

            for (JsonNode disable : excludeData) {
                nameExclude = disable.get(DISABLED).asBoolean();
            }

            List<User> list = new ArrayList<>();
            for (JsonNode node : dataNode) {
                String userEmail = node.get(USER).asText();
                int ratingUser = node.get(RATING).asInt();
                boolean asBoolean = node.get(DISABLED).asBoolean();

                User user = new User(userEmail, ratingUser, asBoolean);
                if (nameExclude==asBoolean){
                    list.add(user);
                }
            }
            if (sortName.equals(RATING)){
                Collections.sort(list, new Sort.ratingComparator());
            }else if (sortName.equals(USER)){
                Collections.sort(list, new Sort.userEmail());
            }
            dataUser.setUser(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataUser;
    }
}

