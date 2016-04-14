package samsung.java.hw1;

import java.util.InputMismatchException;
// Update problem : Don't enter the length of array, take character not number to exit enter
import java.util.Scanner;

public class Problem7 {
	private static Scanner input;
	private static long[] a;
	private static void sort(long[] a){
		for (int i = 0 ; i < a.length-1 ; i++)
			for (int j = i + 1 ; j <= a.length -1; j++){
				if (a[i]<a[j]){
					long tg = a[i];
					a[i]=a[j];
					a[j]=tg;
				}
			}
		System.out.println("The array after sort");
		for ( int i = 0 ; i < a.length ; i++)
			System.out.print(a[i]+ " ");
	}
	public static void main(String[] args){
		input = new Scanner(System.in);
		// Enter array
		try{
			System.out.println(" Enter the length of array");
			int n = input.nextInt();
	 
			System.out.println("Enter the value of elements ");	
			a = new long[n];
			
			for ( int i = 0 ; i < n ; i++)
				a[i] = new Long(input.nextLong());
			// Show array before sort
					System.out.println("The array before sort");
					for ( int i = 0 ; i < a.length ; i++)
						System.out.print(a[i]+ " ");
					System.out.println("");
					// Execute sort
					sort(a);
		} 
		catch (InputMismatchException e){
			System.out.println(" error ");
		}
		
	}
}
