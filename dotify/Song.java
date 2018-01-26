import java.io.*;
import java.net.URL;
import java.util.Scanner;
import javax.sound.sampled.*;


/**
 * Song class can play local files or URL locations of Sound files in the following formats: wav aifc aiff au snd 
 *
 */
public class Song implements Playable{
   
    private String nameOfSong;
    private String fileName;
    private boolean songIsLocalFile;


    /**
     * FOR TEST PURPOSES ONLY, GREAT WAY TO FIND NEW AUDIO FILES AND SEE IF THEY WORK. SINCE SOME WAVE FILES ARE ENCODED DIFFERENTLY, 
     * SOUNDS/SONGS DON'T ALWAYS PLAY AS EXPECTED - THIS MAIN METHOD ALLOWS US TO TEST THE LOCAL FILE/ ULL TO SEE IF THE SOUNDS WE WANT ACTUALLY PLAY
     * 
     */
    public static void main(String[] args){
        Song test = new Song("Dark Side", "http://www.thesoundarchive.com/email/yoda-message-from-the-darkside.wav", false);
        test.play();

        Song test2 = new Song("Cow", "audio//cow.wav", true);
        test2.play();

    }

    /* constructor emthod for with 3 parameters */
    public Song(String name, String fileName, boolean isLocal){
       nameOfSong = name;
       this.fileName = fileName;
       songIsLocalFile = isLocal;
    }

    // TO DO - accessor & mutator methods for nameOfSong and fileName
    // accessor for nameofSong
    protected String getNameOfSong() {
        return nameOfSong;
    }
    // accessor for fileName
    protected String getFileName() {
        return fileName;
    }
    // mutator for nameOfSong
    private void setNameOfSong(String str){
        nameOfSong = str;
    }
    //mutator for fileName
    private void setFileName(String str) {
        fileName = str;
    }
    
    public void play(){

        if( songIsLocalFile ){ //Reading sound from a local file
            AudioHelper.playFile(fileName);
        }
        else{ //Reading sound from a URL
            AudioHelper.playURL(fileName);
        }

    }
    public void playOnce(){
        if( songIsLocalFile ){ //Reading sound from a local file
            AudioHelper.playFile(fileName, false);
        }
        else{ //Reading sound from a URL
            AudioHelper.playURL(fileName, false, "Now Playing " + this.getNameOfSong());
        }
    }
    
    public String toString(){
        // TO DO - update so it returns song's name
        return nameOfSong;
    }
}
