package com.KailuaCarRental.Kailua.Car.Rental.Model;

import java.util.Date;

public class Customers {

    private Integer customer_id;         // Corresponds to INT type in SQL, could be NULL, hence Integer
    private String name;                 // Corresponds to VARCHAR
    private String address;              // Corresponds to VARCHAR
    private String zip;                  // Corresponds to VARCHAR
    private String city;                 // Corresponds to VARCHAR
    private String phone;                // Corresponds to VARCHAR
    private String email;                // Corresponds to VARCHAR
    private String driver_licence_number; // Corresponds to VARCHAR
    private String driver_since_date;

    public Customers(){

    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriver_licence_number() {
        return driver_licence_number;
    }

    public void setDriver_licence_number(String driver_licence_number) {
        this.driver_licence_number = driver_licence_number;
    }

    public String getDriver_since_date() {
        return driver_since_date;
    }

    public void setDriver_since_date(String driver_since_date) {
        this.driver_since_date = driver_since_date;
    }
}
