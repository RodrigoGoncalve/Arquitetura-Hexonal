package com.arantes.hexagonal.application.ports.out;

public interface SendCpfForvalidationOutPort {

    void send(String cpf);
}
