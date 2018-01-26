import java.util.*;
/**
 * Write a description of class LightsOut here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LightsOut
{
    // instance variables
    
    boolean[] lights;
    boolean isWon;
    private Scanner scan;
    // constant
    final boolean ON = true;
    final boolean OFF = false;

    /**
     * Constructor for objects of class LightsOut
     */
    public LightsOut()
    {
        // initialise instance variables
        scan = new Scanner(System.in);
        isWon = false;
    }
    
    /** 
     * controls the whole flow 
     */
    public void start() {
         LightsOut l = new LightsOut();
         lights = new boolean[ getNumberOfLights() ];
         // initialize random array and print it
         initializeLights();
         printLights();
         // process the game until user wins
         while (!isWon) {
             int input = getLightNum();
             if (input == -1) {
                System.exit(0);
             }
             changeLights(input);
             printLights();
             checkWin();
         }
         // after user wins
         System.out.println("You win! Well done");
    }

    /** 
     * prompting the user for the number
     */
    private int getNumberOfLights() {
        int num;
        do {
            System.out.print("How many Lights would you like to have (3-15)? ");
            num = scan.nextInt();
        } while(num>15 || num<3);
        return num;
    }
    
    /** 
     * initialize each spot 
     */
    private void initializeLights() {
        Random random = new Random();
        isWon = false; //just in case
        // if the generated array is already all true, generate again
        do {
            for (int i = 0; i < lights.length; i++) {
                lights[i] = random.nextBoolean();
            }
            checkWin();
        } while (isWon);
    }
    
    /** 
     * updates boolean instance variable if needed
     */
    private void checkWin() {
        isWon = true;
        for (int i = 0; i < lights.length; i++) {
            if (lights[i] == ON) {
                isWon = false;
            }
        }
    }
    
    /** 
     * check if the input of light number is valid
     */
    private boolean isValid(int light) {
        boolean isValid = false;
        if (light < lights.length && light >= 0) {
            isValid = true;
        }
        return isValid;
    }
    
    /** 
     * Get the input of light number
     */
    private int getLightNum() {
        int num;
        do {
            System.out.print("Which light do you select (or -1 to quit)? ");
            num = scan.nextInt();
        } while (!isValid(num) && num!=-1);
        return num;
    }
    
    /** 
     * control changing lights based on lightNum
     */
    private void changeLights(int lightNum) {
        for (int i = (lightNum-1); i <= (lightNum+1); i++) {
            if (i < lights.length && i>=0) {
                if (lights[i] == ON) {
                    lights[i] = OFF;
                }
                else {
                    lights[i] = ON;
                }
            }
        }
    }
    
    /** 
     * printing
     */
    private void printLights() {
        System.out.println();
        System.out.println();
        // visual interface
        for (int i=0; i<4; i++) {
            for (int j=0; j<lights.length; j++) {
                if (lights[j] == ON) {
                    System.out.print("|****");
                }
                else {
                    System.out.print("|    ");
                }
            }
            System.out.println("|");
        }
        // Number identifications
        for (int j=0; j<lights.length; j++) {
            System.out.print("| " + j + "  ");
        }
        System.out.println("|");
        System.out.println();
    }
}
