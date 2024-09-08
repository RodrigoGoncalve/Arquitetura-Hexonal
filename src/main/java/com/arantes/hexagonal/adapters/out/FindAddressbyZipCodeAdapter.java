package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.arantes.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.arantes.hexagonal.application.core.domain.Address;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressbyZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {

        var addressresponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressresponse);
    }
}
