package com.arames.hexagonal.application.ports.out;

import com.arames.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
