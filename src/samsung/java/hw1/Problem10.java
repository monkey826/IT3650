package samsung.java.hw1;

import java.util.Scanner;

public class Problem10 {
	private static Scanner input;
	private static int n ;
	private static final double R = 150;
	private static int[] side;
	private static double[] PX;
	private static double[] PY;
	private static boolean isEnemy(int s){ // Check this warship is enemy or ally
		if ( s == -1 ) return true;
		return false;
	}
	private static double calDistance(double x, double y){ // calculate distance from O to position of this warship
		return Math.sqrt(x*x + y*y);
	}
	private static void showPosition(){  //Show position of warship in range attack
		int t=0; // number warships in range attack
		System.out.println(" The list of warships in range attack ");
		for ( int i = 1 ; i <= n ; i++ ){
			if (isEnemy(side[i])==true)
				if (calDistance(PX[i], PY[i]) < R ){
					System.out.println("Position: ["+PX[i]+"] ["+PY[i]+"]" );
					t++;
				}
					
		}
		if (t==0) System.out.println(" No warship in range attack");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		do{
			System.out.println(" Enter the number of ship : ");
			n = input.nextInt();
		}
		while ( n <= 0 );	
		// Init value : the number element
		side = new int[n+1];
		PX = new double[n+1];
		PY = new double[n+1];
		System.out.println(" Enter the position of ships");
		for (int i = 1 ; i <= n ; i++ )
		{ 
			side[i] = input.nextInt();
			PX[i] = input.nextDouble();	
			PY[i] = input.nextDouble();
		}
		
		for (int i = 1 ; i <= n ; i++ ){
			System.out.println(side[i]+ " "+ PX[i]+ " "+ PY[i]);
		}
		showPosition();
	}

}
