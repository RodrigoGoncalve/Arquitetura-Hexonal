package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.ports.in.DeleteCustomerByIdImputPort;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdImputPort;
import com.arantes.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUserCase implements DeleteCustomerByIdImputPort {

    private final FindCustomerByIdImputPort findCustomerByIdImputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUserCase(FindCustomerByIdImputPort findCustomerByIdImputPort,
                                      DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdImputPort = findCustomerByIdImputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdImputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
