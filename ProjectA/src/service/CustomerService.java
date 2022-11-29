package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private List<Customer> customers;
    private static CustomerService customerService = null;

    private CustomerService() {
        customers=new ArrayList<>();
    }

    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }


    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
    }

    public Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        System.out.println("Not found custmoers!");
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return customers;
    }

}
