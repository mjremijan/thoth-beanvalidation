package org.thoth.beanvalidation.basics;

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
public class WidgetTest {

    protected Validator validator;

    @Before
    public void before() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void violations_size() {
        // setup
        Widget w = new Widget();

        // action
        Set<ConstraintViolation<Widget>> violations
            = validator.validate(w);

        // assert
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void violation_message() {
        // setup
        Widget w = new Widget();

        // action
        Set<ConstraintViolation<Widget>> violations
            = validator.validate(w);

        // assert
        ConstraintViolation<Widget> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("may not be null", v.getMessage());
    }

    @Test
    public void violation_messageTemplate() {
        // setup
        Widget w = new Widget();

        // action
        Set<ConstraintViolation<Widget>> violations
            = validator.validate(w);

        // assert
        ConstraintViolation<Widget> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("{javax.validation.constraints.NotNull.message}", v.getMessageTemplate());
    }

    @Test
    public void violation_propertyPath() {
        // setup
        Widget w = new Widget();

        // action
        Set<ConstraintViolation<Widget>> violations
            = validator.validate(w);

        // assert
        ConstraintViolation<Widget> v
            = violations.stream().findFirst().get();
        Assert.assertEquals("name", v.getPropertyPath().toString());
    }
}
