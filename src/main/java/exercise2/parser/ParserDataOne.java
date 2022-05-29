package exercise2.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise2.Sort;
import exercise2.dataUser.DataUser;
import exercise2.user.User;
import exercise2.dataBaseUser.DataBaseUser;

import java.io.FileReader;
import java.util.*;

public class ParserDataOne extends DataBaseUser implements Tags {

    @Override
    public DataUser parser() {
        DataUser dataUser = new DataUser();
        ObjectMapper mapper = new ObjectMapper();

        try {
            FileReader reader = new FileReader("D://Study//Java//SysGears//src//main//resources//ex2//data.json");
            FileReader reader1 = new FileReader("D://Study//Java//SysGears//src//main//resources//ex2//condition.json");

            JsonNode jsonNode1 = mapper.readValue(reader1, JsonNode.class);
            JsonNode conditionData = jsonNode1.get("condition");
            JsonNode includeData = conditionData.get("include");
            JsonNode sortData = conditionData.get("sort_by");
            String sortName = sortData.get(0).asText();
            String nameInclude = null;

            for (JsonNode node : includeData) {
                nameInclude = node.get("name").asText();
            }
            JsonNode jsonNode = mapper.readValue(reader, JsonNode.class);
            JsonNode dataNode = jsonNode.get("data");

            List<User> userList = new ArrayList<>();
            for (JsonNode node : dataNode) {
                String nameUser = node.get("name").asText();
                String emailUser = node.get("email").asText();

                User user =  new User(nameUser, emailUser);
                if (user.getName().equals(nameInclude)) {
                   userList.add(user);
               }
            }
            Collections.sort(userList, new Sort.emailComparator());
            dataUser.setUser(userList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataUser;
    }
}
