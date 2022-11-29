package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String emailRegx = "^(.+)@(.+).(.+)";
    private Pattern pattern = Pattern.compile(emailRegx);

    public String getName(){
        return firstName + " " + lastName;
    }

    public Customer(String firstName, String lastName, String email) {
        if (!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Wrong Email format");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + "\n  \\_email: " + email;
    }

}
