package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.model.CustomerModel;
import com.example.customerservice.repo.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto accountDto) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model = mapper.map(accountDto, CustomerModel.class);
        customerRepository.save(model);
        CustomerDto dto= mapper.map(model, CustomerDto.class);
        return dto;
    }

    @Override
    public CustomerDto findByCustomerId(String accountId) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=customerRepository.findByAccountId(accountId);
        if(model==null)
        {
            return null;
        }
        else
        {
            CustomerDto dto=mapper.map(model, CustomerDto.class);
            return dto;
        }

    }

    @Override
    public List<CustomerModel> getAllCustomerDetails() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerModel updateCustomer(String accountId, CustomerDto accountDto) {
        CustomerModel accountModel = customerRepository.findByAccountId(accountId);
        accountModel.setFirstName(accountDto.getFirstName());
        accountModel.setLastName(accountDto.getLastName());
        accountModel.setAmount(accountDto.getAmount());
        ModelMapper mapper = new ModelMapper();
        CustomerModel model = mapper.map(accountDto, CustomerModel.class);
        return customerRepository.save(model);
    }

    @Override
    @Transactional
    public Integer deleteByCustomerId(String accountId) {
        return customerRepository.deleteByAccountId(accountId);
    }

    @Override
    public List<CustomerModel> getCustomerByFirstName(String firstName) {
        List<CustomerModel> customers=customerRepository.findByFirstName(firstName);
        return customers;
    }

    @Override
    public List<CustomerModel> getCustomerByLastName(String lastName) {
        List<CustomerModel> customers=customerRepository.findByLastName(lastName);
        return customers;
    }
}