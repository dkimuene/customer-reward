package com.example.customerreward.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends AbstractEntity{

    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases = new java.util.ArrayList<>();

    public Customer(){}

    public Customer(String firstName, String lastName, List<Purchase> purchases ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchases = purchases;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
