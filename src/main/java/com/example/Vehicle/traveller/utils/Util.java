package com.example.Vehicle.traveller.utils;

import com.example.Vehicle.traveller.dao.ICustomerRepo;
import com.example.Vehicle.traveller.model.Customer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class Util {
    @Autowired
    ICustomerRepo iCustomerRepo;
    public int bicycleQuantity=50;
    public int bikeQuantity=40;
    public int carQuantity=30;
    String availableBicycles(int size){
        if(size>bicycleQuantity){
            return "We have limited bicycles-->"+bicycleQuantity;
        }
        return String.valueOf(bicycleQuantity - size);
    }
    String availableBike(int size){
        if(bicycleQuantity<size){
            return "We have limited bikes-->"+bikeQuantity;
        }
        return String.valueOf(bikeQuantity - size);
    }
    String availableCars(int size){
        if(carQuantity<size){
            return "We have limited cars-->"+carQuantity;
        }
        return String.valueOf(carQuantity - size);
    }
    public HashMap<String,Integer> vehiclePricing=new HashMap<>();
    {
        vehiclePricing.put("bicycle",3);
        vehiclePricing.put("bike",10);
        vehiclePricing.put("car",15);
    }

    public JSONObject validation(Customer customer) {
        JSONObject json = new JSONObject();
        if (iCustomerRepo.findByAadhaarCardNumber(customer.getAadhaarCardNumber()) != null) {
            json.put("aadhaarCardNumber", "AadhaarCardNumber already Exists");
        }
        if (iCustomerRepo.findByEmail(customer.getEmail()) != null) {
            json.put("email", "Email already Exists");
        }
        if (iCustomerRepo.findByPhoneNumber(customer.getPhoneNumber()) != null) {
            json.put("phoneNumber", "PhoneNumber already Exists");
        } else {
            iCustomerRepo.save(customer);
        }
        return json;
    }
}
