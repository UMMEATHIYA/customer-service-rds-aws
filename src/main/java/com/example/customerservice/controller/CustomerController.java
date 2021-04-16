package com.example.customerservice.controller;

import com.example.customerservice.Exception.CustomerNotFoundException;
import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.model.CustomerModel;
import com.example.customerservice.service.CustomerService;
import com.example.customerservice.shared.CustomerRequestModel;
import com.example.customerservice.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseModel> createAccount(@RequestBody CustomerRequestModel customerRequestModel)
    {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto customerDto=mapper.map(customerRequestModel, CustomerDto.class);
        customerDto.setAccountId(UUID.randomUUID().toString());
        CustomerDto response= customerService.createCustomer(customerDto);
        CustomerResponseModel model=mapper.map(response, CustomerResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);

    }
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerResponseModel> getAccountByCustomerId(@PathVariable("customerId") String customerId)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto dto=customerService.findByCustomerId(customerId);
        if(dto==null)
        {
            throw new CustomerNotFoundException("no such account with id: "+customerId);
        }
        CustomerResponseModel response=mapper.map(dto, CustomerResponseModel.class);
        return ResponseEntity.ok(response);
    }


    //get all the details
    @GetMapping("/customers/details")
    public List<CustomerDto> getAllCustomerDetails() {
        ModelMapper mapper=new ModelMapper();
        return customerService.getAllCustomerDetails().stream().map(post -> mapper.map(post, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<CustomerResponseModel> updateCustomer(@PathVariable String customerId, @RequestBody CustomerRequestModel customerRequestModel) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerDto customerDto1 = mapper.map(customerRequestModel, CustomerDto.class);
        CustomerModel response = customerService.updateCustomer(customerId, customerDto1);
        CustomerResponseModel model = mapper.map(response, CustomerResponseModel.class);

        return ResponseEntity.ok().body(model);
    }


    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Integer> deleteCustomer(@PathVariable("customerId") String customerId) {

        Integer result=customerService.deleteByCustomerId(customerId);
        if(result<1)
        {
            throw new CustomerNotFoundException("no account found.");
        }
        return ResponseEntity.ok(result);

    }

    @GetMapping("/customers/firstName/{firstName}")
    public ResponseEntity<List<CustomerResponseModel>> getByfirstName(@PathVariable("firstName") String firstName)
    {
        List<CustomerModel> list=customerService.getCustomerByFirstName(firstName);
        List<CustomerResponseModel> responses=new ArrayList<CustomerResponseModel>();
        Iterator<CustomerModel> i=list.iterator();
        while(i.hasNext())
        {
            CustomerModel m=i.next();
            CustomerResponseModel model=new CustomerResponseModel();
            model.setAccountId(m.getAccountId());
            model.setFirstName(m.getFirstName());
            model.setLastName(m.getLastName());
            model.setAmount(String.valueOf(m.getAmount()));
            responses.add(model);
        }
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/customers/lastName/{lastName}")
    public ResponseEntity<List<CustomerResponseModel>> getBylastName(@PathVariable("lastName") String lastName)
    {
        List<CustomerModel> list=customerService.getCustomerByLastName(lastName);
        List<CustomerResponseModel> responses=new ArrayList<CustomerResponseModel>();
        Iterator<CustomerModel> i=list.iterator();
        while(i.hasNext())
        {
            CustomerModel m=i.next();
            CustomerResponseModel model=new CustomerResponseModel();
            model.setAccountId(m.getAccountId());
            model.setFirstName(m.getFirstName());
            model.setLastName(m.getLastName());
            model.setAmount(String.valueOf(m.getAmount()));
            responses.add(model);
        }
        return ResponseEntity.ok(responses);
    }
}
