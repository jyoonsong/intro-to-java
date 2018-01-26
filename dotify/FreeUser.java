import java.util.*;
/**
 * Write a description of class FreeUser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FreeUser extends User
{
    // instance variables - replace the example below with your own
    AdGenerator ads;
    boolean hasOnePlaylist;

    /**
     * Constructor for objects of class FreeUser
     */
    public FreeUser(String userName, String password, int age)
    {
        // initialise instance variables
        super(userName, password, age);
        ads = new AdGenerator();
        hasOnePlaylist = false;
    }

    /**
     * sets up the playlist array
     */
    @Override
    void initializePlaylists() 
    {
        playlists = new Playlist[PLAYLISTS_ALLOWED_FREE_USER];
    }
    
    /**
     * Adds the given playlist to the array
     */
    @Override
    boolean addNewPlaylist(Playlist p) {
        boolean isAdded = false;
        if (!hasOnePlaylist) {
            playlists[0] = p;
            hasOnePlaylist = true;
            isAdded = true;
        }
        return isAdded;
    }
    
    /** 
     * get Number of Playlists in arraylist Playlists
     */
    @Override
    int getNumberOfPlaylists() {
        int currentNumber = 0;
        if (hasOnePlaylist) {
            currentNumber = 1;
        }
        return currentNumber;
    }
    
    /**
     * calls the song's play method
     */
    @Override
    String listenToSong(Song song){
        song.play();
        String str = ads.go();
        return str;
    }
}
