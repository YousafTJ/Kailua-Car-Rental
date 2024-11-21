package com.KailuaCarRental.Kailua.Car.Rental.Controller;


import com.KailuaCarRental.Kailua.Car.Rental.Model.Cars;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Customers;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Rental_contract;
import com.KailuaCarRental.Kailua.Car.Rental.Service.CarTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

@Autowired
    CarTypeService carTypeService;

@GetMapping("/")
public String index(Model model){
    model.addAttribute("cartypes", carTypeService.showList());
    return "index";
}

@GetMapping("/seeCars")
public String seeCars(Model model){
    model.addAttribute("cars", carTypeService.showCars());
    return "cars";
}

    @GetMapping("/logIn") // This path should match exactly with the HTML link
    public String login() {
        return "login.html"; // Ensure there is a login.html template in the templates folder
    }

    @PostMapping("/loginInfo")
    public String loginInfo(@RequestParam String username, @RequestParam String password, Model model){

        if ("YousafTJ".equals(username) && "Yousaf0421".equals(password)){
            return "manage";
        } else {

            return "login";
        }
    }

    @PostMapping("/rent")
    public String rent(@RequestParam String car_id,
                       @RequestParam String brand,
                       @RequestParam String model,
                       @RequestParam String fuel_type,
                       @RequestParam String registration_plate,
                       @RequestParam String first_registration,
                       @RequestParam String odometer,
                       @RequestParam String link,
                       Model car_model){

        Cars car = new Cars();
        car.setCar_id(Integer.parseInt(car_id));
        car.setBrand(brand);
        car.setModel(model);
        car.setFuel_type(fuel_type);
        car.setRegistration_plate(registration_plate);
        car.setFirst_registration(first_registration);
        car.setOdometer(odometer);
        car.setLink(link);

        car_model.addAttribute("car_model", car);

            return "rent";
    }


    @PostMapping("/rentAndCustomer")
    public String rentAndCustomer(@RequestParam String name,
                                  @RequestParam String address,
                                  @RequestParam String zip,
                                  @RequestParam String city,
                                  @RequestParam String phone,
                                  @RequestParam String email,
                                  @RequestParam String driver_licence_number,
                                  @RequestParam String driver_since_date,
                                  @RequestParam Integer customer_id,
                                  @RequestParam String renters_name,
                                  @RequestParam String from_date_time,
                                  @RequestParam String to_date_time,
                                  @RequestParam Integer max_km,
                                  @RequestParam Integer odometer_start,
                                  @RequestParam String registration_plate){

        Customers customers = new Customers();
        customers.setCustomer_id(customer_id);
        customers.setName(name);
        customers.setAddress(address);
        customers.setZip(zip);
        customers.setCity(city);
        customers.setPhone(phone);
        customers.setEmail(email);
        customers.setDriver_licence_number(driver_licence_number);
        customers.setDriver_since_date(driver_since_date);

        Rental_contract contract = new Rental_contract();
        contract.setCustomer_id(customer_id);
        contract.setRenters_name(renters_name);
        contract.setDriver_licence_number(driver_licence_number);
        contract.setFrom_date_time(from_date_time);
        contract.setTo_date_time(to_date_time);
        contract.setMax_km(max_km);
        contract.setOdometer_start(odometer_start);
        contract.setRegistration_plate(registration_plate);

        carTypeService.addCustomer(customers);
        carTypeService.addContract(contract);
        carTypeService.rentCar(registration_plate);
        return "confirmation";

    }


}
