/**
 * This example shows how the built-in, standard constraints
 * can be configured with a custom error message which has
 * varaible values in the message which are replaced by
 * bean validation at runtime. Examples of variables which
 * can be replaced are the actual value which was validate
 * and the min and max properties of a {@code @Size} constraint.
 * Take a look at an example {@code @Size} constraint:
 *
 * <p>
 * {@code @Size(message = "{Candy.name.Size.message}", min=5, max=10)}
 * </p>
 *
 * <p>
 * The String value {@code "{Candy.name.Size.message}" } refers to a properties
 * file key/value pair.  The key {@code Candy.name.Size.message} will be used
 * to lookup the custom error message in the {@code ValidationMessages.properties}
 * file (the file is put in the <b>root</b> of the class path). For variable replacement,
 * the key/value pair may look something like this:
 * </p>
 *
 * <p>
 *  {@code Candy.name.Size.message=The candy name "${validatedValue}" is invalid. It must be between {min} and {max} characters long}
 * </p>
 *
 * <p>
 * The {@code "${validatedValue}"} part is replaced by the actual value of the bean property
 * that's being validated. The {@code {min}} part, is replaced by the {@code @Size(min=...)}
 * property value and the {@code {max}} part, is replaced by the {@code @Size(max=...)}
 * property value.
 * </p>
 *
 * @since 1.0.0.0
 */
package org.thoth.beanvalidation.variablereplacement;
