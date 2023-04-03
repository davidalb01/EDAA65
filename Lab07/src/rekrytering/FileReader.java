package rekrytering;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). 
	 * Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
	    Scanner scan;
	    try {
	        scan = new Scanner(new File(fileName), "utf-8");
	    } catch (FileNotFoundException e) {
	        System.err.println("File not found" + fileName);
	        e.printStackTrace();
	        return null;
	    }
	    List<Applicant> applicantsList = new ArrayList<>();
	    int lineNumber = 0;
	    while(scan.hasNextLine() && lineNumber < nbrOfRows ) {
	        String line = scan.nextLine();
	        if (line.isEmpty()) {
	            continue;
	        }
	        String[] parts = line.split(" ");
	       
	            String name = parts[0] + " " + parts[1]; // combine the first two parts to get the name
	            String grades = parts[2]; //
	            Applicant applicant = new Applicant(name, grades);
	            applicantsList.add(applicant);
	       
	        lineNumber++;
	    }
	   scan.close();
	    
	    Applicant[] applicants = new Applicant[applicantsList.size()];
	    applicantsList.toArray(applicants);
	    return applicants;
	}

}
