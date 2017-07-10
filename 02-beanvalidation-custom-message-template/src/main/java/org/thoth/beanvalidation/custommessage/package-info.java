/**
 * This example shows how the built-in, standard constraints
 * can be customized with a custom error message instead of using
 * the built-in, standard error messages.
 *
 * <p>
 * The {@code message} property is used to customize the constraint like this:
 * </p>
 *
 * <p>
 * {@code @NotNull(message = "{Candy.name.NotNull}")}
 * </p>
 *
 * <p>
 * The String value {@code "{Candy.name.NotNull}" } refers to a properties
 * file key/value pair.  The key {@code Candy.name.NotNull} will be used
 * to lookup the custom error message in the {@code ValidationMessages.properties}
 * file.  The key/value pair in the file could look something like this:
 * </p>
 *
 * <p>
 *  {@code Candy.name.NotNull=A candy name is required.}
 * </p>
 *
 * <p>
 * The {@code ValidationMessages.properties} file can not be named anything else.
 * It must be named {@code ValidationMessages.properties}.
 * The file must also exist in the <b>root</b> of the class path.  This is
 * typically done by putting the properties file in the root of the JAR containing
 * your code.
 * </p>
 *
 * @since 1.0.0.0
 */
package org.thoth.beanvalidation.custommessage;
