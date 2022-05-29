package exerciseSys2.condition;

public class ConditionExclude extends Condition {

    private final boolean excludeDisabled;

    public ConditionExclude(String sortBy, boolean excludeDisabled) {
        super(sortBy);
        this.excludeDisabled = excludeDisabled;
    }

    public boolean isExcludeDisabled() {
        return excludeDisabled;
    }
}
