package com.customerservice.dto.request;

public class AddressPostRequest {
    private String city;
    private String country;
    private String street;
    private String zipCode;
    private String addressType;
    private String description;

    public AddressPostRequest() {
    }

    public AddressPostRequest(String city, String country, String street, String zipCode, String addressType, String description) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.zipCode = zipCode;
        this.addressType = addressType;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
