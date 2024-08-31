package com.arames.hexagonal.application.ports.in;

import com.arames.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
