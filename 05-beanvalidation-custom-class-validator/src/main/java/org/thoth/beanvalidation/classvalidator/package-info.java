/**
 * This example shows how to create your own constraint
 * and your own validator which applies to an entire <b>class</b>.
 * You would want to do this if validation need to look at multiple
 * properties at once. For example, for identification purposes, do
 * you have at least one of either a social security number, a
 * driver's license number, or a passport number, for a person?
 *
 * <p>
 * 1st define a new annotation to serve as your constraint.  This
 * example defines an {@code @IdentificationExists} annotation.
 * This annotation should also define the {@code message} attribute like this:
 * </p>
 *
 * <p>
 * {@code String message() default "{org.thoth.beanvalidation.classvalidator.IdentificationExists.message}";}
 * </p>
 *
 * <p>
 * The string {@code "{org.thoth.beanvalidation.classvalidator.IdentificationExists.message}"} is used
 * by bean validation to lookup the error message for this constraint from the
 * {@code ValidationMessages.properties} file.
 * </p>
 *
 * <p>
 * Remember, this annotation is a a class-level constraint, and decorates the <b>class</b>
 * (not a property) like this:
 * </p>
 *
 * <p>
 * {@code @IdentificationExists}<br/>
 * {@code public class Identification {...}}
 * </p>
 *
 * <p>
 * 2nd define new class that extends
 * {@class ConstraintValidator&lt;IdentificationExists, Identification&gt;}. This
 * is the validator for the {@code @IdentificationExists} constraint.
 * the {@code Identification} means this validator is for validating
 * an {@code Identification} <b>class</b>.  This example
 * defines an {@code IdentificationExistsValidator} class.
 * </p>
 *
 * <p>
 * 3rd define the {@code org.thoth.beanvalidation.classvalidator.IdentificationExists.message}
 * name/value pair in the {@code ValidationMessages.properties} file (put in the
 * <b>root</b> of the class path).  It may look something like this:
 *
 * <p>
 * {@code org.thoth.beanvalidation.classvalidator.IdentificationExists.message=At least one of social security number, drivers license number, or passport number must exist.}
 * </p>
 *
 * @since 1.0.0.0
 */
package org.thoth.beanvalidation.classvalidator;

