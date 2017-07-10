package org.thoth.beanvalidation.variablereplacement;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoth.beanvalidation.variablereplacement.Candy;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CandyTest {

    protected static Validator validator;

    @BeforeClass
    public static void before() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Test
    public void does_the_constraint_have_the_correct_messageTemplate() {
        // setup
        Candy candy = new Candy();
        candy.setName("");

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(candy);

        // assert
        ConstraintViolation<Candy> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("{Candy.name.Size.message}", v.getMessageTemplate());
    }

    @Test
    public void is_the_message_correct_if_size_is_too_small() {
        // setup
        Candy candy = new Candy();
        candy.setName("foo");

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(candy);

        // assert
        ConstraintViolation<Candy> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("The candy name \"foo\" is invalid. It must be between 5 and 10 characters long", v.getMessage());
    }

    @Test
    public void is_the_message_correct_if_size_is_too_big() {
        // setup
        Candy candy = new Candy();
        candy.setName("123456789|1");

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(candy);

        // assert
        ConstraintViolation<Candy> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("The candy name \"123456789|1\" is invalid. It must be between 5 and 10 characters long", v.getMessage());
    }
}
