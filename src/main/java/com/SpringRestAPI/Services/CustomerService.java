package com.SpringRestAPI.Services;

import com.SpringRestAPI.Models.Customer;
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

    // add new customer
    public String addNewCustomer(String customerName, String customerEmail, int customerAge, String customerAddress) {
        customers.add(new Customer(customerName, customerEmail, customerAge, customerAddress));
        return "new customer added";
    }

    // get customer by email
    public List<Customer> getCustomerByEmail(String email) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCustomerEmail().equalsIgnoreCase(email)) {
                customerList.add(customer);
            }
        }
        return customerList;
    }

    // update customer
    public Customer updateCustomerName(String currentName, String newName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equalsIgnoreCase(currentName)) {
                customer.setCustomerName(newName);
                return customer;
            }
        }
        throw new RuntimeException("Customer not found");
    }

    // delete customer
    public List<Customer> deleteCustomer (String customerName){
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                customers.remove(customer);
            }
        }
        return customers;
    }





}
