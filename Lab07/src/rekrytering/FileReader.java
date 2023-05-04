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
	    //Använder mig av List som är dynamisk till skillnand från en Array som är statisk
	    //Arrayer har en fast storlek och 
	    //Det går inte att lägga till eller ta bort element efter att arrayen har skapats. 
	    //Om du vill lägga till eller ta bort element måste du skapa en ny array med den nya storleken 
	    //och kopiera över de befintliga elementen till den nya arrayen.
	    
	    //En List, å andra sidan, är en dynamisk datastruktur som automatiskt justerar sin storlek 
	    //när element läggs till eller tas bort. 
	    //Listor är också en samling av element av samma datatyp, 
	    //men deras storlek kan justeras dynamiskt baserat på antalet element som lagras i listan. 
	    //När du skapar en lista behöver du inte deklarera dess storlek, 
	    //eftersom den kan justeras automatiskt när element läggs till eller tas bort.
	    
	    //En List passar väldigt bra här eftersom vi inte vet hur många 
	    //Applicants som finns i filen på förhand. 
	    
		List<Applicant> applicantsList = new ArrayList<>();
		int lineNumber = 0;
		while (scan.hasNextLine() && lineNumber < nbrOfRows) {
			String line = scan.nextLine();
			// if (line.isEmpty()) {
			// continue;
			// } Om det skulle finns tomma rader i filen kan man använda denna koden
			//Denna kod fortsätter kolla om även om det skulle finnas en tom rad i 
			//filen. 
			String[] parts = line.split(" ");
			//Här hade man även kunnat lägga till en try, catch som ger ett som 
			//gör att programet kan hantera felaktigt inmatning av data. Dvs om någon applicatan
			//Har tre namn t.ex "Namn MellanNamn EfterNamn [Betyg]" Kommer detta
			//ge ett fel eftersom endast namnen tas med och då skrivs det ut en varning
			//att de extra delarna ignoreras och 
	
//			try {
//	 			String name = parts[0] + " " + parts[1];
//	 			String grades = parts[2];
//	 		
//	 			if(parts.length > 3) {
//	 				System.out.println("Warning: Input on line " + lineNumber + " has more than 3 parts. Ignoring extra parts.");
//	 			}
//	 		Applicant applicant = new Applicant(name, grades);
//	 		applicantsList.add(applicant);
//	 		
//	 		}
//	 		catch(ArrayIndexOutOfBoundsException e) {
//	 			System.err.println("Invalid input on line " + lineNumber + ": " + line);
//	 		    e.printStackTrace();
//	 		}
	 
	 
			
			String name = parts[0] + " " + parts[1];
			String grades = parts[2];
			Applicant applicant = new Applicant(name, grades);
			applicantsList.add(applicant);
			
			
			
			lineNumber++;
		}
	   scan.close();
	    //Här omvandlar vi vår lista med Applicatns till en Array som är precis så lång som 
	   //som vi behöver. Detta funkar eftersom jag precis förklarat är list dynamisk. 
	   //Detta gör att vi slipper skapa flera olika arrayer och kopierar över dem 
	   //flera gånger. 
	    Applicant[] applicants = new Applicant[applicantsList.size()]; 
	    applicantsList.toArray(applicants);
	    return applicants;
	}

}
