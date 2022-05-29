package exercise2.dataUser;
import exercise2.user.User;

import java.util.List;

public class DataUser {

    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return " " + user;
    }
}

