import java.io.File;
import java.util.*;

//Jaeyun Song
//ITP 109, Fall 2017
//Homework 06
//usc email
public class Quizlet{
    private Scanner scan;
    private int numCorrect;
    private int numAttempted;
    private ArrayList<Location> locationList;
    
    public Quizlet() {//TODO
        //initialize ALL the instance variables
        scan = new Scanner(System.in);
        numCorrect = 0;
        numAttempted = 0;
        locationList =  new ArrayList<Location>();
    }
    
    public static void main(String[] args) {
        Quizlet q = new Quizlet();
        q.run();
    }
    
    public void run() { //TODO
        boolean doLoop = false;
        do {
            System.out.println("Choose 1 to do US state capitals, Choose 2 to do programmer's favorite capitals");
            int num = scan.nextInt();
            //based on the user's input, either call the setUpLocationListFromFile method or the setUpProgrammerList method
            //if the input num was bad, loop until the user enters 1 or 2.
            if (num==1) {
                setUpLocationListFromFile();
                doLoop = false;
                quizUser();
            }
            else if (num==2) {
                setUpProgrammerList();
                doLoop = false;
                quizUser();
            }
            else {
                doLoop = true;
            }
        } while(doLoop);
    }
    
    
    private void setUpProgrammerList(){ //TODO
        //make your own ArrayList of location objects - can be state & city or country & city
        //must have at least 5 elements in the list
        locationList.add(new Location("South Korea", "Seoul"));
        locationList.add(new Location("Japan", "Tokyo"));
        locationList.add(new Location("China", "Beijing"));
        locationList.add(new Location("France", "Paris"));
        locationList.add(new Location("North Korea", "Pyeong-yang"));
        Collections.shuffle(locationList);
    }
    
    private void quizUser() { //TODO
        System.out.println("Welcome to the state capital quiz");
        System.out.println("----------------------------------\n");
        scan.nextLine(); // flush
        int start = locationList.size() - 1;
        //While there are still locations in the list
        for (int i=start; i>=0; i--) {
            Location loc = locationList.get(i);
            //take a location out of the list (remove it) -- from the front or the back
            locationList.remove(i);
            //print the question by calling the printQuestion method on that location object (the one just removed from the list)
            printQuestion(loc);
            //print the score by calling the printScore method
            printScore();
            System.out.println();
        }
        
        //at the end of the quiz (when the list is empty), print the final score by calling the printFinalScore method
        if(locationList.size() == 0) {
            printFinalScore();
            //initialize
            numCorrect = 0;
            numAttempted = 0;
        }
        System.out.println("----------------------------------");
    }
    
     private void printQuestion(Location loc) { //TODO
        System.out.println("Enter the capital of " + loc.getState() + ": ");
        String answer = scan.nextLine();
        // check the user answer --> print a message if they are right or wrong, incrementing numCorrect as needed
        if (answer.equalsIgnoreCase(loc.getCapital())) {
            System.out.println("Correct");
            numCorrect++;
        }
        else {
            System.out.println("Incorrect");
        }
        // Give feeback about the actual capital of the state (or country)
        System.out.println(loc.getCapital() + " is the capital city of " + loc.getState() );
        numAttempted++;
    }

    private void printScore() { //TODO
       String percent = String.format("%.2f", getPercent());
       System.out.println("Score: " + numCorrect + "/" + numAttempted + " = " + percent);
    }
    
    private void printFinalScore() { //TODO
        double percent = getPercent();
        System.out.println("FINAL Score: " + numCorrect + "/" + numAttempted
                + " = " + String.format("%.2f%n", percent));
        //print a message indicating how well they did (good versus failing, or can assign a letter grade
        System.out.print("Your Grade is ");
        if (percent >= 80) {
            System.out.println("A :) Proud of you");
        }
        else if (percent >= 60) {
            System.out.println("B :) Pretty Good");
        }
        else if (percent >= 60) {
            System.out.println("C :) Good");
        }
        else {
            System.out.println("D :) Maybe you can do better");
        }
    }


    private double getPercent() {
        return (double)numCorrect/numAttempted * 100.0;
    }

  

    private void setUpLocationListFromFile() {
        locationList.ensureCapacity(50); //make sure the list has enough space
        String fileName = "locations.txt";
        File f = new File(fileName);
        try {
            Scanner fileReader = new Scanner(f); //the Scanner will read from a file
            while(fileReader.hasNextLine()) { //while there are still lines to read
                String line = fileReader.nextLine(); //grab one line from the file
                String[] locationParts = line.split(","); //split the line into 2 parts
                locationList.add(new Location(locationParts[0], locationParts[1])); //make a location based on those 2 parts
                
            }
        }
        catch(Exception e) {
            System.out.println(fileName + " file is not found. It needs to be in the same " 
                        + " folder as this BlueJ project");
        }
        
        Collections.shuffle(locationList); //put the list in a random order
    }
    
    
}