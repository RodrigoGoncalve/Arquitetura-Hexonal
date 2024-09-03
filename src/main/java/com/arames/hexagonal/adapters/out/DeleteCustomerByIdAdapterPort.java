package com.arames.hexagonal.adapters.out;

import com.arames.hexagonal.adapters.out.repository.CustomerRepository;
import com.arames.hexagonal.application.ports.out.DeleteCustomerByIdOutimputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapterPort implements DeleteCustomerByIdOutimputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
