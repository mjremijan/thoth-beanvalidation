package org.thoth.beanvalidation.groupsequence;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */

/*
    This @GroupSequence redefines the "Default" group.  It basically
    says that during evaluation, the 1st thing to do are all
    constraints that aren't in a group.  That would be the @NotNull
    constraint first.  If all of those are OK, then 2nd do all of
    the constraints that are in the Second.class group.  That
    would be the @Size constraint.  If all of those are OK, then
    3rd do all of the constraints that are in the Third.class
    group.  That would be the @Pattern group.  If at any time
    a group fails to validate, validation is "short circuited" and
    goes no farther.
*/
@GroupSequence({Candy.class, Candy.Second.class, Candy.Third.class})
public class Candy {

    protected interface Second {}
    protected interface Third {}

    private String name;

    @NotNull()
    @Size(min=4, max=10, groups = Second.class )
    @Pattern(regexp = "[a-z]", groups = Third.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
