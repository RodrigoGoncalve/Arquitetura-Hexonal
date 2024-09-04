package com.arames.hexagonal.config;

import com.arames.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.arames.hexagonal.application.core.usecase.DeleteCustomerByIdUserCase;
import com.arames.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
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
