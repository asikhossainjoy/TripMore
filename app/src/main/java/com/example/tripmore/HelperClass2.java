package com.example.tripmore;

public class HelperClass2 {

    String email,packageName,availableFlight,duration,payment;

    //oo
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAvailableFlight() {
        return availableFlight;
    }

    public void setAvailableFlight(String lastNameS) {
        this.availableFlight = availableFlight;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String emailS) {
        this.duration = duration;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String phoneS) {
        this.payment = payment;
    }

    public HelperClass2() {
    }

    public HelperClass2(String email,String packageName, String availableFlight, String duration, String payment) {
        this.email = email;
        this.packageName= packageName;
        this.availableFlight = availableFlight;
        this.duration = duration;
        this.payment = payment;
    }
}
