package com.KailuaCarRental.Kailua.Car.Rental.Model;

public class CarType {

    int car_id;
    String gear;
    String cruise_control;
    String seats;
    String aircon;
    String car_description;

    public CarType() {
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getCruise_control() {
        return cruise_control;
    }

    public void setCruise_control(String cruise_control) {
        this.cruise_control = cruise_control;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getAircon() {
        return aircon;
    }

    public void setAircon(String aircon) {
        this.aircon = aircon;
    }

    public String getCar_description() {
        return car_description;
    }

    public void setCar_description(String car_description) {
        this.car_description = car_description;
    }
}
