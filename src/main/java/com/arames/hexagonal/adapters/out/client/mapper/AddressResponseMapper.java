package com.arames.hexagonal.adapters.out.client.mapper;

import com.arames.hexagonal.adapters.out.client.response.AddressResponse;
import com.arames.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
