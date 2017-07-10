package org.thoth.beanvalidation.propertyvalidator;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Candy {
    private String name;

    public Candy(String name) {
        this.name = name;
    }

    @Excludes({"foo", "bar", "shrubbery"})
    public String getName() {
        return name;
    }
}
