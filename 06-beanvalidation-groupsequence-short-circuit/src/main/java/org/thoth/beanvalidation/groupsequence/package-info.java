/**
 * This example shows how to use {@code @GroupSequence} as a short circuit
 * when doing validation.  This means if the 1st round of validations do not
 * pass, then validation is "short circuited" and the 2nd round of validations
 * is not performed.
 *
 * <p>
 * By default, constraints are evaluated in no particular order regardless
 * of which groups they belong to. It is however useful in some situations
 * to control the order of constraints evaluation. There are often scenarios
 * where a preliminary set of constraints should be evaluated prior to other
 * constraints.
 * </p>
 *
 * <p>
 * To implement such ordering, a group can be defined as a sequence of other
 * groups. Each group in a group sequence must be processed sequentially in
 * the order defined by {@code @GroupSequence.value}.  If one of the groups
 * processed in the sequence generates one or more constraint violations,
 * the groups following in the sequence must not be processed. This
 * ensures that a set of constraint is evaluated only if another set
 * of constraint is valid.
 * </p>
 *
 * <p>
 * To validate with this ordering, the {@code @GroupSequence} must be passed
 * to the {@code Validator}.  It would look something like this:
 * </p>
 *
 * <pre>{@code
 * Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 * Person p = new Person();
 * validator.validate(p, MyGroupSequence.class)
 * }</pre>
 *
 * <p>
 * The problem with this is that it depends on manual validation, and that
 * manual validation better be done properly.  An automated validation,
 * like using {@code @Valid} wouldn't get the validation correct because
 * the automated validation only works with the {@code Default}
 * group sequence.  Luckily, there is a way to redefine what
 * {@code Default} means for each class.
 * </p>
 *
 * <p>
 * All constraints are, by default, part of the {@code Default} group. If a
 * group for a constraint is not specified it will become part of the
 * {@code Default} group.  To redefine the {@code Default} group for
 * a given class, place a {@code @GroupSequence} annotation on the class;
 * this sequence expresses the sequence of groups that does substitute
 * {@code Default} for this class.  See the {@code Candy.java} class for
 * an example.
 * </p>
 *
 * <p>
 * <b>References</b>
 * </p>
 * <p>
 * 3.4.2 Group sequence. (n.d.). Retrieved from <a href="http://beanvalidation.org/1.0/spec/">http://beanvalidation.org/1.0/spec/</a>
 * </p>
 *
 * @since 1.0.0.0
 */
package org.thoth.beanvalidation.groupsequence;