package com.arames.hexagonal.config;

import com.arames.hexagonal.adapters.out.FindAddressbyZipCodeAdapter;
import com.arames.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arames.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressbyZipCodeAdapter findAddressbyZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter){
        return new InsertCustomerUseCase(findAddressbyZipCodeAdapter, insertCustomerAdapter);
    }

}
