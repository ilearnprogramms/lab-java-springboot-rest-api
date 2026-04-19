package com.SpringRestAPI.Services;

import com.SpringRestAPI.Models.Customer;
import com.SpringRestAPI.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customers;

    public CustomerService() {
        setCustomerList();
    }

    // creating customers
    public void setCustomerList() {
        customers = new ArrayList<>();

        customers.add(new Customer("Eren", "eren@test.com", 20, "Hamburg, Germany"));
        customers.add(new Customer("Mikasa", "mikasa@test.com", 20, "Berlin, Germany"));
        customers.add(new Customer("Armin", "armin@test.com", 20, "Leipzig, Germany"));
    }

    // get all customers
    public List<Customer> getCustomers() {
        return customers;
    }

    // get customer by email
    public List<Customer> getCustomerByEmail(String email) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCustomerEmail().equals(email)) {
                customerList.add(customer);
            }
        }
        return customerList;
    }

    // update customer
    public Customer updateCustomerName(String currentName, String newName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equalsIgnoreCase(currentName)) {
                customer.setCustomerName();
                return customer;
            }
        }
        throw new RuntimeException("Product not found");
    }




}
