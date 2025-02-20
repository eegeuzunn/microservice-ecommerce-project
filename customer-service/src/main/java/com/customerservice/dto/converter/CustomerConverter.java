package com.customerservice.dto.converter;

import com.customerservice.dto.CustomerDto;
import com.customerservice.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerConverter {

    private final AddressConverter addressConverter;

    public CustomerConverter(AddressConverter addressConverter) {
        this.addressConverter = addressConverter;
    }

    public CustomerDto toCustomerDto(Customer customer) {
        if( customer == null ) return null;

        return new CustomerDto(
                customer.getId(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddresses().stream().map(addressConverter::toAddressDto).collect(Collectors.toList())
        );
    }

}
