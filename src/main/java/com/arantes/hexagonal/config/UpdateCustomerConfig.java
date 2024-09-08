package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.out.FindAddressbyZipCodeAdapter;
import com.arantes.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.arantes.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.arantes.hexagonal.application.core.usecase.UpdateCustomerUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUserCase updateCustomerUserCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                         FindAddressbyZipCodeAdapter findAddressbyZipCodeAdapter,
                                                         UpdateCustomerAdapter updateCustomerAdapter){

        return new UpdateCustomerUserCase(findCustomerByIdUseCase, findAddressbyZipCodeAdapter, updateCustomerAdapter);
    }
}
