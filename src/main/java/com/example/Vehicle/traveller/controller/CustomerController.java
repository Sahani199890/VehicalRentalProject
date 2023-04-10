package com.example.Vehicle.traveller.controller;

import com.example.Vehicle.traveller.dto.CustomerDTO;
import com.example.Vehicle.traveller.model.Customer;
import com.example.Vehicle.traveller.service.CustomerService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("SignUp")
    public ResponseEntity<String> signup(@Valid @RequestBody Customer customer) {
        JSONObject jsonObject = customerService.addCustomer(customer);
        if(jsonObject.isEmpty()) {
            return new ResponseEntity<>("SignedUp successfully with userId-->" + customer.getId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.BAD_REQUEST);
    }
    @PostMapping("SignIn")
    public ResponseEntity<String> signIn(@RequestBody CustomerDTO customerDTO){
        boolean isPresent = customerService.signIn(customerDTO);
        if(isPresent){
            return new ResponseEntity<>("Login successful you can access vehicles",HttpStatus.FOUND);
        }
        return new ResponseEntity<>("login failed please check password and userId",HttpStatus.NOT_FOUND);
    }

}
