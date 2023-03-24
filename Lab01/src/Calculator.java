import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
	/*	System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		int nbr1 = scan.nextInt();
		int nbr2 = scan.nextInt();
		System.out.println("nbr1 = " + nbr1);
		System.out.println("nbr2 = " + nbr2);
		System.out.println("---------------");
		nbr1 = nbr1 ^ nbr2 ^ (nbr2 = nbr1);
		System.out.println("nbr1 = " + nbr1);
		System.out.println("nbr2 = " + nbr2);
		scan.close(); */
		int a = 37;
		int b = 5;
		
		if(a < b){
            a = a ^ b ^(b = a);
        }
        while(b != 0){
            int c =(a%b);
            a = b;
            b = c;
        }
        System.out.println("-- = "+ a );
		
		
		
	}
}
