package exerciseSys2.parser;

public enum Tags {
    DATA("data"),
    NAME("name"),
    EMAIL("email"),
    RATING("rating"),
    USER("user"),
    DISABLED("disabled"),
    CONDITION("condition"),
    EXCLUDE("exclude"),
    SORT_BY("sort_by"),
    INCLUDE("include");

   private final String values;

    Tags(String values) {
        this.values = values;
    }

    public String getValues() {
        return values;
    }
}
