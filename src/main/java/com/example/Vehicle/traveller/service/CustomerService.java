package com.example.Vehicle.traveller.service;

import com.example.Vehicle.traveller.dao.ICustomerRepo;
import com.example.Vehicle.traveller.dto.CustomerDTO;
import com.example.Vehicle.traveller.model.Customer;
import com.example.Vehicle.traveller.utils.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private ICustomerRepo iCustomerRepo;
    @Autowired
    private Util util;
    public JSONObject addCustomer(Customer customer) {
        JSONObject validation = util.validation(customer);
        if (validation.isEmpty()) {
            iCustomerRepo.save(customer);
        }
        return validation;
    }

    public boolean signIn(CustomerDTO customerDTO) {
        Customer customer = iCustomerRepo.findById(customerDTO.getUserId()).get();
        return customer.getPassword().equals(customerDTO.getPassword());
    }
}
