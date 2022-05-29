package exercise2;

import exercise2.dataUser.DataUser;
import exercise2.parser.ParserDataOne;
import exercise2.parser.ParserDataTwo;

public class Run {

    public static void main(String[] args){

       DataUser dataUser = new ParserDataOne().parser();
       // DataUser dataUser1 = new ParserDataTwo().parser();
        System.out.println("Data base user :" + dataUser);

        //System.out.println("Data base user :" + dataUser1);

    }
}
