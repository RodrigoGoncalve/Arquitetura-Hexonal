package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.arantes.hexagonal.application.core.usecase.DeleteCustomerByIdUserCase;
import com.arantes.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUserCase deleteCustomerByIdUserCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                                 DeleteCustomerByIdAdapter deleteCustomerByIdAdapter){
        return new DeleteCustomerByIdUserCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);

    }
}
