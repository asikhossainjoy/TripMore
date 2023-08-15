package com.example.tripmore;

public class HelperClass {

    String firstNameS,lastNameS,emailS,phoneS,passwordS;

    public String getFirstNameS() {
        return firstNameS;
    }

    public void setFirstNameS(String firstNameS) {
        this.firstNameS = firstNameS;
    }

    public String getLastNameS() {
        return lastNameS;
    }

    public void setLastNameS(String lastNameS) {
        this.lastNameS = lastNameS;
    }

    public String getEmailS() {
        return emailS;
    }

    public void setEmailS(String emailS) {
        this.emailS = emailS;
    }

    public String getPhoneS() {
        return phoneS;
    }

    public void setPhoneS(String phoneS) {
        this.phoneS = phoneS;
    }

    public String getPasswordS() {
        return passwordS;
    }

    public void setPasswordS(String passwordS) {
        this.passwordS = passwordS;
    }

    public HelperClass() {
    }

    public HelperClass(String firstNameS, String lastNameS, String emailS, String phoneS, String passwordS) {
        this.firstNameS = firstNameS;
        this.lastNameS = lastNameS;
        this.emailS = emailS;
        this.phoneS = phoneS;
        this.passwordS = passwordS;
    }
}
