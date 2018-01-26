import java.util.ArrayList;
/**
 * Write a description of class Playlist here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Playlist
{
    // instance variables 
    String name;
    ArrayList<Song> songs;

    /**
     * Constructor for objects of class Playlist
     */
    public Playlist(String name, ArrayList<Song> songs)
    {
        // initialise instance variables
        this.name = name;
        this.songs = songs;
    }
    public Playlist(String name)
    {
        // initialise instance variables
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    /**
     * Getters
     */
    public String getName() {
        return name;
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
    /**
     * Setters
     */
    private void setName(String name) {
        this.name = name;
    }
    private void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    /**
     * converts to String method
     */
    private String getSongsToString() {
        String str = "";
        for (int i=0; i<songs.size(); i++) {
            str += i + ": " + songs.get(i).toString() + "\n";
        }
        return str;
    }
    public String toString() {
        return name + "\n" + getSongsToString();
    }
    /**
     * Extra Credit Methods
     */
    private void addSongToList(Song s) {
        songs.add(s);
    }
    private void removeSongFromList(Song s) {
        songs.remove(s);
    }
    private void clearList() {
        songs.clear();
    }
}
