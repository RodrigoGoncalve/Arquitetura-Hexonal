package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.arantes.hexagonal.application.ports.out.SendCpfForvalidationOutPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomeroutputPort;
    private final SendCpfForvalidationOutPort sendCpfForvalidationOutPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomeroutputPort,
                                 SendCpfForvalidationOutPort sendCpfForvalidationOutPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomeroutputPort = insertCustomeroutputPort;
        this.sendCpfForvalidationOutPort = sendCpfForvalidationOutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var adrees = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(adrees);
        insertCustomeroutputPort.insert(customer);
        sendCpfForvalidationOutPort.send(customer.getCpf());
    }
}
