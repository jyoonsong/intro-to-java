import java.util.ArrayList;
import java.util.Scanner;

/**
 * The DotifyConsole class simply provides method definitions for all the abstract methods in Dotify
 * All input/output in this version is through the console window System.in and System.out
 * @author kendra
 *
 */
public class DotifyConsole extends Dotify{

    //Class Variable
    private static final String OPTIONS = "\n"
            + "---------- DOTIFY MENU ----------\n"
            + "|   1:  List All Songs          |\n"
            + "|   2:  Display Playlists       |\n"
            + "|   3:  Create Playlist         |\n"
            + "|  -1:  Quit Spotify            |\n"
            + "---------------------------------\n"
            + "Please enter your choice:";

    //CONSTRUCTORS
    public DotifyConsole(){
        super(); //let the super set things up
    }
    
    // "LAUNCHER" main method -- this is the starting point of the whole system
    public static void main (String[] args){
        Dotify console = new DotifyConsole();
        console.run();
    }
    
    @Override
    protected void displayWelcome() {
        System.out.println("Welcome to the Dotify Application");
    }
    
    @Override
    protected void displayGoodbye() {
        System.out.println("Thank you for using the Dotify Application.");
        System.out.println("Goodbye");
    }
    
    @Override
    public void displayError(String message){
        System.out.println(message);
        System.err.println(message);
    }
    
    @Override
    public void displaySongs(ArrayList<Song> songs){
        System.out.println("****** SONG LIST ******");
        for (int i=0; i<songs.size(); i++) {
            System.out.println(i + ": " + songs.get(i).toString());
        }
        System.out.println("Enter the number of the song you'd like to listen to:");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        System.out.println("****** NOW PLAYING: " + songs.get(userInput).getNameOfSong() + " ******");
        mainUser.listenToSong(songs.get(userInput));
    }
    
    @Override
    public void displayJoinDialog(){
        System.out.println("****** Join Dotify Now ******");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sc.next();
        System.out.println("Please enter your password: ");
        String password = sc.next();
        System.out.println("Please enter your age: ");
        int age = sc.nextInt();
        System.out.println("Do you want to upgrade to Premium User? (y/n)");
        char p = sc.next().charAt(0);
        boolean premium = false;
        if (p == 'y') {
            premium = true;
        }
        super.setUpUser(name, password, premium, age);
    }

    @Override
    public int getUserChoiceDialog(){
        System.out.println(OPTIONS);
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        return userChoice;
    }
    
    @Override
    protected void displayPlaylists() {
        // If no playlist
        System.out.print(mainUser.playlists == null);
        System.out.print(mainUser.playlists[0] == null);
        if (isEmpty(mainUser.playlists)) {
            System.out.println("You do not yet have any playlists");
            // Tell user how many playlists they can have
            if (mainUser instanceof FreeUser) {
                System.out.println("You are allowed to have " + mainUser.PLAYLISTS_ALLOWED_FREE_USER + " playlist");
            }
            else if (mainUser instanceof PremiumUser) {
                System.out.println("You are allowed to have " + mainUser.PLAYLISTS_ALLOWED_PREMIUM_USER + " playlist");
            }
        }
        else {
            for (int i=0; i<mainUser.playlists.length; i++) {
                System.out.println(i + ": " + mainUser.playlists[i].getName());
            }
            System.out.println("Enter the number of the playlist you'd like to listen to:");
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            mainUser.playlists[userInput].getSongs();
        }
        
    }
    
    @Override
    protected void upgradeUserDialog() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to upgrade to Premium User? (y/n)");
        char p = sc.next().charAt(0);
        if (p == 'y') {
            System.out.println("Reenter your password please: ");
            String str = sc.next();
            if (str.equals(mainUser.password)){
                mainUser = new PremiumUser(mainUser.userName, mainUser.password, mainUser.age);
            }
            else {
                System.out.println("Wrong password. Upgrade Canceled");
            }
        }
        else {
           System.out.println("You can continue enjoying your free membership with ads");
        }
    }
    
    protected void createPlaylist() {
        System.out.println("Not yet implemented");
        if (!isFull(mainUser.playlists)) {
            System.out.println("Enter the name of the playlist you'd like to create:");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            Playlist p = new Playlist(userInput, SampleSongs.getAllSongs());
            mainUser.addNewPlaylist(p);
        }
    }
    
    private boolean isFull(Playlist[] arr) {
        boolean isFull = true;
        for (Playlist p : arr) {
            if(p == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    
    private boolean isEmpty(Playlist[] arr) {
        boolean isEmpty = true;
        for (Playlist p : arr) {
            if(p != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
    
}