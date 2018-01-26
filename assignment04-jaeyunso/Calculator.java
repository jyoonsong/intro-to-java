import java.util.*;
import java.io.*;

// Jaeyun Song
// ITP 109, Fall 2017
// Homework 04
// jaeyunso@usc.edu

public class Calculator
{
    private int currentValue;
    private Scanner scan;
    
    public Calculator() {
        scan = new Scanner(System.in);
        currentValue = 0;
    }
     
    /**
     * Method printDirections
     *
     */
    public void printDirections() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Welcome to the command-line calculator tool");
        System.out.println("1. Works only with INTEGER numbers");
        System.out.println("2. The operators allowed are: + - * / % ^ ?");
        System.out.println("( % is for remainders, ^ for powers, and ? for a random multiplier )");
        System.out.println("Just input an operator and then the second operand like '+ 2'");
        System.out.println("--------------------------------------------------------------------");
    }
    
    // The run method controls the loop for the calculator to keep going
    // You do not need to make in changes within this method
    /**
     * Method run
     *
     */
    public void run(){
        printDirections();
        boolean keepGoing = true;
        System.out.println("Starting value: " + currentValue);
        while(keepGoing){ //code we will see soon…
            char operation = askForOperation();
            if(operation == 'q' || operation == 'Q'){ //q is the quit value
                keepGoing = false; //make the loop stop
            }
            else {
                executeOperation(operation); //do the required math
                System.out.println("Updated Value: " + currentValue);
            }
        }
    }
    
    /**
     * Method askForOperation
     *
     * @return The return value
     */
    public char askForOperation(){
         // TODO: Ask the user for the operation (or ‘q’ to quit)
         System.out.println("Please enter an operation (or 'q' to quit)");
         String userInput = scan.next();
         // Convert the string to a char answer (can assume good input)
         char userOperator = userInput.charAt(0);
         return userOperator;
    }
    
    /**
     * Method executeOperation
     *
     * @param operator A parameter
     */
    public void executeOperation(char operator){
        int val = scan.nextInt(); // the operand
        // TODO: match the operand and perform the calculation
        if ( operator == '+' ) {
            currentValue += val;
        }
        else if ( operator == '-' ) {
            currentValue -= val;
        }
        else if ( operator == '*' ) {
            currentValue *= val;
        }
        else if ( operator == '/' ) {
            currentValue /= val;
        }
        else if ( operator == '%' ) {
            currentValue %= val;
        }
        else if ( operator == '^' ) {
            double temp1 = Math.pow(currentValue, val);
            currentValue = (int) temp1;
        }
        else if ( operator == '?' ) {
            double temp2 = Math.random()*10 * currentValue;
            currentValue = (int) temp2;
        }
        else {
            System.out.println(operator + " is not recognized");
        }
        
    }
    
    //Main is here for running the program, like the book does.
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.run();
    }
}