package exerciseSys2.dataUser;

import exerciseSys2.data.UserTwo;

import java.util.List;

public class DataUser {

    private List<UserTwo> userList;

    public DataUser() {
    }

    public DataUser(List<UserTwo> userList) {
        this.userList = userList;
    }

    public List<UserTwo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserTwo> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "DataUser{" +
                "userList=" + userList +
                '}';
    }
}
