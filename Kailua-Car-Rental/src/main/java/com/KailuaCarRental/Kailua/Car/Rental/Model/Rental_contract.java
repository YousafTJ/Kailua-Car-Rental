package com.KailuaCarRental.Kailua.Car.Rental.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Rental_contract {
    private Integer rental_id;               // Corresponds to INT, could be NULL, hence Integer
    private Integer customer_id;             // Corresponds to INT, foreign key to Customers
    private String renters_name;             // Corresponds to VARCHAR
    private String driver_licence_number;    // Corresponds to VARCHAR
    private String from_date_time;    // Corresponds to DATETIME
    private String to_date_time;      // Corresponds to DATETIME
    private Integer max_km;                  // Corresponds to INT
    private Integer odometer_start;          // Corresponds to INT
    private String registration_plate;       // Corresponds to VARCHAR

    public Rental_contract(){

    }

    public Integer getRental_id() {
        return rental_id;
    }

    public void setRental_id(Integer rental_id) {
        this.rental_id = rental_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getRenters_name() {
        return renters_name;
    }

    public void setRenters_name(String renters_name) {
        this.renters_name = renters_name;
    }

    public String getDriver_licence_number() {
        return driver_licence_number;
    }

    public void setDriver_licence_number(String driver_licence_number) {
        this.driver_licence_number = driver_licence_number;
    }

    public String getFrom_date_time() {
        return from_date_time;
    }

    public void setFrom_date_time(String from_date_time) {
        this.from_date_time = from_date_time;
    }

    public String getTo_date_time() {
        return to_date_time;
    }

    public void setTo_date_time(String to_date_time) {
        this.to_date_time = to_date_time;
    }

    public Integer getMax_km() {
        return max_km;
    }

    public void setMax_km(Integer max_km) {
        this.max_km = max_km;
    }

    public Integer getOdometer_start() {
        return odometer_start;
    }

    public void setOdometer_start(Integer odometer_start) {
        this.odometer_start = odometer_start;
    }

    public String getRegistration_plate() {
        return registration_plate;
    }

    public void setRegistration_plate(String registration_plate) {
        this.registration_plate = registration_plate;
    }
}
