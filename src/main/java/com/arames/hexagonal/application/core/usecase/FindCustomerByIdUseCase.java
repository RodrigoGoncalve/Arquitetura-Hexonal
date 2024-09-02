package com.arames.hexagonal.application.core.usecase;

import com.arames.hexagonal.application.core.domain.Customer;
import com.arames.hexagonal.application.ports.in.FindCustomerByIdImputPort;
import com.arames.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdImputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort
                .find(id).orElseThrow(() -> new RuntimeException("Customer no fund"));
    }
}
