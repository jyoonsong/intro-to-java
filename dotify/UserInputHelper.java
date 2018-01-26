import java.util.ArrayList;
import java.util.Scanner;


/**
 * Course: ITP-109
 * Author: Kendra Walther
 * Date: Fall 2015
 *
 */
public class UserInputHelper {

    private String options;
    private String prompt;
    private int min;
    private int max;
    private int QUIT_VALUE;

    
    /**
     * UserInputHelper Default Constructor with 4 parameters
     *
     */
    public UserInputHelper(String options, int quitValue, int minChoiceValue, int maxChoiceValue){
        this(options, "Which choice would you like? \n>", quitValue, minChoiceValue, maxChoiceValue); //defaults to fromConsole input
    }

    /**
     * UserInputHelper Constructor with 5 parameters
     *
     */
    public UserInputHelper(String options, String menu_prompt, int quitValue, int minChoiceValue, int maxChoiceValue){
        this.options = options;
        this.min = minChoiceValue;
        this.max = maxChoiceValue;
        this.QUIT_VALUE = quitValue;
        this.prompt = menu_prompt;
    }


    /**
     * Method getMenuChoice
     *
     * Get user input of menu choice and return it only if it is a valid value
     */
    public int getMenuChoice(){
        System.out.print(options);
        System.out.print(prompt);

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        while(choice != this.QUIT_VALUE &&  ( choice < min || choice > max) ){
            System.err.println("Invalid choice");
            System.out.print(options);
            System.out.print(prompt);
            choice = sc.nextInt();
        }
        return choice;
    }

    /**
     * Method getStringInputFromUser
     *
     * Getter for string
     */
    public static String getStringInputFromUser(String prompt){
        Scanner stdIn = new Scanner(System.in);
        System.out.println(prompt);
        String str = stdIn.nextLine();
        return str;
    }
    /**
     * Method getIntInputFromUser
     *
     * Getter for integer
     */
    public static int getIntInputFromUser(String prompt){
        Scanner stdIn = new Scanner(System.in);
        System.out.println(prompt);
        int num = stdIn.nextInt();
        return num;
    }

    /**
     * Method getDoubleInputFromUser
     *
     * Getter for Double
     */
    private static double getDoubleInputFromUser(String prompt) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println(prompt);
        double num = stdIn.nextDouble();
        return num;
    }
    /**
     * Method getBooleanAnswer
     *
     * Getter for Boolean
     */
    public static  boolean getBooleanAnswer(String prompt){
        boolean valid = false;
        boolean answer = true;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(prompt);
            String str = sc.nextLine();

            if(str.equalsIgnoreCase("Yes") || str.equalsIgnoreCase("Y")){
                answer =  true;
                valid = true;
            }else if(str.equalsIgnoreCase("No") || str.equalsIgnoreCase("N")){
                answer = false;
                valid = true;

            }else{
                valid = false;
                System.out.println("Invalid response! Please try again");
            }
        }while(!valid);
        return answer;

    }


    /**
     * Getter for range of numbers
     */
    public static int getIntInputWithRangeFromUser(String string, int minValue, int maxValue) {
        int input = getIntInputFromUser(string);
        while((input < minValue || input > maxValue)){
            System.out.println(input  + " is an invalid number for this. Number must be at least " + minValue + " and less than " + maxValue);
            input = getIntInputFromUser(string);
        }
        return input;
    }

    /**
     * Method getIntInputWithRangeFromUserWithEscapeNumber
     *
     * Getter for range of numbers with escape number
     */
    public static int getIntInputWithRangeFromUserWithEscapeNumber(String string, int minValue, int maxValue, int escape) {
        int input = getIntInputFromUser(string);
        while(input != escape && (input < minValue || input > maxValue)){
            System.out.println(input  + " is an invalid number for this. Number must be at least " + minValue + " and less than " + maxValue + " or " + escape);
            input =  getIntInputFromUser(string);
        }
        return input;
    }

    /**
     * Method getDoubleInputWithRangeFromUser
     *
     * Getter for range of doubles
     */
    public static double getDoubleInputWithRangeFromUser(String string, double minValue, double maxValue) {
        double input = getDoubleInputFromUser(string);
        while( input < minValue || input > maxValue){
            System.out.println(input  + " is an invalid number for this. Number must be at least " + minValue + " and less than " + maxValue);
            input = getDoubleInputFromUser(string);
        }
        return input;
    }
    
    /**
     * Method same
     *
     * Check if the double and integer value is the same
     */
    public static boolean same(double input1, int input2) {
        return (Math.abs(input1 - input2) >= 0.0 && Math.abs(input1 - input2) <= 0.001);  
    }

}
