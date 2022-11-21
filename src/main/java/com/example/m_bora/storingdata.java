package com.example.m_bora;

public class storingdata {
    String fullname,id_No,kra_pin,username,password,phone_No;

    public storingdata() {
    }

    public storingdata(String name, String idNo, String krapin, String email, String password, String phoneNo) {
        this.fullname = name;
        this.id_No = idNo;
        this.kra_pin = krapin;
        this.username = username;
        this.password = password;
        this.phone_No = phoneNo;
    }

    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname= name;
    }

    public String getIdNo() {
        return id_No;
    }

    public void setIdNo(String idNo) {
        this.id_No = idNo;
    }

    public String getKrapin() {
        return kra_pin;
    }

    public void setKrapin(String krapin) {
        this.kra_pin = krapin;
    }

    public String getusername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phone_No;
    }

    public void setPhoneNo(String phoneNo) {
        this.phone_No = phoneNo;
    }
}
