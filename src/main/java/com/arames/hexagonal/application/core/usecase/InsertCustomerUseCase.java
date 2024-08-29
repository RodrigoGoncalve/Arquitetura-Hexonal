package com.arames.hexagonal.application.core.usecase;

import com.arames.hexagonal.application.core.domain.Customer;
import com.arames.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arames.hexagonal.application.ports.out.InsertCustomeroutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomeroutputPort insertCustomeroutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomeroutputPort insertCustomeroutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomeroutputPort = insertCustomeroutputPort;
    }

    public void insert(Customer customer, String zipCode){
        var adrees = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(adrees);
        insertCustomeroutputPort.insert(customer);
    }
}
