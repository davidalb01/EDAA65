
public class Person {
	private String name;
	private String number;
	
	public Person(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public String toString() {
		return "Namn: " + name + ", nummer: " + number;
	}
	
}
