package de.vobasolutions.gablerlog.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Customer {
    private String firstName = "John";
    private String lastName = "Doe";
    private Integer customerId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String showGreeting() {
        return "Hello " + firstName + " " + lastName + "!";
    }
}