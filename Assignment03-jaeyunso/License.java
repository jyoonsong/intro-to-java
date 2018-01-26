import java.util.*;
import java.io.*;
import java.time.*;

/**
 * Making a Driver's License and a sample DMV
 *
 * name: Jaey (Jaeyun) Song
 * class: ITP109 TTh 11AM
 * email: jaeyunso@usc.edu
 * 
 */
public class License
{
    // instance variables - replace the example below with your own
    private String firstName = "Null";
    private String lastName = "Null";
    private String state = "CA";
    private int birthDay = 11;
    private int birthMonth = 8;
    private int birthYear = 1996;
    private boolean isDonor = false;
    private final String ID_NUM;
    
    // class variable
    private static int ID_GEN = 33333;

    /**
     * Constructor for objects of class License
     */
    public License(String firstName, String lastName, String state, int birthDay, int birthMonth, int birthYear, boolean isDonor)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.isDonor = isDonor;
        this.ID_NUM = generateIDNumber();
    }
    

    /**
     * Accessor (getter) Methods
     */
    public String getFirstName(){return firstName; } 
    public String getLastName(){return lastName; }  
    public String getState(){return state; }
    public String getIDNumber(){return ID_NUM; }
    public boolean getIsDonor(){return isDonor; }
    public String getFullName(){return firstName + " " + lastName; }
    public String getBirthDate(){
        return String.format("%d/%d/%d", birthMonth, birthDay, birthYear);
    }
    
    /**
     * Mutator (setter) Methods
     */
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setState(String state){ this.state = state; }
    public void setIsDonor(boolean isDonor){ this.isDonor = isDonor; }
      
    /**
     * Method calculateAge
     *
     * @return The calculated age
     */
    public int calculateAge() {
        int age = java.time.LocalDate.now().getYear() - birthYear;
        return age;
    }
    
    /**
     * Method generateIDNumber
     *
     * @return The id number
     */
    private String generateIDNumber() {
        String firstLetter = getLastName().substring(0,1);
        String idNumber = state + "-" + String.format("%d", ID_GEN) + "-" + firstLetter;
        ID_GEN += 1;
        return idNumber;
    }
    
    /**
     * Method printLicense
     *
     */
    public void printLicense() {
        System.out.println("*********************");
        System.out.println("* Name: " + getFullName());
        System.out.println("* DL #: " + getIDNumber());
        System.out.println("* State: " + getState());
        System.out.println("* Birthday: " + getBirthDate());
        System.out.println("* Organ Donor: " + getIsDonor());
        System.out.println("*********************");
    }
    
}
