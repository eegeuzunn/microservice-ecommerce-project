package com.customerservice.dto.converter;

import com.customerservice.dto.AddressDto;
import com.customerservice.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public AddressDto toAddressDto(Address address){
        if(address == null) return null;
        return new AddressDto(
                address.getId(),
                address.getCity(),
                address.getCountry(),
                address.getStreet(),
                address.getZipCode(),
                address.getAddressType(),
                address.getDescription()
        );
    }
}
