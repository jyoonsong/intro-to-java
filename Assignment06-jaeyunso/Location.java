
/**
 * Location
 *
 * Jaeyun Song
 * 10/24/2017
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String state;       // Used to get input from the user
    private String capital;        // Used to display a menu and get input from the user

    /**
     * Constructor for objects of class Location
     */
    public Location(String state, String capital)
    {
        this.state = state;
        this.capital = capital;
    }

    /**
     * Accessor Methods
     */
    public String getState(){return state; } 
    public String getCapital(){return capital; }
    
    /* toString Method */
    public String toString() {
        return capital + ", " + state;
    }
}
