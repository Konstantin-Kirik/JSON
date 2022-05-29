package exerciseSys2.condition;

public abstract class Condition {
    private final String sortBy;

    public Condition(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortBy() {
        return sortBy;
    }
}
