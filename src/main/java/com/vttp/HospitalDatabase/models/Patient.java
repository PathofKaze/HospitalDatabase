package com.vttp.HospitalDatabase.models;

import java.util.Date;

public class Patient {

    private String email;
    private String name;
    private String phone;
    private String prognosis;
    private String address;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPrognosis() {
        return prognosis;
    }
    public void setPrognosis(String prognosis) {
        this.prognosis = prognosis;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    private Date dob;


        //@Override
        public String toString() {
            return "Patient [dob=" + dob + ", email=" + email + ", name=" + name + ", address=" + address + ", phone="
                    + phone + ", prognosis =" + prognosis + "]";
        }
    }