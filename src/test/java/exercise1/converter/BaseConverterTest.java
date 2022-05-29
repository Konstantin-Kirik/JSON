package exercise1.converter;

import exercise1.exception.NoFoundConvertRuleException;
import exercise1.exception.NoFoundUnitCoefficientException;
import exercise1.rules.ConvertRule;
import exercise1.unit.UnitData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BaseConverterTest {

    @Test
    void convertKmToMTest() {
        final Map<String, ConvertRule> convertedRules = Map.of("km", new ConvertRule("km", Map.of("m", (double)1000)));
        final BaseConverter baseConverter = new BaseConverter(convertedRules);
        final UnitData convert = baseConverter.convert(new ConvertData(new UnitData("km", 10), "m"));
        assertEquals(10000, convert.getValue());
        assertEquals("m", convert.getName());
    }

    @Test
    void convertMToKmTest() {
        Assertions.assertThrows(NoFoundConvertRuleException.class, () -> {
            final Map<String, ConvertRule> convertedRules = Map.of("km", new ConvertRule("km", Map.of("m", (double)1000)));
            final BaseConverter baseConverter = new BaseConverter(convertedRules);
            final UnitData convert = baseConverter.convert(new ConvertData(new UnitData("m", 10), "km"));
        });
    }

    @Test
    void convertKmToCmTest() {
        Assertions.assertThrows(NoFoundUnitCoefficientException.class, () -> {
            final Map<String, ConvertRule> convertedRules = Map.of("km", new ConvertRule("km", Map.of("m", (double)1000)));
            final BaseConverter baseConverter = new BaseConverter(convertedRules);
            final UnitData convert = baseConverter.convert(new ConvertData(new UnitData("km", 10), "cm"));
        });
    }
}