package org.thoth.beanvalidation.classvalidator;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@IdentificationExists
public class Identification {
    protected String socialSecurityNumber;
    protected String driversLicenseNumber;
    protected String passportNumber;

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
