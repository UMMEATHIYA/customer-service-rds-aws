package com.example.customerservice.shared;

public class CustomerResponseModel {
    private String accountId;
    private String firstName;
    private String lastName;
    private String amount;
    public CustomerResponseModel() {
        super();
    }
    public CustomerResponseModel(String accountId, String firstName, String lastName, String amount) {
        super();
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
