package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private Map<String, Customer> CollectionCustomer;
    private static CustomerService customerService = null;
    private CustomerService(){
        CollectionCustomer = new HashMap<>();
    }
    public static CustomerService getInstance(){
        if (customerService == null){
            customerService = new CustomerService();
        }
        return customerService;
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

    public static void main(String[] args){
        CustomerService c = new CustomerService();
        CustomerService b = new CustomerService();
        System.out.println("Done");
    }

}
