package com.arames.hexagonal.application.core.usecase;

import com.arames.hexagonal.application.core.domain.Customer;
import com.arames.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arames.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arames.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomeroutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomeroutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomeroutputPort = insertCustomeroutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var adrees = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(adrees);
        insertCustomeroutputPort.insert(customer);
    }
}
