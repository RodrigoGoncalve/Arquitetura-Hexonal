package com.arames.hexagonal.application.ports.out;

import com.arames.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}