package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private Map<String, Customer> CollectionCustomer;

    public CustomerService(){
        CollectionCustomer = new HashMap<>();
    }

    public void addCustomer(String email, String firstName, String lastName){
        Customer newCustomer = new Customer(firstName,lastName,email);
        CollectionCustomer.put(email,newCustomer);
    }

    public Customer getCustomer(String customerEmail){
        return CollectionCustomer.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        return CollectionCustomer.values();
    }

}
