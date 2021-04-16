package com.example.customerservice.shared;

public class CustomerRequestModel {
    private String firstName;
    private String lastName;
    private double amount;
    public CustomerRequestModel() {
        super();
    }
    public CustomerRequestModel(String firstName, String lastName, double amount) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}