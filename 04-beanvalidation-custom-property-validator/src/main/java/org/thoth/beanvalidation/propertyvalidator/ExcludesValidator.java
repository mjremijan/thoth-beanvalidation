package org.thoth.beanvalidation.propertyvalidator;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ExcludesValidator
    implements ConstraintValidator< Excludes, String> {

    private List<String> excludeTheseValues;

    @Override
    public void initialize(Excludes arg) {
        String[] strarr = arg.value();
        if (strarr == null) {
            strarr = new String[]{};
        }
        excludeTheseValues = Arrays.asList(strarr);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
        if (excludeTheseValues.contains(value)) {
            return false;
        } else {
            return true;
        }
    }
}
