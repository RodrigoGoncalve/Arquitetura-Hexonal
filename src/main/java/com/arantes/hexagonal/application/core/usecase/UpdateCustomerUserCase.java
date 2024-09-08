package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdImputPort;
import com.arantes.hexagonal.application.ports.in.UpdateCustomerImputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUserCase implements UpdateCustomerImputPort {

    private final FindCustomerByIdImputPort findCustomerByIdImputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUserCase(FindCustomerByIdImputPort findCustomerByIdImputPort,
                                  FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                  UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdImputPort = findCustomerByIdImputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdImputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
