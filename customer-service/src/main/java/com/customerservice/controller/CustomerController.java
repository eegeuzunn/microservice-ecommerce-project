package com.customerservice.controller;

import com.customerservice.dto.CustomerDto;
import com.customerservice.dto.request.CustomerPostRequest;
import com.customerservice.model.Customer;
import com.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getACustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getACustomerById(id));
    }

    @PostMapping
    public ResponseEntity<URI> postACustomer(@RequestBody CustomerPostRequest customerPostRequest) {
        URI location = UriComponentsBuilder
                .fromPath("api/v1/customers/{id}")
                .buildAndExpand(customerService.postACustomer(customerPostRequest))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteACustomerById(@PathVariable Long id){
        customerService.deleteACustomerById(id);
        return ResponseEntity.ok(null);
    }
}
