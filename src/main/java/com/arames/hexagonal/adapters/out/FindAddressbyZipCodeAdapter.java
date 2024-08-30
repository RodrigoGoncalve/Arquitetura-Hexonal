package com.arames.hexagonal.adapters.out;

import com.arames.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.arames.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.arames.hexagonal.application.core.domain.Address;
import com.arames.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
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
