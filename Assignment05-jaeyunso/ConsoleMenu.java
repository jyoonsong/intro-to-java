import java.util.Scanner;

/**
 * Console menu is a general purpose class data type that makes a 
 * menu object for interacting with a user over a console (or terminal)
 * window. This is useful for text-based programs to present the user
 * with a set of numbered options to choose from. The menu itself can
 * also handle communicating with the user on the console window in 
 * order to get the user's choice on a menu. This class is written with beginners
 * in mind, and includes no looping or smart processing of data. Therefore, the menu needs
 * to know the total number of options in order to make sure that a user's choice is between 1 and
 * the maximum number in the menu. The String options that is passed in to the menu must itself
 * be formatted to display nicely on the terminal window. For Example, here is a sample String for a 
 * menu, notice the numbering and the "\n" to indicate line breaks.
 * <p><pre>
 * String sampleMenuOptions = "1: Plain Small Coffee\n2: Plain small coffee with cream\n"
 *  <br>                           + "3: Medium Cold Brew Over Ice\n4: Large Hot Pumpkin Latte\n"
 *  <br>                           + "5: Coffee order\n";
 *  </p></pre><p>                           
 *  The menu can also have a programmer-supplied title, if none is given, the menu is printed with no header
 *  <pre> <br>String sampleTitle = "*************  COFFEE MENU  *************"
 *  </pre>
 *  </p>
 * @author Kendra Walther
 * @version Fall 2017
 */

public class ConsoleMenu {

    //Instance Variables
    private String title; // The title for the menu
    private final String options; // The text in the menu
    private final int numOptions; // The total number of options in the menu
    
    /**
     * ConsoleMenu Constructor - makes a new Menu object with the given information
     *
     * @param title The title to appear at the top of the menu
     * @param options A string that contains all the menu options. Please note: All items in the 
     *               string should be numbered, starting at the number 1 and 
     *              should have include "\n" for line breaks between the menu choices
     * @param numOptions an int, indicating the total number of options stored in the menu options
     */
    public ConsoleMenu(String title, String options, int numOptions){
        this.title = title;
        this.options = options;
        this.numOptions = numOptions;
    }
    
     /**
     * ConsoleMenu Constructor - makes a new Menu object with no title on top
     *
     * @param options A string that contains all the menu options. Please note: this string
     *              should have include "\n" for line breaks between the menu choices
     * @param numOptions an int, indicating the total number of options stored in the menu options
     */
    public ConsoleMenu(String options, int numOptions){
        this("", options, numOptions);
    }
    
    
    /**
     * Method printMenu: will print the menu, including the optional menu title
     *
     */
    public void printMenu(){
        System.out.println(title);
        System.out.println(options);
    }
    

    /**
     * Method getUserChoice: This method will ask the user (via the console window)
     * and use Scanner to read in the user's menu option and
     * will return either a valid number (one that corresponds to one of the menu items) or the
     * number -1 if the user entered "wrong" data.
     *
     * @return The return value
     */
    public int getUserChoice(){
        System.out.println("What number option would you like (1-" + numOptions + ")?");
        System.out.print("Please enter a number between 1 and " + numOptions + ": ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        if(num >= 1 && num <= numOptions){ // the user-entered number is valid
            return num;
        }
        else{
            System.out.println("Oops. Not a valid choice for this menu.");
            return -1; // the value for "wrong" data
        }
    }
}