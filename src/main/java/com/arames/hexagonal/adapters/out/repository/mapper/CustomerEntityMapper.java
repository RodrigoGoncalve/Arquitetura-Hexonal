package com.arames.hexagonal.adapters.out.repository.mapper;

import com.arames.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arames.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}


