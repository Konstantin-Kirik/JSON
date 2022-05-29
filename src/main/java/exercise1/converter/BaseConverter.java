package exercise1.converter;

import exercise1.exception.NoFoundConvertRuleException;
import exercise1.rules.ConvertRule;
import exercise1.unit.UnitData;

import java.util.Map;
import java.util.Optional;

public class BaseConverter implements Converter {

    final Map<String, ConvertRule> convertRules;

    public BaseConverter(final Map<String, ConvertRule> convertRules) {
        this.convertRules = convertRules;
    }

    @Override
    public UnitData convert(final ConvertData data) {
        final String convertTo = data.getConvertTo();
        final UnitData unit = data.getUnit();

        final Optional<ConvertRule> convertRuleOptional = Optional.ofNullable(convertRules.get(unit.getName()));
        if (convertRuleOptional.isPresent()) {
            final ConvertRule convertRule = convertRuleOptional.get();
            final double coefficient = convertRule.getConverterCoefficient(convertTo);

            return new UnitData(convertTo, Math.round((unit.getValue() * coefficient) * 100) / 100.0);
        } else {
            throw new NoFoundConvertRuleException();
        }

    }
}
