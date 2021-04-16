package com.example.customerservice.dto;

public class CustomerDto{
    private String accountId;
    private String firstName;
    private String lastName;
    private double amount;
    public CustomerDto(String accountId, String firstName, String lastName, double amount) {
        super();
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
    }
    public CustomerDto() {
        super();
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
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