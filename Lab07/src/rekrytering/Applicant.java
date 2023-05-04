package rekrytering;

import java.util.Arrays;
/*Här skapar vi klassen Applicant.
* 
* Klassen implementerar det generiska gränssnittet "Comparable"
* "Comparable" används för att definera en ordning mellan objekt av en klass
* Innebär att klassens objekt kan jämföras med varandra och sorteras i en ordning
* Använding av "Comparable" kräver att klassen implementerar metoden compareTo.
* 
* compareTo tar emot ett annat objekt av samma typ och retunerar ett heltal
* som represnterar hur objekten förhåller sig till varandra i ordningen.
*/

// Attributer:
// "name" som är en String.
//  "grades" som är en Array av typen int.
 

public class Applicant implements Comparable<Applicant> {
	//Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;

//Konstruktorn heter Applicant 
//har två parametarar:
// "name" som är en String. Namnet av sökanden 
// "gradesAsString" som är en String. Betyget av sökanden. 
//
// Skickar vidare tolkningen av betygen till en privat hjälpmetod "parseGrades för att 
// se till så att det sker korrekt och håller konstrukturn kortare. Hjälpmetoden tolkar
// betygen från "gradesAsString" och lagrar dem i attributet "grades". 

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare 
		// Anropa denna och skicka vidare parametern som innehåller betygen
		
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
	    String[] g = gradesAsString.split(",");
	    grades = new int[g.length];
	    for (int i = 0; i < g.length; i++) {
//	        switch (g[i].toUpperCase()) {
//	            case "A":
//	                grades[i] = 5;
//	                break;
//	            case "B":
//	                grades[i] = 4;
//	                break;
//	            case "C":
//	                grades[i] = 3;
//	                break;
//	            case "D":
//	                grades[i] = 3;
//	                break;
//	            case "E":
//	                grades[i] = 3;
//	                break;
//	            case "U":
//	                grades[i] = 0;
//	                break;
//	            default: 
	                try {
	                    int grade = Integer.parseInt(g[i]);
	                    if (grade >= 3 && grade <= 5) {
	                        grades[i] = grade;
	                    } else {
	                        grades[i] = 0;
	                    }
	                } catch (NumberFormatException e) { 
	                	//Om det inte är en nummer utan en bokstav eller tecken
	                	//Sätts det till 0
	                    grades[i] = 0;
	                }
	            //    break;
	        }
	    }
//	}


	public double getAvgGrade() {
		double sum = 0;
		for(int i = 0; i <grades.length; i++) {
			sum += grades[i];
		}
		double avgGrade = sum/5;
		
		return avgGrade; 
	}

	
	  
	public String toString() {
		return name + " " + Arrays.toString(grades)+ "  " + "("+ getAvgGrade()+ ")";

	}

	 

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar något < 0 om other är störst och returnerar 0 om objekten är lika.
	 * Används av javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}
}
