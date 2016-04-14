package samsung.java.hw1;

import java.util.Scanner;

public class Problem2 {
	private static Scanner input;
	private static double f(double x){
		return Math.tan(2*x) - x + 1;  
	}
	private static double df(double x){ // Calculate derivative of f
		double x1 = f(x + Math.pow(10, -6)); // Calculate f(x+ delta(x)) 
		double x2 = f(x);
		double y1 = Math.pow(10, -6);
		return (x1/y1 - x2/y1); // return derivative of f
	}
	public static void main(String[] args){
		input = new Scanner(System.in) ;
		System.out.println(" Enter x : ");
		double x = input.nextDouble();
		System.out.println(" Gia tri cua f(x) = " + f(x));
		System.out.println(" Gia tri cua df(x) = " + df(x));
	}
}
