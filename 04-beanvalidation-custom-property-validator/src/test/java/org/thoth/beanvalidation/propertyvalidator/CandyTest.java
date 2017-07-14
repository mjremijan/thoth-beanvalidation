package org.thoth.beanvalidation.propertyvalidator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import static org.junit.Assert.assertEquals;
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
    public void a_non_excludeded_name_should_not_give_you_a_constraint_violation() {
        // setup
        Candy candy = new Candy("hershey");

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(candy);

        // assert
        assertEquals(0, violations.size());
    }


    @Test
    public void do_you_get_a_constraint_violation_if_you_use_excluded_name_foo() {
        // setup
        Candy candy = new Candy("foo");

        // action
        ConstraintViolation<Candy> violation
            = validator.validate(candy).iterator().next();

        // assert
        assertEquals("{org.thoth.beanvalidation.propertyvalidator.Excludes.message}", violation.getMessageTemplate());
        assertEquals("The value \"foo\" is one of [foo, bar, shrubbery] which is forbidden.", violation.getMessage());
    }


    @Test
    public void do_you_get_a_constraint_violation_if_you_use_excluded_name_bar() {
        // setup
        Candy candy = new Candy("bar");

        // action
        ConstraintViolation<Candy> violation
            = validator.validate(candy).iterator().next();

        // assert
        assertEquals("{org.thoth.beanvalidation.propertyvalidator.Excludes.message}", violation.getMessageTemplate());
        assertEquals("The value \"bar\" is one of [foo, bar, shrubbery] which is forbidden.", violation.getMessage());
    }


    @Test
    public void do_you_get_a_constraint_violation_if_you_use_excluded_name_shrubbery() {
        // setup
        Candy candy = new Candy("shrubbery");

        // action
        ConstraintViolation<Candy> violation
            = validator.validate(candy).iterator().next();

        // assert
        assertEquals("{org.thoth.beanvalidation.propertyvalidator.Excludes.message}", violation.getMessageTemplate());
        assertEquals("The value \"shrubbery\" is one of [foo, bar, shrubbery] which is forbidden.", violation.getMessage());
    }
}
