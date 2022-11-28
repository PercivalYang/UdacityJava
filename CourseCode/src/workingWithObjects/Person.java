package workingWithObjects;

public class Person {
    private String firstName;
    private String lastName;
    public Person(String fName, String lName){
        firstName = fName;
        lastName = lName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setFirstName(String fName){
        firstName = fName;
    }
    public void setLastName(String lName){
        lastName = lName;
    }
    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName;
    }
    public static void main(String[] args){
        Person David = new Person("David", "Yang");
        System.out.println(David.toString());
    }
}
