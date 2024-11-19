package com.mbi.los.dao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRepository;

    public void saveCustomerDetails(LoanApplication customer) {
        customerRepository.save(customer);
    }
}
