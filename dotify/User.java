/**
 * Abstract class User - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class User
{
    // instance variables 
    protected String userName;
    protected String password;
    protected int age;
    protected Playlist[] playlists;
    private int numPlaylists;
    public static final int PLAYLISTS_ALLOWED_FREE_USER = 1;
    public static final int PLAYLISTS_ALLOWED_PREMIUM_USER = 10;

    /**
     * Constructor
     */
    public User(String userName, String password, int age)
    {
        this.userName = userName;
        this.password = password;
        this.age = age;
        initializePlaylists();
    }
    
    /* Getters */
    private String getUserName() {
        return userName;
    }
    private int getAge() {
        return age;
    }
    private Playlist[] getPlaylists() {
        return playlists;
    }
    /* Setters */
    private void setUserName(String userName) {
        this.userName = userName;
    }
    private void setAge(int age) {
        this.age = age;
    }
    
    /* see if the parameter matches the stored password */
    private boolean checkPassword(String tryWord) {
        boolean bool = false;
        if (password == tryWord) {
            bool = true;
        }
        return bool;
    }
    
    /* change the password */
    private boolean changePassword(String oldPass, String newPass) {
        boolean bool = false;
        if (password.equals(oldPass)) {
            password = newPass;
            bool = true;
        }
        return bool;
    }
    
    /* Abstract methods */
    abstract void initializePlaylists();
    abstract boolean addNewPlaylist(Playlist p);
    abstract int getNumberOfPlaylists();
    abstract String listenToSong(Song nameOfSong);
}
