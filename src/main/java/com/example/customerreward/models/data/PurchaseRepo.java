package com.example.customerreward.models.data;

import com.example.customerreward.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase,Integer> {
}
