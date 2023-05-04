package rekrytering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.5;

	public static void main(String[] args) {
		
		String fileName = "applications_all.txt";
		int nbrOfRows = 435;
		
		Applicant[] applicants = FileReader.readFromFile(fileName, 500);
		System.out.println("All Applicants");
		System.out.println("-----------------------");
		Arrays.sort(applicants);
		for(int i = 0; i < applicants.length; i++) {
			
			System.out.println("\033[31m" + applicants[i].toString() + "\033[0m");

			
			}
			
		
		for(int i = 0; i < 5; i++) {
			System.out.println("-----------------------");
		}
		
		System.out.println("\033[32m"+ "Valid Applicants" + "\033[0m");
		System.out.println("-----------------------");
		
		Applicant[] bestApplicants = FindBestCandidates.findBestCandidates(applicants);
		Arrays.sort(bestApplicants);
	    
		for (int i = 0; i < bestApplicants.length; i++) {
	    	System.out.println("\033[32m" + bestApplicants[i].toString() + "\033[0m");
	    	
	    }
	    System.out.println(bestApplicants.length);
	    
	
		
		
		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor

		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor

		// Printa resultatet från findBestCandidates
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
	    List<Applicant> bestApplicantsList = new ArrayList<>();
	    for (int i = 0; i < applicants.length; i++) {
	        if (applicants[i].getAvgGrade() >= MIN_AVG_GRADE) {
	            bestApplicantsList.add(applicants[i]);
	        }
	    }
	    Applicant[] bestApplicants = new Applicant[bestApplicantsList.size()];
	    bestApplicantsList.toArray(bestApplicants);
	   
	    return bestApplicants;
	   
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		 //Byt ut denna rad mot hela din egen lösning
	}
}
