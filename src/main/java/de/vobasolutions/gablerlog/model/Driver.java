package de.vobasolutions.gablerlog.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Driver {
    public String licenceString;
    public String foreName;
    public String lastName;
    public Integer driverId;

    public String getLicenceString() {
        return licenceString;
    }

    public String getForeName() {
        return foreName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setLicenceString(String licenceString) {
        this.licenceString = licenceString;
    }

    public void setForeName(String forename) {
        this.foreName = forename;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
