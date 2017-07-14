package org.thoth.beanvalidation.basics;

import javax.validation.constraints.NotNull;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Widget {

    @NotNull
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
