package org.thoth.beanvalidation.propertyvalidator;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

@Target({
    ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExcludesValidator.class})
@Documented
public @interface Excludes {

    String message() default "{org.thoth.beanvalidation.propertyvalidator.Excludes.message}";

    Class[] groups() default {};

    Class[] payload() default {};

    String[] value() default {};
}
