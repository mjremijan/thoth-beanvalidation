package org.thoth.beanvalidation.custommessage;

import javax.validation.constraints.NotNull;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Candy {

    @NotNull(message = "{Candy.name.NotNull}")
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
