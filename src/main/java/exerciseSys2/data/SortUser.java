package exerciseSys2.data;

import java.util.Comparator;

public interface SortUser {

    class emailSort implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return o1.getEmail().compareTo(o2.getEmail());
        }
    }

    class ratingSort implements Comparator<UserTwo> {

        @Override
        public int compare(UserTwo o1, UserTwo o2) {
            return Integer.compare(o1.getRating(), o2.getRating());
        }
    }
}
