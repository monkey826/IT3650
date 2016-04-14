package samsung.java.hw1;

import java.util.Scanner;

// Show Pascal triangle
public class Problem5 {
	private static Scanner input;
	private static void paintPT(int n){ // PT: Pascal Triangle
		for (int line = 1 ; line <= n; line ++){
			int C = 1 ; // Using kCn to calculate next number member
			for ( int i = 1 ; i <= line ; i ++){
				System.out.print(C+" ");
				C = C *(line - i)/i; // (x+1)^n = kCn + ..... and kCn = n! ... + Draft paper
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner (System.in);
		System.out.println(" Enter the number of depth Pascal Triangle: ");
		int n = input.nextInt();
		paintPT(n);
	}
}
