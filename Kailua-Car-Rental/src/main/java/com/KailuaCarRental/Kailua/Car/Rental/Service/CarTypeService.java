package com.KailuaCarRental.Kailua.Car.Rental.Service;


import com.KailuaCarRental.Kailua.Car.Rental.Model.CarType;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Cars;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Customers;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Rental_contract;
import com.KailuaCarRental.Kailua.Car.Rental.Repository.CarTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService {

    @Autowired
    CarTypeRepo carTypeRepo;


    public List<CarType> showList(){
        return carTypeRepo.showList();
    }

    public List<Cars> showCars(){
        return carTypeRepo.showCars();
    }

    public void addCustomer(Customers customer){
        carTypeRepo.addCustomer(customer);
    }

    public void addContract(Rental_contract contract){
        carTypeRepo.addContract(contract);
    }

    public List<Customers> showCustomers(){
        return carTypeRepo.showCustomers();
    }

    public void deleteCustomer(int id){
        carTypeRepo.deleteCustomer(id);
    }

    public List<Rental_contract> showContracts(){
         return carTypeRepo.showContracts();
    }

    public void deleteContract(int id){
        carTypeRepo.deleteContract(id);
    }

    public List<CarType> showCarTypes(){
        return carTypeRepo.showCarTypes();
    }

    public void addCarType(CarType carType){
    carTypeRepo.addCarType(carType);
    }

    public void deleteCarType(int id){
        carTypeRepo.deleteCarType(id);
    }

    public void createCar(Cars cars){
        carTypeRepo.createCar(cars);
    }

    public void deleteCar(String registrationPlate){
        carTypeRepo.deleteCar(registrationPlate);
    }

    public void rentCar(String registrationPlate) {

        carTypeRepo.rentCar(registrationPlate);
    }

    public void returnCar(String registrationPlate) {

        carTypeRepo.returnCar(registrationPlate);
    }



}
