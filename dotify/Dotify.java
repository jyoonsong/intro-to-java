import java.util.ArrayList;

/**
 * Dotify class controls the flow of the program,
 * in which you can create a playlist and listen to songs
 */
public abstract class Dotify  {

    protected User mainUser; // This is you, the user
    protected ArrayList<Song> allSongs; // This is the "database" of songs that exist

    public static final int DISPLAY_SONGS = 1, DISPLAY_PLAYLISTS = 2, CREATE_PLAYLIST = 3; // Match the "menu" options

    public Dotify(){
        allSongs = SampleSongs.getAllSongs();  // load Pre-existing Data
    }

    // These methods will be implemented in subclasses, since display/dialog with user will change
    // if it's console window based or GUI based
    protected abstract void displayWelcome();

    protected abstract void displayGoodbye();

    protected abstract void displayError(String message);

    protected abstract void displaySongs(ArrayList<Song> songs);

    protected abstract void displayJoinDialog();

    protected abstract int getUserChoiceDialog();

    protected abstract void displayPlaylists();

    protected abstract void upgradeUserDialog();

    protected abstract void createPlaylist();

    public void run(){
        displayWelcome();

        // TODO: add back in the call to displayJoinDialog
        displayJoinDialog();
        
        boolean wantsToQuit = false;
        do {
            int choice = getUserChoiceDialog();
            if (choice < 0) { //any negative number quits
                wantsToQuit = true;
            } else {
                doOption(choice);
            }

        } while (!wantsToQuit);

        displayGoodbye();
    }

    protected void setUpUser(String userName, String password, boolean premium, int age){
        if (premium) {
            mainUser = new PremiumUser(userName, password, age);
        } else {
            mainUser = new FreeUser(userName, password, age);
        }

    }

    public void doOption(int choice){
        switch (choice) {
            
            case DISPLAY_SONGS:
            displaySongs(this.allSongs);
            break;
            
            case DISPLAY_PLAYLISTS:
            displayPlaylists();
            break;

            case CREATE_PLAYLIST:
            createPlaylist();
            break;
            
            default: 
            displayError("Option Not Recognized " +  choice);

        }
        
        if (mainUser instanceof FreeUser) {
            upgradeUserDialog();
        }
    }

}