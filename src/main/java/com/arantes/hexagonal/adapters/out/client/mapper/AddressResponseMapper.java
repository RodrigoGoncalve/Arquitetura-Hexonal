package com.arantes.hexagonal.adapters.out.client.mapper;

import com.arantes.hexagonal.adapters.out.client.response.AddressResponse;
import com.arantes.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
