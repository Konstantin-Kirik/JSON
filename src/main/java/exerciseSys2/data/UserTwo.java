package exerciseSys2.data;

public class UserTwo {

    private String user;
    private int rating;
    private boolean disabled;

    public UserTwo(String user, int rating, boolean disabled) {
        this.user = user;
        this.rating = rating;
        this.disabled = disabled;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "UserTwo{" +
                "user='" + user + '\'' +
                ", rating=" + rating +
                ", disabled=" + disabled +
                '}';
    }
}
