package exercise3;

public class Run {
    public static void main(String[] args) {
        Survey survey = new JsonData().parser();
        System.out.println(survey);

    }
}
