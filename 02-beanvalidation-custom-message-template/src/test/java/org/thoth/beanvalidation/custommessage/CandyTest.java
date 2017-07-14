package org.thoth.beanvalidation.custommessage;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CandyTest {

    protected static Validator validator;

    @BeforeClass
    public static void before() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void notnull_violation_message() {
        // setup
        Candy candy = new Candy();

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(candy);

        // assert
        ConstraintViolation<Candy> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("A candy name is required.", v.getMessage());
    }

    @Test
    public void notnull_violation_messageTemplate() {
        // setup
        Candy candy = new Candy();

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(candy);

        // assert
        ConstraintViolation<Candy> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("{Candy.name.NotNull}", v.getMessageTemplate());
    }
}
