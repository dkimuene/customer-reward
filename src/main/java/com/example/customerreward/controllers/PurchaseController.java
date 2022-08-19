package com.example.customerreward.controllers;

import com.example.customerreward.models.Purchase;
import com.example.customerreward.models.data.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
public class PurchaseController {

    @Autowired
    private PurchaseRepo purchaseRepo;

    @GetMapping("purchases")
    public List<Purchase> getPurchaseInfo(){
        return purchaseRepo.findAll();
    }
}
