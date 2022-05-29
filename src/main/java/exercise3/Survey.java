package exercise3;

import java.util.List;

public class Survey {
    private List<Questions> surveyQ;

    public Survey() {

    }
    public Survey(List<Questions> surveyQ) {
        this.surveyQ = surveyQ;
    }

    public void setSurveyQ(List<Questions> surveyQ) {
        this.surveyQ = surveyQ;
    }

    @Override
    public String toString() {
        return "Survey :{" + surveyQ +'}';
    }
}
