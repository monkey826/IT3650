package samsung.java.hw1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem3 {
	private static Scanner input;
	private static long calculateEM(int x){// calculate Electric Money
		if ( 0 <= x &&  x <= 25) return 1000*x; // If NOE between 0 and 25 then cal with 25 
		if (25 < x &&  x <= 75 ) return 25*1000 + 1250*(x-25); // If NOE between 26 and 75 then cal with 25 number head and 75-x number ..
		if (75 < x &&  x <= 150 ) return 25*1000 + 50*1250 + 1800*(x-75); // If NOE between 76 and 150
		if (150 < x ) return 25*1000 + 50*1250 + 1800*x + 2500*(x-150);// If NOE higher than 150
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		int x = 0;
		try{
			do{
				System.out.println(" Enter the number of electricity was used : ");
				x = input.nextInt();
			}
			while (x<0);
			System.out.println(" It takes " + calculateEM(x) + " vnd");
		}
		catch ( InputMismatchException e ){
			System.out.println(" The number of electricity are over limit");
		}
	}
}
