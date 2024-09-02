package com.arames.hexagonal.application.ports.in;

import com.arames.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdImputPort {

    Customer find(String id);
}
