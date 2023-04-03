public class Person{

    //Instance Field
    private String firstName;
    private String lastName;
    private String SSN;

    //Constructor
    public Person(String firstName, String lastName, String SSN){
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    //Method Returning a String Reference
    public String toString(){
        String personInfo = "";
        personInfo += firstName  + " : " + lastName + " : " + SSN;
        return (personInfo);
    }
}