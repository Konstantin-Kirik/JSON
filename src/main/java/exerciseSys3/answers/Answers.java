package exerciseSys3.answers;

import java.util.List;

public class Answers {

    private List<Answer>list;

    public Answers() {
    }

    public Answers(List<Answer> list) {
        this.list = list;
    }

    public List<Answer> getList() {
        return list;
    }

    public void setList(List<Answer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "list=" + list +
                '}';
    }
}
