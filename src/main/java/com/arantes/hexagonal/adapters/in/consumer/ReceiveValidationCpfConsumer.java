package com.arantes.hexagonal.adapters.in.consumer;

import com.arantes.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.arantes.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.arantes.hexagonal.application.ports.in.UpdateCustomerImputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidationCpfConsumer {

    @Autowired
    private UpdateCustomerImputPort updateCustomerImputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerImputPort.update(customer, customerMessage.getZipCode());
    }
}
