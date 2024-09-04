package com.arames.hexagonal.adapters.in.controller;

import com.arames.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arames.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.arames.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arames.hexagonal.application.core.domain.Customer;
import com.arames.hexagonal.application.ports.in.DeleteCustomerByIdImputPort;
import com.arames.hexagonal.application.ports.in.FindCustomerByIdImputPort;
import com.arames.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arames.hexagonal.application.ports.in.UpdateCustomerImputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdImputPort findCustomerByIdImputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UpdateCustomerImputPort updateCustomerImputPort;

    @Autowired
    private DeleteCustomerByIdImputPort deleteCustomerByIdImputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id){
        var customer = findCustomerByIdImputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id,@Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerImputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteCustomerByIdImputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
