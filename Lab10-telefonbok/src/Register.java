import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {

	private ArrayList<Person> persons;

	public Register() {

	}
	

	public void addPerson(String name, String nbr) {

	}

	/**
	 * Tar bort alla med namnet name. Returnerar antalet personer som togs bort
	 */
	public int removePerson(String name) {
		return 0;
	}

	/**
	 * Returnera en lista med alla personer med name som (del av) sitt namn
	 * Om inga personer hittas ska en tom lista returneras
	 */
	public ArrayList<Person> findByName(String name) {
		return null;
	}

	/**
	 * Returnera de personer som har ett visst nummer
	 * Om inga personer hittas ska en tom lista returneras
	 */
	public ArrayList<Person> findByNumber(String nbr) {
		return null;
	}

	/** Returnerar alla personer sorterade med avseende på telefonnummer
	    i stigande ordning */
	public ArrayList<Person> allPersonsSortedByNumber() {
		return null;
	}

	/** Returnerar alla personer sorterade med avseende på namn
    i stigande ordning */
	public ArrayList<Person> allPersonsSortedByName() {
		return null;
	}

	/** Läser registret från filen med namn fileName. */
	public boolean readFromFile(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas");
			return false;
		}
		//Töm Listan persons (eller skapa en ny) och lägg in samtliga de personer ni hittar i filen (via metoden add)

		return true; //Har man kommit hit har det nog gått bra
	}

	/** Sparar registret på en fil med namnet fileName. */
	public boolean writeToFile(String fileName) {
		PrintWriter out = null;
		File f = new File(fileName);
		if(!f.exists()) {
			boolean res;
			try {
				res = f.createNewFile();
				if(!res) {
					System.err.println("Försökte skapa filen " + f + " men misslyckades");
					return false;
				}
			} catch (IOException e) {
				System.err.println("Försökte skapa filen " + f + " men misslyckades");
				e.printStackTrace();
				return false;
			}
		}
		//Loopa över persons, skriv information om varje person till fil
		return true; //Har man kommit hit har det nog gått bra
	}
}
