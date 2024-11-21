package com.KailuaCarRental.Kailua.Car.Rental.Controller;


import com.KailuaCarRental.Kailua.Car.Rental.Model.CarType;
import com.KailuaCarRental.Kailua.Car.Rental.Model.Cars;
import com.KailuaCarRental.Kailua.Car.Rental.Service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OwnerController {
    @Autowired
    CarTypeService carTypeService;

    @GetMapping("/manageCars")
    public String manageCars(Model model) {

        model.addAttribute("cars", carTypeService.showCars());
        return "manageCars"; // This should correspond to the "manageCars.html" template
    }

    @PostMapping("/deleteCar")
    public RedirectView deleteCar(@RequestParam("registration_plate") String registrationPlate){

        carTypeService.deleteCar(registrationPlate);
        return new RedirectView("/manageCars");
    }

    @GetMapping("/addCar")
    public String addCar(){
        return "addCar";
    }

    @PostMapping("/createCar")
    public String createCar(@ModelAttribute Cars cars){
        carTypeService.createCar(cars);
        return "redirect:/manageCars";
    }

    // Route to display car types
    @GetMapping("/manageCarTypes")
    public String manageCarTypes(Model model) {
        model.addAttribute("carTypes" , carTypeService.showCarTypes());

        return "manageCarTypes"; // This should correspond to the "manageCarTypes.html" template
    }


    @GetMapping("/createCarType")
    public String createCarType(){
        return "createCarType";
    }

    @PostMapping("/deleteCarType")
    public RedirectView deleteCarType(@RequestParam("car_id") int car_id){
        carTypeService.deleteCarType(car_id);
        return new RedirectView("manageCarTypes");
    }

    @PostMapping("/carTypeCreate")
    public String carTypeCreate(@ModelAttribute CarType carType){
        carTypeService.addCarType(carType);
        return "redirect:/manageCarTypes";

    }

    // Route to display all contracts
    @GetMapping("/manageContracts")
    public String manageContracts(Model model) {

        model.addAttribute("contracts", carTypeService.showContracts());
        return "manageContracts"; // This should correspond to the "manageContracts.html" template
    }

    // Route to display all customers
    @GetMapping("/manageCustomers")
    public String manageCustomers(Model model) {
        model.addAttribute("customers", carTypeService.showCustomers());
        return "manageCustomers"; // This should correspond to the "manageCustomers.html" template
    }


    @PostMapping("/deleteCustomer")
    public RedirectView deleteCustomer(@RequestParam("customer_id") int customer_id){
        carTypeService.deleteCustomer(customer_id);
        return new RedirectView("/manageCustomers");
    }


    @PostMapping("/deleteContract")
    public RedirectView deleteContract(@RequestParam("rental_id") int rental_id,
                                       @RequestParam("registration_plate") String registration){
        carTypeService.deleteContract(rental_id);
        carTypeService.returnCar(registration);
        return new RedirectView("manageContracts");
    }



}
