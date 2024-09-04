package com.arames.hexagonal.application.core.usecase;

import com.arames.hexagonal.application.ports.in.FindCustomerByIdImputPort;
import com.arames.hexagonal.application.ports.out.DeleteCustomerByIdOutimputPort;

public class DeleteCustomerByIdUserCase implements DeleteCustomerByIdOutimputPort{

    private final FindCustomerByIdImputPort findCustomerByIdImputPort;
    private final DeleteCustomerByIdOutimputPort deleteCustomerByIdOutimputPort;

    public DeleteCustomerByIdUserCase(FindCustomerByIdImputPort findCustomerByIdImputPort,
                                      DeleteCustomerByIdOutimputPort deleteCustomerByIdOutimputPort) {
        this.findCustomerByIdImputPort = findCustomerByIdImputPort;
        this.deleteCustomerByIdOutimputPort = deleteCustomerByIdOutimputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdImputPort.find(id);
        deleteCustomerByIdOutimputPort.delete(id);
    }
}
