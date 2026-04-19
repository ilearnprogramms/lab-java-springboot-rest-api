package com.SpringRestAPI.Models;

public class Customer {

    private String customerName;
    private String customerEmail;
    private int customerAge;
    private String customerAddress;

    public Customer(String customerName, String customerEmail, int customerAge, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAge = customerAge;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name is cannot be empty");
        }
        else {
            this.customerName = customerName;
        }
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        if (customerEmail == null ||
            !customerEmail.contains("@") ||
            !customerEmail.contains(".") ||
            customerEmail.contains(" ")) {
            throw new IllegalArgumentException("Customer email is invalid");
        } else {
            this.customerEmail = customerEmail;
        }
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        if (customerAge < 18) {
            throw new IllegalArgumentException("Sorry, you must be at least 18!");
        } else {
            this.customerAge = customerAge;
        }
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        if (customerAddress == null || customerAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer address is cannot be empty");
        } else {
            this.customerAddress = customerAddress;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAge=" + customerAge +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
