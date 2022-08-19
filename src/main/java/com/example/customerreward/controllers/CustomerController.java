package com.example.customerreward.controllers;

import com.example.customerreward.models.Customer;
import com.example.customerreward.models.data.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("customers")
    public List<Customer> getCustomerInfo(){
        return customerRepo.findAll();
    }

}
