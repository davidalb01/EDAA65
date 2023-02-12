import java.util.Scanner;

public class BetterCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			try {
				
				System.out.println("Enter two numbers:");
				double nbr1 = scan.nextDouble();
				double nbr2 = scan.nextDouble();
				
				System.out.println("Enter operation (+ ,- ,* , /):");
				String operation = scan.next();
				
				double result = 0.0; 
				
				switch (operation) {
				case "+":
					result = nbr1 + nbr2;
					break;
				case "-":
					result = nbr1 - nbr2;
					break;
				case "*":
					result = nbr1 * nbr2;
					break;
				case "/":
					result = nbr1 / nbr2;
					break;
				
				default:
					System.out.println("Invalid operation");
					continue;
				}
				
				System.out.println("Result:  "+ result);
				System.out.println("Hello");
			} catch (Exception e) {
				
				System.out.println("Invalid input, enter numbers only.");
				scan.nextLine();
				
				
			}
		}
		

	}

}
