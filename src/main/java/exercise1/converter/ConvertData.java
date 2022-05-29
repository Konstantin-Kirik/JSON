package exercise1.converter;

import exercise1.unit.UnitData;

public class ConvertData {

    private final UnitData unit;
    private final String convertTo;

    public ConvertData(final UnitData unit, final String convertTo) {
        this.unit = unit;
        this.convertTo = convertTo;
    }

    public UnitData getUnit() {
        return unit;
    }

    public String getConvertTo() {
        return convertTo;
    }
}
