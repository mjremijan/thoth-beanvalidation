package org.thoth.beanvalidation.variablereplacement;

import javax.validation.constraints.Size;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Candy {
    private String name;

    @Size(message = "{Candy.name.Size.message}", min=5, max=10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
