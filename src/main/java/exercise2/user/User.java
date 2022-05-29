package exercise2.user;

public class User {
    private String name;
    private String email;
    private String usersEmail;
    private int rating;
    private boolean isBoolean;

    public User(){

    }
    public User(String usersEmail, int rating, boolean isBoolean) {
        this.usersEmail = usersEmail;
        this.rating = rating;
        this.isBoolean = isBoolean;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isBoolean() {
        return isBoolean;
    }

    public void setBoolean(boolean aBoolean) {
        isBoolean = aBoolean;
    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}' + "\n";
    }

//    @Override
//    public String toString() {
//        return "NewDataUsers{" +
//                "usersEmail='" + usersEmail + '\'' +
//                ", rating=" + rating +
//                ", isBoolean=" + isBoolean +
//                '}'+ "\n";
//    }
}



