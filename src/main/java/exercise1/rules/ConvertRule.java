package exercise1.rules;

import exercise1.exception.NoFoundUnitCoefficientException;

import java.util.Map;

public class ConvertRule {

    private final String unitName;
    private final Map<String, Double> rules;

    public ConvertRule(final String unitName, final Map<String, Double> rules) {
        this.unitName = unitName;
        this.rules = rules;
    }

    public String getUnitName() {
        return unitName;
    }

    public double getConverterCoefficient(final String unitName) {
        final double result = rules.getOrDefault(unitName, (double) 0);
        if(0 == result) {
            throw new NoFoundUnitCoefficientException();
        }
        return result;
    }

    @Override
    public String toString() {
        return "ConvertRule{" +
                "unitName='" + unitName + '\'' +
                ", rules=" + rules +
                '}';
    }
}
