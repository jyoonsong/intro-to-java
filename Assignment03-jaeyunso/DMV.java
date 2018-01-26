import java.util.Scanner;
//Your Name
//ITP 109, Fall 2017
//Assignment 03
//USC email
public class DMV {
     public DMV() {
         System.out.println("DMV constructed and open for business!");
     }
    
     public void runSimulation() {
         System.out.println("Welcome to the DMV");
         License driver = inputDriverInformation();
         System.out.println("New driver license entered: \n");
         driver.printLicense();
     }
    
     private License inputDriverInformation() {
         String firstName = "null";
         String lastName = "null";
         String state = "CA";
         int birthDay = 11;
         int birthMonth = 8;
         int birthYear = 1996;
         boolean isDonor = false;
         
         Scanner input = new Scanner(System.in);
         License lic; //local object that will hold the new license
         //All the questions you need to get info for:
         System.out.println("Enter first name:");
         firstName = input.nextLine();
         System.out.println("Enter last name:");
         lastName = input.nextLine();
         System.out.println("Enter birth year:");
         birthYear = input.nextInt();
         System.out.println("Enter birth month: (1-12)");
         birthMonth = input.nextInt();
         System.out.println("Enter birth date:");
         birthDay = input.nextInt();
         System.out.println("Enter state (2 letter abbreviation):");
         input.nextLine(); // flush
         state = input.nextLine();
         System.out.println("Volunteer to be an organ donor? (true or false)");
         isDonor = input.nextBoolean();
         
         //Update the line below to use the data you collected from the user
         lic = new License(firstName, lastName, state, birthDay, birthMonth, birthYear, isDonor); //sample data
         return lic; //return the object that you created
     }
     
     /* Main is here for running the program one time, like book does. This example has code
     we haven't seen yet in order to loop the program. In BlueJ, you can call the runSimulation
     method as many times as you want, but from main, it will only happen once.
     */
     public static void main(String[] args) {
         DMV myDMV = new DMV();
         Scanner sc = new Scanner(System.in);
         boolean stillTakingCustomers = true;
         while(stillTakingCustomers) {
             myDMV.runSimulation();
             System.out.println("Type 'q' to quit, any other key to keep going");
             String temp = sc.nextLine();
             if(temp.equalsIgnoreCase("q")) {
                 stillTakingCustomers = false;
             }
         }
     }
}