package samsung.java.hw1;

import java.util.Scanner;

public class Problem1 {
	private static Scanner input;
	private static double f(double x){
		double ln1 = Math.log(x*x +1 ); // Calculate ln
		double sqrt1 = Math.sqrt(Math.pow(x,4) + 1); // Calculate square root
		double qe2 = x*x - x + 1;// Calculate
		if (qe2 == 0 ) return Integer.MAX_VALUE; 
		else return (ln1+ sqrt1)/qe2;
		
	}
	private static double g(double x , double y){
		double cos1 = Math.cos(2*x); // Calculate cos function
		double expression1 = y*y - y + 1 ; // Calculate expression after
		return cos1 + expression1;
	}
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println(" Enter x :");
		double x = input.nextDouble();
		System.out.println(" Enter y :");
		double y = input.nextDouble();
		System.out.println(" F(x) = " + f(x));
		System.out.println(" G(x,y) = " + g(x,y));
	}

}
