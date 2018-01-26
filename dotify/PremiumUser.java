import java.util.ArrayList;
/**
 * Write a description of class PremiumUser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PremiumUser extends User
{
    // instance variables - replace the example below with your own
    int currentNumberOfPlaylists;
    int numSongsPlayed;

    /**
     * Constructor for objects of class PremiumUser
     */
    public PremiumUser(String userName, String password, int age)
    {
        // initialise instance variables
        super(userName, password, age);
        currentNumberOfPlaylists = 0;
        numSongsPlayed = 0;
    }

    /**
     * sets up the playlist array
     */
    @Override
    void initializePlaylists() 
    {
        playlists = new Playlist[PLAYLISTS_ALLOWED_PREMIUM_USER];
    }
    
    /**
     * Adds the given playlist to the array
     */
    @Override
    boolean addNewPlaylist(Playlist p) {
        boolean bool = false;
        for (int i=0; i<playlists.length; i++) {
            if(playlists[i] == null) {
                playlists[i] = p;
                bool = true;
                currentNumberOfPlaylists++;
                break;
            }
        }
        return bool;
    }
    
    /** 
     * get Number of Playlists in arraylist Playlists
     */
    @Override
    int getNumberOfPlaylists() {
        return currentNumberOfPlaylists;
    }
    
    /**
     * calls the song's play method
     */
    @Override
    String listenToSong(Song song){
        song.play();
        numSongsPlayed++;
        return "Number of Songs Listened: " + numSongsPlayed + "\n";
    }
}
