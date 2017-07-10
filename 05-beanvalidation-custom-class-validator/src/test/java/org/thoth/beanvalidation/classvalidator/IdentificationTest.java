package org.thoth.beanvalidation.classvalidator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class IdentificationTest {

protected Validator validator;

    @Before
    public void before() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void violation_if_all_are_missing() {
        // setup
        Identification id = new Identification();

        // action
        Set<ConstraintViolation<Identification>> violations
            = validator.validate(id);

        // assert
        ConstraintViolation<Identification> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("At least one of social security number, drivers license number, or passport number must exist.", v.getMessage());
    }

    @Test
    public void no_violation_if_social_security_number_exists() {
        // setup
        Identification id = new Identification();
        id.setSocialSecurityNumber("a");

        // action
        Set<ConstraintViolation<Identification>> violations
            = validator.validate(id);

        // assert
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void no_violation_if_drivers_license_number_exists() {
        // setup
        Identification id = new Identification();
        id.setDriversLicenseNumber("a");

        // action
        Set<ConstraintViolation<Identification>> violations
            = validator.validate(id);

        // assert
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void no_violation_if_passport_number_exists() {
        // setup
        Identification id = new Identification();
        id.setPassportNumber("a");

        // action
        Set<ConstraintViolation<Identification>> violations
            = validator.validate(id);

        // assert
        Assert.assertEquals(0, violations.size());
    }
}
