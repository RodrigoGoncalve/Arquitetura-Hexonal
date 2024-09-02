package com.arames.hexagonal.adapters.out;

import com.arames.hexagonal.adapters.out.repository.CustomerRepository;
import com.arames.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arames.hexagonal.application.core.domain.Customer;
import com.arames.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper  customerEntityMapper;


    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}