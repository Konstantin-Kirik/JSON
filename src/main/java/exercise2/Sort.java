package exercise2;

import exercise2.user.User;
import java.util.Comparator;

public interface Sort {

    class emailComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return o1.getEmail().compareTo(o2.getEmail());
        }
    }

    class ratingComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o1.getRating(), o2.getRating());
        }
    }

    class userEmail implements Comparator<User>{

        @Override
        public int compare(User o1, User o2) {
            return o1.getUsersEmail().compareTo(o2.getUsersEmail());
        }
    }
}
