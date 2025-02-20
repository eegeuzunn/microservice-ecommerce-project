package com.customerservice.controller;

import com.customerservice.dto.AddressDto;
import com.customerservice.dto.request.AddressPostRequest;
import com.customerservice.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/customers/{customerId}")
    public List<AddressDto> getAddressesOfACustomer(Long customerId) {
        return addressService.getAddressesOfACustomer(customerId);
    }

    @PostMapping("/customers/{customerId}")
    public URI createAddress(AddressPostRequest addressPostRequest, Long customerId) {
        String addressId = addressService.createAddress(addressPostRequest, customerId);
        return UriComponentsBuilder
                .fromPath("api/v1/address/{id}")
                .buildAndExpand(addressId)
                .toUri();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok(null);
    }

}
