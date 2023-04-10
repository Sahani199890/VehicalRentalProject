package com.example.Vehicle.traveller.dao;

import com.example.Vehicle.traveller.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepo extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customer_tbl where aadhaar_card=:aadhaarCardNumber",nativeQuery = true)
    public Customer findByAadhaarCardNumber(String aadhaarCardNumber);
    public Customer findByEmail(String email);
    public Customer findByPhoneNumber(String number);

}
