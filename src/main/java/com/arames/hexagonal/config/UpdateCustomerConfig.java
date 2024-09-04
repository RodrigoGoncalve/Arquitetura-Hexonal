package com.arames.hexagonal.config;

import com.arames.hexagonal.adapters.out.FindAddressbyZipCodeAdapter;
import com.arames.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.arames.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.arames.hexagonal.application.core.usecase.UpdateCustomerUserCase;
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
