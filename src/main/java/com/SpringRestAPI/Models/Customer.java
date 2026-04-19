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

    public void setCustomerName() {
        if (customerName.isEmpty()) {
            System.out.println("Customer name is cannot be empty");
        }
        else {
            this.customerName = customerName;
        }
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        if (!customerEmail.contains("@") ||
            !customerEmail.contains(".") ||
            customerEmail.contains(" ")) {
            System.out.println("Customer email is invalid");
        } else {
            this.customerEmail = customerEmail;
        }
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        if (customerAge < 18) {
            System.out.println("Sorry, you must be at least 18!");
        } else {
            this.customerAge = customerAge;
        }
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        if (customerAddress.isEmpty()) {
            System.out.println("Customer address is cannot be empty");
        } else {
            this.customerAddress = customerAddress;
        }
    }
}
