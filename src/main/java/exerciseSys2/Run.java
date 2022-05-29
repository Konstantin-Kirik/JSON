package exerciseSys2;
import exerciseSys2.condition.Condition;
import exerciseSys2.dataUser.Data;
import exerciseSys2.dataUser.DataUser;
import exerciseSys2.parser.ParserData;
import exerciseSys2.parser.ParserDataUser;

public class Run {
    public static void main(String[] args) {

//        Data data = new ParserData().parserData();
//        System.out.println(data.toString());

        DataUser dataUser = new ParserDataUser().parserDataUser();
        System.out.println(dataUser);
    }

}