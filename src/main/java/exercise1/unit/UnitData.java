package exercise1.unit;

public class UnitData {

    private final String name;
    private final double value;

    public UnitData(final String name, final double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UnitData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
