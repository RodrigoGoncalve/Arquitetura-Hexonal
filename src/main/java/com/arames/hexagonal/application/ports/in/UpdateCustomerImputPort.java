package com.arames.hexagonal.application.ports.in;

import com.arames.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerImputPort {

    void update(Customer customer, String zipCode);
}
