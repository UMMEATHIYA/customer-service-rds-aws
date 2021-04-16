package com.example.customerservice.repo;

import com.example.customerservice.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {
    @Query
    public CustomerModel findByAccountId(String accountId);
    @Query
    public Integer deleteByAccountId(String accountId);
    @Query
    public List<CustomerModel> findByFirstName(String firstName);
    @Query
    public List<CustomerModel> findByLastName(String lastName);
}