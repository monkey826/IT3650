package samsung.java.week3.shape;

import java.io.IOException;
import java.util.Scanner;

public class Run {
	private static Scanner input;
	/** Enter input number 
	 *  
	 * @return number type of Double
	 */
	public static double enter(){
		double x = 0;
		input = new Scanner(System.in);
		x = input.nextDouble();	
		if ( x <= 0 ) {
			System.out.println(" Input invaild. ");
			return -1;
		}
		return x;
		/// Enter 
	}
	/** 
	 * Show menu
	 */
	public static void showMenu(){
		System.out.println("");
		// Menu 
		System.out.println(" Shape Program ");
		System.out.println(" **********************");	
		System.out.println(" 1. Round ");
		System.out.println(" 2. Cone ");
		System.out.println(" 3. Trundicated Cone");
		System.out.println(" Enter your choice: ");
		int c = (int)enter();
		switch(c){
		case 1: 
			Round();
			showNext();
			showMenu();
			
			break;
		case 2:
			Cone();
			showNext();
			showMenu();
			
			break;
		case 3:
			TruncatedCone();
			showNext();
			showMenu();
			
			break;
		default: break;	
		}
	}
	/** 
	 *  Interrupt program 
	 */
	public static void showNext(){
		System.out.println(" Press enter to continue !");
		try{
			System.in.read();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * Show information about Round object
	 */
	public static void Round(){
		System.out.println(" -- Enter radius of round: ");
		double r = enter();
		if ( r > 0 ){
			Round round = new Round(r);
			System.out.println(" -- The value of diameter: "+ round.calDiameter());
			System.out.println(" -- The value of area: "+ round.calArea());
			System.out.println(" -- The value of circumference: "+ round.calCircumference());
			System.out.println();
		}
	}
	/**
	 *  Show information about  cone object
	 */
	public static void Cone(){
		System.out.println(" -- Enter radius of Cone: ");
		double r = enter();
		if ( r > 0){
			System.out.println(" -- Enter height of Cone: ");
			double h = enter();
			// 
			 if ( h > 0){
				Cone cone = new Cone(h,r);
				System.out.println(" -- The value of surrounding area: "+ cone.calSurroundingArea());
				System.out.println(" -- The value of full are: "+ cone.calFullArea());
				System.out.println(" -- The value of volume : "+ cone.calVolume());
				System.out.println();
			}
		}
	}
	/** Show information about truncated cone object
	 * 
	 */
	public static void TruncatedCone(){
		System.out.println(" -- Enter smaller radius of Truncated Cone: ");
		double r1 = enter();
		if ( r1 > 0) {
			System.out.println(" -- Enter bigger radius of Truncated Cone: ");
			double r2 = enter();
			if ( r2 > r1 ){
				System.out.println(" -- Enter height of Truncated Cone: ");
				double h = enter();				
				if ( h > 0){
					TruncatedCone tc = new TruncatedCone(h, r1, r2);
					System.out.println(" -- The value of surrounding area: "+ tc.calSurroundingArea());
					System.out.println(" -- The value of full are: "+ tc.calFullArea());
					System.out.println(" -- The value of volume : "+ tc.calVolume());
				}	
				else System.out.println(" Error, the value should be greater than 0 ");
			}	
			else {
				System.out.println(" Error, bigger radius is smaller than smaller radius");
			}
		}
		else {
			System.out.println(" Error, the value should be greater than 0 ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();	
	}
}
