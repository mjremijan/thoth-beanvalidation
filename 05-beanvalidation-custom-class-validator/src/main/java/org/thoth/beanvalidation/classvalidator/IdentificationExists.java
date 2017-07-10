package org.thoth.beanvalidation.classvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IdentificationExistsValidator.class})
@Documented
public @interface IdentificationExists {

    String message() default "{org.thoth.beanvalidation.classvalidator.IdentificationExists.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
