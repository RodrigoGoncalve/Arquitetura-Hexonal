package com.arames.hexagonal.application.core.usecase;

import com.arames.hexagonal.application.ports.in.FindCustomerByIdImputPort;
import com.arames.hexagonal.application.ports.out.DeleteCustomerByIdOutimput;

public class DeleteCustomerByIdUserCase {

    private final FindCustomerByIdImputPort findCustomerByIdImputPort;
    private final DeleteCustomerByIdOutimput deleteCustomerByIdOutimput;

    public DeleteCustomerByIdUserCase(FindCustomerByIdImputPort findCustomerByIdImputPort, DeleteCustomerByIdOutimput deleteCustomerByIdOutimput) {
        this.findCustomerByIdImputPort = findCustomerByIdImputPort;
        this.deleteCustomerByIdOutimput = deleteCustomerByIdOutimput;
    }

    public void delete(String id){
        findCustomerByIdImputPort.find(id);
        deleteCustomerByIdOutimput.delete(id);
    }
}
