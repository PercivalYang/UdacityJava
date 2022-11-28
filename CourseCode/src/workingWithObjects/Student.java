package workingWithObjects;

public class Student extends Person{
    private String studentID;
    private String firstName;
    private String lastName;
    public Student(String fName, String lName, String ID){
        super(fName,lName);
        studentID=ID;
    }
    public String getStudentID(){
        return studentID;
    }
    public void setStudentID(String ID){
        studentID = ID;
    }
    @Override
    public String toString(){
        return super.toString() + ", Student ID: " + studentID;
    }
    public static void main(String[] args){
        Student David = new Student("David", "Yang", "1234");
        System.out.println(David.toString());
    }
}
