package com.KailuaCarRental.Kailua.Car.Rental.Repository;

import com.KailuaCarRental.Kailua.Car.Rental.Model.CarType;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Cars;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Customers;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Rental_contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CarTypeRepo {


    @Autowired
    JdbcTemplate template;

public List<CarType> showList(){
    String sql = "SELECT * FROM car_type";
    RowMapper<CarType> rowMapper = new BeanPropertyRowMapper<CarType>(CarType.class);
    return template.query(sql, rowMapper);
}

public List<Cars> showCars(){
    String sql = "SELECT * FROM cars";
    RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<Cars>(Cars.class);
    return template.query(sql, rowMapper);
}

public void addCustomer(Customers customer){
        String sql = "INSERT INTO customer (name, address, zip, city, phone, email, driver_licence_number, driver_since_date)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n";
        template.update(sql, customer.getName(), customer.getAddress(), customer.getZip(), customer.getCity(), customer.getPhone(), customer.getEmail(), customer.getDriver_licence_number(), customer.getDriver_since_date());

    }

    public void addContract(Rental_contract contract){
    String sql = "INSERT INTO rental_contract (customer_id, renters_name, driver_licence_number, from_date_time, to_date_time, max_km, odometer_start, registration_plate)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n";
    template.update(sql, contract.getCustomer_id(), contract.getRenters_name(), contract.getDriver_licence_number(), contract.getFrom_date_time(), contract.getTo_date_time(), contract.getMax_km(), contract.getOdometer_start(), contract.getRegistration_plate());
    }

    public List<Customers> showCustomers(){
    String sql = "SELECT * FROM customer";
     RowMapper<Customers> rowMapper = new BeanPropertyRowMapper<Customers>(Customers.class);
     return template.query(sql, rowMapper);
    }

    public void deleteCustomer(int id){
        String sql = "DELETE FROM customer\n" +
                "WHERE customer_id = ?";
        template.update(sql, id);
    }

    public List<Rental_contract> showContracts(){
    String sql = "SELECT * FROM rental_contract";
    RowMapper<Rental_contract> rowMapper = new BeanPropertyRowMapper<Rental_contract>(Rental_contract.class);
    return template.query(sql, rowMapper);
    }

    public void deleteContract(int id){
        String sql = "DELETE FROM rental_contract\n" +
                "WHERE rental_id = ?";
        template.update(sql, id);
    }

    public List<CarType> showCarTypes(){
    String sql = "SELECT * FROM car_type";
        RowMapper<CarType> rowMapper = new BeanPropertyRowMapper<CarType>(CarType.class);
        return template.query(sql, rowMapper);
    }

    public void addCarType(CarType carType){
        String sql = "INSERT INTO car_type(car_id, gear, cruise_control, seats, aircon, car_description)\n" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        template.update(sql, carType.getCar_id(), carType.getGear(), carType.getCruise_control(), carType.getSeats(), carType.getAircon(), carType.getCar_description());
    }

    public void deleteCarType(int id){
    String sql = "DELETE FROM car_type\n" +
            "WHERE car_id = ?";
        template.update(sql, id);
    }


    public void createCar(Cars cars){
        String sql = "INSERT INTO cars(car_id, brand, model, fuel_type, registration_plate, first_registration, odometer, link)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, cars.getCar_id(), cars.getBrand(), cars.getModel(), cars.getFuel_type(), cars.getRegistration_plate(), cars.getFirst_registration(), cars.getOdometer(), cars.getLink());
    }

    public void deleteCar(String registrationPlate){
        String sql = "DELETE FROM cars\n" +
                "WHERE registration_plate = ?";
        template.update(sql, registrationPlate);
    }


    public void rentCar(String registrationPlate) {
        // SQL to insert into cars_for_rent
        String insertSql = "INSERT INTO cars_for_rent (car_id, brand, model, fuel_type, registration_plate, first_registration, odometer, link) " +
                "SELECT car_id, brand, model, fuel_type, registration_plate, first_registration, odometer, link " +
                "FROM cars WHERE registration_plate = ?";

        // SQL to delete from cars
        String deleteSql = "DELETE FROM cars WHERE registration_plate = ?";

        // Execute both queries within a transaction
        template.update(insertSql, registrationPlate);
        template.update(deleteSql, registrationPlate);
    }


    public void returnCar(String registrationPlate) {
        // SQL to insert into cars
        String insertSql = "INSERT INTO cars (car_id, brand, model, fuel_type, registration_plate, first_registration, odometer, link) " +
                "SELECT car_id, brand, model, fuel_type, registration_plate, first_registration, odometer, link " +
                "FROM cars_for_rent WHERE registration_plate = ?";

        // SQL to delete from cars_for_rent
        String deleteSql = "DELETE FROM cars_for_rent WHERE registration_plate = ?";

        // Execute both queries within a transaction
        template.update(insertSql, registrationPlate);
        template.update(deleteSql, registrationPlate);
    }


}


