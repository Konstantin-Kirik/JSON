package exerciseSys2.condition;

public class ConditionInclude extends Condition {

    private final String includeName;

    public ConditionInclude(String sortBy, String includeUser) {
        super(sortBy);
        this.includeName = includeUser;
    }
    public String getIncludeUser() {
        return includeName;
    }

}
