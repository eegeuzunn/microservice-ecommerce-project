package com.customerservice.service;

import com.customerservice.dto.CustomerDto;
import com.customerservice.dto.converter.CustomerConverter;
import com.customerservice.dto.request.CustomerPostRequest;
import com.customerservice.model.Customer;
import com.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter  customerConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerConverter customerConverter) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    public String postACustomer(CustomerPostRequest customerPostRequest) {
        Customer customer = new Customer(
                customerPostRequest.getEmail(),
                customerPostRequest.getPassword(),
                customerPostRequest.getFirstName(),
                customerPostRequest.getLastName()
        );
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer.getId().toString();
    }

    public CustomerDto getACustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerConverter.toCustomerDto(customer);
    }

    public void deleteACustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }

    protected boolean isCustomerExist(Long id) {
        return customerRepository.existsById(id);
    }
    protected Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
