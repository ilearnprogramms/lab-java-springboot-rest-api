package com.SpringRestAPI.Controllers;


import com.SpringRestAPI.Models.Customer;
import com.SpringRestAPI.Services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // create new customer
    @PostMapping("/customer")
    public String addNewCustomer(@RequestBody Customer customer ) {
        Logger myLogger = Logger.getLogger("CustomerController new customer");
        myLogger.info("Adding new customer ");

        return customerService.addNewCustomer(
                customer.getCustomerName(),
                customer.getCustomerEmail(),
                customer.getCustomerAge(),
                customer.getCustomerAddress()
        );
    }

    // get all customer
    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        Logger myLogger = Logger.getLogger("CustomerService get all customers");
        myLogger.info("Getting all customers");

        return customerService.getCustomers();
    }

    // get customer by email
    @GetMapping("/customer/{customerEmail}")
    public List<Customer> getCustomers(@PathVariable String customerEmail) {
        Logger myLogger = Logger.getLogger("CustomerService getting customer by email");
        myLogger.info("Getting customer by email");

        return customerService.getCustomerByEmail(customerEmail);
    }

    // update customer name
    @PutMapping("/customer/{currentName}/{newName}")
    public Customer updateCustomerName(@PathVariable String currentName, @PathVariable String newName) {
        Logger myLogger = Logger.getLogger("CustomerController update customer name");
        myLogger.info("Updating customer name");

        return customerService.updateCustomerName(currentName, newName);
    }

    // delete customer
    @DeleteMapping("/customer/{customerName}")
    public List<Customer> deleteCustomer(@PathVariable String customerName) {
        Logger myLogger = Logger.getLogger("CustomerController delete customer name");
        myLogger.info("Deleting customer name");

        return customerService.deleteCustomer(customerName);
    }




}
