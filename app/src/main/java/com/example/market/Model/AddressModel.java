package com.example.market.Model;

public class AddressModel  {

    private String address ;
    private String governorate;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public AddressModel(String address, String governorate) {
        this.address = address;
        this.governorate = governorate;
    }
}