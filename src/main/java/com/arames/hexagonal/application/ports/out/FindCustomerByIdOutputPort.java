package com.arames.hexagonal.application.ports.out;

import com.arames.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer>find(String id);
}
