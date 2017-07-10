package org.thoth.beanvalidation.classvalidator;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class IdentificationExistsValidator implements ConstraintValidator<IdentificationExists, Identification> {

    @Override
    public void initialize(IdentificationExists a) {}

    @Override
    public boolean isValid(Identification t, ConstraintValidatorContext cvc) {
        boolean invalid =
            Objects.equals(t.getDriversLicenseNumber(), null)
            &&
            Objects.equals(t.getPassportNumber(), null)
            &&
            Objects.equals(t.getSocialSecurityNumber(), null)
        ;
        return !invalid;
    }
}