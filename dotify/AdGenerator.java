import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AdGenerator {
    private String[] textAds;
    private String[] adFiles;

    public AdGenerator(){
        textAds = getHardCodedTexts();
        adFiles = getHardCodedAdFiles();

    }
    
    public String go(){
        playRandomAd();
        return getRandomAd();
        
    }
    
    private String[] getHardCodedAdFiles() {
        String[] ads = { "http://www.thesoundarchive.com/email/male_pattern.wav",
                    "http://www.thesoundarchive.com/simpsons/misc/lisacooties.wav",
                    "http://www.thesoundarchive.com/simpsons/misc/williemayr.wav",
                    "http://www.thesoundarchive.com/email/youGotmail.wav",
                    "http://www.thesoundarchive.com/email/mix_rap_mail1.wav",
                    "http://www.thesoundarchive.com/email/yoda-message-from-the-darkside.wav",
                    "http://www.thesoundarchive.com/starwars/R2D2-hey-you.wav"
                        };

        return ads;
    }

    private String[] getHardCodedTexts() {
        String[] ads = { "HERE IS A DOG ADVERTISEMENT WITH TONS OF PUPPIES\nAW, HOW CUTE!\nPLEASE DONATE!",
                        "HERE IS A CAT ADVERTISEMENT WITH TONS OF KITTENS STEPPING ON YOUR KEYBOARD\n...FGHDASJFKSG...\nPLEASE DONATE, MEOW.",
                        "IF YOU HAVE BEEN DIAGNOSED WITH JAVAPROGRAMMINGADDICTIONITIS,\nCALL 555-555-5555 NOW TO CLAIM MONEY THAT IS RIGHTFULLY YOURS!",
                        "*INSERT ADVERTISEMENT FOR UPCOMING HORROR MOVIE*\n*SCARES YOU INTO PURCHASING PREMIUM*",
                        "THIS AD IS ANNOYING, HUH? I THINK THAT'S THE POINT."
                        };

        return ads;
    }

    private void playRandomAd(){
        Random rando = new Random();
        int randomNumber = rando.nextInt(adFiles.length);
        String url = adFiles[randomNumber];
        AudioHelper.playAd(url);

    }
    
    private String getRandomAd(){
        Random rando = new Random();
        int randomNumber = rando.nextInt(textAds.length);
        String printAd = "****** PRINT ADVERTISEMENT ******\n" + textAds[randomNumber] + "\n\n";
        String premium = "****** ACT NOW ******\nSign up for Dotify Premium before it's too late!\n";
        return printAd + premium;
    }

    private String toStarString (int num) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < num; i++) {
            sb.append ("*");
        }
        sb.append("\n");
        return sb.toString();
    }
}
