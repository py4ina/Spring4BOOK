package com.apress.prospring4.ch8;

import java.io.Serializable;

public class ContactSummary implements Serializable {
    private String firstName;
    private String lastName;
    private String telNumber;

    public ContactSummary(String firstName, String lastName, String telNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNumber = telNumber;
    }

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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "ContactSummary{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
