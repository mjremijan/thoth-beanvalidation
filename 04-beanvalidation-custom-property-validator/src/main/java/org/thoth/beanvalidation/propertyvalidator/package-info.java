/**
 * This example shows how to create your own constraint
 * and your own validator for a <b>property</b> of a class.
 *
 * <p>
 * 1st define a new annotation to serve as
 * your constraint.  This example defines an {@code @Excludes}
 * constraint which can be used to prevent a property from
 * having certain values.  This annotation should also
 * define the {@code message} attribute like this:
 * </p>
 *
 * <p>
 * {@code String message() default "{org.thoth.beanvalidation.propertyvalidator.Excludes.message}";}
 * </p>
 *
 * <p>
 * The string {@code "{org.thoth.beanvalidation.propertyvalidator.Excludes.message}"} is used
 * by bean validation to lookup the error message for this constraint from the
 * {@code ValidationMessages.properties} file.
 * </p>
 *
 * <p>
 * 2nd define new class that extends
 * {@class ConstraintValidator&lt;Excludes, String&gt;}. This
 * is the validator for the {@code @Excludes} constraint.
 * the {@code String} means this validator is for validating
 * a {@code String} property of a class.  This example
 * defines an {@code ExcludesValidator} class.
 * </p>
 *
 * <p>
 * 3rd define the {@code org.thoth.beanvalidation.propertyvalidator.Excludes.message}
 * name/value pair in the {@code ValidationMessages.properties} file (put in the
 * <b>root</b> of the class path).  It may look something like this:
 *
 * <p>
 * {@code org.thoth.beanvalidation.propertyvalidator.Excludes.message=The value "${validatedValue}" is one of {value} which is forbidden.}
 * </p>
 *
 * <p>
 * Recall the following:<br />
 * {@code ${validatedValue}} will be replaced by the value being validated <br />
 * {@code {value}} will be replaced by the string array value set on the annoation,
 * like this: {@code @Excludes({"foo", "bar", "shrubbery"})} annotation.
 * </p>
 *
 * @since 1.0.0.0
 */
package org.thoth.beanvalidation.propertyvalidator;
