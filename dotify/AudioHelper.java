import java.io.File;
import java.net.URL;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 */
public class AudioHelper {

    /**
     * Play an audio file (certain WAV files) given the fileName
     * @param fileName
     */
    public static void playFile(String fileName){
        playFile(fileName, true);
    }

    /**
     * Play an audio file (certain WAV files) given the fileName and boolean (indicating play once or play multiple)
     * @param fileName
     * @param continuous boolean to indicate whether the audio file shall play once or 
     * play continuously.
     */
    public static void playFile(String fileName, boolean continuous){
        AudioInputStream stream;
        try {
            System.out.println("AudioHelper is playing file:" + fileName);
            File file = new File(fileName);
            stream = AudioSystem.getAudioInputStream(file);
            playStream(stream, continuous);
        }       

        catch (Exception e) {
            System.out.println("\tNOTICEProblem getting Audio Stream from file. " + fileName 
                + "\n\tCheck to make sure the file is stored properly or try a different \"song\"" 
                + "\n\tIf nothing will play, please Ask an instructor or TA for help..");
            //e.printStackTrace();
        }
    }

    /**
     * Play an ad (wav file) based on a URL
     * @param urlString
     */
    public static void playAd(String urlString){
        String adString = ("\n*************************************\nAD\nAD\nAD playing is:" + urlString);
        playURL(urlString, true, adString);
    }

    /**
     * Play a song/sound  (wav file) based on a URL
     * @param urlString
     */
    public static void playURL(String urlString){
        String message = "AudioHelper is playing url:" + urlString;
        playURL(urlString, true, message);
    }

    /**
     * Play a song/sound (wav file) based on a URL, with a message about what is playing that gets printed to console window
     * @param urlString
     * @param continuous
     * @param message
     */
    public static void playURL(String urlString, boolean continuous, String message){
        AudioInputStream stream;
        try {
            URL url = new URL(urlString);
            System.out.println(message);

            stream = AudioSystem.getAudioInputStream(url);
            playStream(stream, continuous);
        }       

        catch (Exception e) {
            System.out.println("\tNOTICE:Problem getting Audio Stream from URL: " + urlString + 
                "\n\t Some files on Sound Archive just aren't working properly. "
                +"\n\t If nothing will play, please Ask an instructor or TA for help.");
            e.printStackTrace();
        }
    }

    /**
     * Method that gets the audio clip based on the stream and plays it
     * @param stream
     * @param continuous
     */
    private static void playStream(AudioInputStream stream, boolean continuous) {

        //TO DO: USE CONTINUOUS, to allow one time play from GUI version.
        try {
            Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, stream.getFormat()));
            clip.open(stream);

            if(!continuous){
                System.out.println("GUI Version, set to play once."); 
                clip.loop(1); //play once in the GUI
            }
            else{

                Scanner sc = new Scanner (System.in);
                System.out.println("Type enter to stop playing this song");

                clip.loop(Clip.LOOP_CONTINUOUSLY);

                sc.nextLine(); //Waits for user to hit enter, and then looping stops
                clip.stop(); // Stop the clip 
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
