import java.util.Scanner;

/**
 * Concert TicketSystem will allow users to buy tickets to a concert
 * 
 * @author Instructors(Kendra Walther, Trina Gregory) and ----- Jaeyun Song ------
 * @version ITP 109, Fall 2017
 */
public class TicketSystem
{
    // instance variables
    private Scanner input;          // Used to get input from the user
    private ConsoleMenu menu;       // Used to display a menu and get input from the user
    private String concertName;     // Name of the concert the user is buying tickets for
    private String venueName;       //Name of the venue for the concert
    private final  int TOTAL_ROWS;      //total number of rows in the venue (set in the constructor)
    private final int VIP_ROWS;     // number of VIP rows in the venue (set in the constructor)
    private int vipSeatsSold;       // Needs to increase when the user buys VIP tickets
    private int generalSeatsSold;       // Needs to increase when the user buys General Floor tickets

    // Constants
    private static final String MENU_OPTIONS = "1: Print Seat Map\n2: Buy General Floor Tickets\n"
        + "3: Buy VIP Tickets\n4: Exit";
    private static final int MENU_NUM_OPTIONS = 4;
    private static final int SEATS_PER_ROW = 10;
    
     /**
      * Constructor for class TicketSystem
      * Sets up the instance variables for a concert's ticket system.
      *
      * @param concert A parameter, a String holding the name of the concert
      * @param venue A parameter, a String holding the name of the concert's venue
      * @param totalRows A parameter, an int holding the total number of rows in the venue
      * @param vipRows A parameter, an int that says how many of the totwl rows are VIP rows.
      */
     public TicketSystem(String concert, String venue, int totalRows, int vipRows) {
        input = new Scanner (System.in);
        menu = new ConsoleMenu(MENU_OPTIONS, MENU_NUM_OPTIONS);
        vipSeatsSold = 0;
        generalSeatsSold = 0;
        //Set up instance variables based on the input to the constructor
        concertName = concert;
        venueName = venue;
        TOTAL_ROWS = totalRows;
        VIP_ROWS = vipRows;
      }
    
     /**
      * Constructor for class TicketSystem
      * Sets up a concert's ticket system, with default values for total rows and vip 
      * rows (total rows is 15 and vip rows is 2)
      *
      * @param concert A parameter, a String holding the name of the concert
      * @param venue A parameter, a String holding the name of the concert's venue
      */
     public TicketSystem(String concert, String venue) {
          //TODO, use this
          this(concert, venue, 15, 3);
     }
      
     /**
     * Default Constructor for class TicketSystem
     * Sets up the instance variables to predefined default values 
     * The "default" concert is the "The Killers" 
     * The "default" venue is "Staples Center" 
     * Uses the same row defaults as the 2 parameter version of the constructor (15 and 3)
     */
     public TicketSystem() {
        //TO DO, use this
        this("The Killers", "Staples Center", 15, 3);
     }
    
  
     public void run () {
        // local variable
        int userInput;
        // welcome message
        System.out.println("Welcome! Please use our system to buy tickets to "
                            + concertName + " at " + venueName);
     
        do {
            // print the menu
            menu.printMenu();
            System.out.println();
            // get input
            userInput = menu.getUserChoice();
            System.out.println();
            // call the corresponding method
            switch (userInput) {
                case 1: 
                    printSeats();
                    break;
                case 2:
                    buyGeneralTickets();    
                    break;
                case 3:
                    buyVipTickets();
                    break;
            }
        } while (userInput != MENU_NUM_OPTIONS);
        // closing message
        System.out.println();
        System.out.println("Thank you! Hope you enjoy "
                            + concertName + "!");
     }

     private void printSeats () {
        for( int i=1; i<=VIP_ROWS; i++){
            for(int j=1; j<=SEATS_PER_ROW; j++){
              System.out.print("(V) "); // prints V in a row
            }
            System.out.println();
        }
        int genRows = TOTAL_ROWS - VIP_ROWS;
        for (int i=1; i<=genRows; i++){
            for(int j=1; j<=SEATS_PER_ROW; j++){
              System.out.print("(G) "); // prints G in a row
            }
            System.out.println();
        }
        System.out.println ("There are " + vipSeatsAvailable() + " VIP seats available.");
        System.out.println ("There are " + generalSeatsAvailable() + " General Floor seats available.");
     }

     private int vipSeatsAvailable () {
        int seats = VIP_ROWS * SEATS_PER_ROW - vipSeatsSold;
        return seats;
     }

     private int generalSeatsAvailable () {
        int seats = TOTAL_ROWS * SEATS_PER_ROW - generalSeatsSold;
        return seats;
     }

     private void buyVipTickets () {
        int vipAvailable = vipSeatsAvailable();
        if ( vipAvailable == 0 ) {
            System.out.println("Sorry, no seat available");  
        }
        else {
            System.out.println(vipAvailable + " General Floor seats are available.");
            System.out.print("How many tickets would you like?");
            int purchaseNum = input.nextInt();
            if ( purchaseNum < 1 ) {
                System.out.println("You need to enter a number greater than 0."); 
            }
            else if ( purchaseNum > vipAvailable ) {
                System.out.println("Too much. Unavailable."); 
            }
            else {            
                printTicket(true, purchaseNum);
                vipSeatsSold += purchaseNum;
            }
        }
     }

     private void buyGeneralTickets () {
        int seatsAvailable = generalSeatsAvailable();
        if ( seatsAvailable == 0 ) {
            System.out.println("Sorry, no seat available");  
        }
        else {
            System.out.println(seatsAvailable + " General Floor seats are available.");
            System.out.print("How many tickets would you like?");
            int purchaseNum = input.nextInt();
            if ( purchaseNum < 1 ) {
                System.out.println("You need to enter a number greater than 0."); 
            }
            else if ( purchaseNum > seatsAvailable ) {
                System.out.println("Too much. Unavailable."); 
            }
            else {
                printTicket(false, purchaseNum);
                generalSeatsSold += purchaseNum;
            }
        }
     }

     private void printDashes (int num) {
        for (int i=0; i<num; i++) {
            System.out.print("-");
        }
        System.out.println();
     }

     private void printTicket (boolean isVip, int ticketsPurchased) {
        // dashes
        printDashes(40);
        printDashes(40);
        // info
        System.out.println("\t " + concertName);
        System.out.println("\t Appearing at " + venueName);
        if (isVip) {
            System.out.println("\t VIP Tickets");
            // calculate
            int startSeat = vipSeatsSold + 1;
            int endSeat = vipSeatsSold + ticketsPurchased;
            // print
            System.out.println("\t Seats " + startSeat + " - " + endSeat);
        }
        else {
            System.out.println("\t General Floor Tickets");
            // calculate
            int startGenSeat = generalSeatsSold + 1;
            int endGenSeat = generalSeatsSold + ticketsPurchased;
            // print
            System.out.println("\t Seats " + startGenSeat + " - " + endGenSeat);
        }
        // dashes
        printDashes(40);
        printDashes(40);
     }

}