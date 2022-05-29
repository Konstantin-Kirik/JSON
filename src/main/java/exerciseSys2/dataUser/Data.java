package exerciseSys2.dataUser;

import exerciseSys2.data.User;
import exerciseSys2.data.UserTwo;

import java.util.List;

public class Data {

    private List<User> list;

    public Data() {
    }

    public Data(List<User> list) {
        this.list = list;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "result{" +
                 list +
                '}';
    }
}
