package org.thoth.beanvalidation.groupsequence;

import org.thoth.beanvalidation.groupsequence.Candy;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

    private Validator validator;

    @Before
    public void before() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void short_circuits_first_if_null() {
        // setup
        Candy w = new Candy();

        // action
        Set<ConstraintViolation<Candy>> violations
            //= validator.validate(w, CheckGroupSequence.class);
            = validator.validate(w);

        // assert
        assertEquals(1, violations.size());
        assertEquals("may not be null", violations.iterator().next().getMessage());
    }


    @Test
    public void short_circut_if_size_is_in_violation() {
        // setup
        Candy w = new Candy();
        w.setName("foo");

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(w);

        // assert
        assertEquals(1, violations.size());
        assertEquals("size must be between 4 and 10", violations.iterator().next().getMessage());
    }


    @Test
    public void short_circuit_if_pattern_is_in_violation() {
        // setup
        Candy w = new Candy();
        w.setName("SHRUBBERY");

        // action
        Set<ConstraintViolation<Candy>> violations
            = validator.validate(w);

        // assert
        assertEquals(1, violations.size());
        assertEquals("must match \"[a-z]\"", violations.iterator().next().getMessage());
    }
}

