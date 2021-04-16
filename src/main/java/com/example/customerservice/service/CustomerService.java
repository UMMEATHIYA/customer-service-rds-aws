package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.model.CustomerModel;

import java.util.List;

public interface  CustomerService {
    public CustomerDto createCustomer(CustomerDto accountDto);
    public CustomerDto findByCustomerId(String accountId);
    public List<CustomerModel> getAllCustomerDetails();
    public CustomerModel updateCustomer(String accountId, CustomerDto accountDto);
    public Integer deleteByCustomerId(String accountId);
    public List<CustomerModel> getCustomerByFirstName(String firstName);
    public List<CustomerModel> getCustomerByLastName(String lastName);
}
