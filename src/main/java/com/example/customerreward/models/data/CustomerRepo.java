package com.example.customerreward.models.data;

import com.example.customerreward.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo  extends JpaRepository<Customer, Integer> {
}
