package com.customerservice.service;

import com.customerservice.dto.AddressDto;
import com.customerservice.dto.converter.AddressConverter;
import com.customerservice.dto.request.AddressPostRequest;
import com.customerservice.model.Address;
import com.customerservice.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressConverter addressConverter;
    private final CustomerService customerService;
    public AddressService(AddressRepository addressRepository, AddressConverter addressConverter, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
        this.customerService = customerService;
    }

    public List<AddressDto> getAddressesOfACustomer(Long customerId) {

        if(!customerService.isCustomerExist(customerId)){
            throw new EntityNotFoundException("Customer not found");
        }
        return addressRepository.findByCustomerId(customerId)
                .stream()
                .map(addressConverter::toAddressDto)
                .collect(Collectors.toList());
    }

    public void deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new EntityNotFoundException("Address not found"));
        addressRepository.delete(address);
    }

    public String createAddress(AddressPostRequest addressPostRequest, Long customerId) {
        Address address = new Address(
                null,
                addressPostRequest.getCity(),
                addressPostRequest.getCountry(),
                addressPostRequest.getStreet(),
                addressPostRequest.getZipCode(),
                addressPostRequest.getAddressType(),
                addressPostRequest.getDescription(),
                customerService.getCustomer(customerId)
        );
        addressRepository.save(address);
        return address.getId().toString();
    }
}
