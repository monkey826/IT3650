package samsung.java.hw1;

import java.util.Scanner;

public class Problem6 {
	private static Scanner input;
	private static void showFibo(int n){
		System.out.println("Fibonacci sequence with "+n+" elements");
		if ( n >=2 ){
			int a = 1 ;
			int b = 1;
			System.out.print(a + " " + b + " ");
			int c = 0;
			for ( int i = 3 ; i<= n ; i++)
			{
				c = a + b; // F(i) = F(i-1) + F(i-2)
				a = b;  // F[i-1]=F[i] for next loop
				b = c; // F[i-2] = F[i-1] For next loop
				System.out.print(c+ " ");
			}
		}
		else if ( n== 1 ) System.out.println(1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		int n =0;
		try{
			do{
				System.out.println(" Enter the length of Fibonacci sequence:");
				n = input.nextInt();
			}
			while ( n < 1);
		}
		catch (java.util.InputMismatchException e){
			System.out.println(e.getMessage() + " has error : this number is over limit");
		}
		
		showFibo(n);
	}

}
