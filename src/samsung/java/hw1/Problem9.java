package samsung.java.hw1;

import java.util.Scanner;

// Enter list name and search name in list
public class Problem9 {
	private static String[] s;
	private static Scanner input1;
	private static Scanner input2;
	private static boolean searchName(String s1){
		// search name in list
		boolean rs = false;
		for ( int i = 0 ; i < s.length; i++ ) 
			if(s1.equalsIgnoreCase(s[i]) ){
				rs=true;
				break;
			}
		return rs;
	}
	public static void main(String[] args) {
		input1 = new Scanner(System.in);
		input2 = new Scanner(System.in);
		int n;
		// enter length of list
		do{
			System.out.println(" Enter length of list name ");
			n = input1.nextInt();
			if ( n <= 0) continue;
			else
				s = new String[n]; 
		} 
		while ( n <= 0 );
		// enter list
		System.out.println(" Enter list name ");
		for ( int i = 0 ; i < n; i++){
			s[i] = new String(input2.nextLine());
			s[i]=s[i].toUpperCase();
		}		
		// Show list name		
		System.out.println(" List name :");
		for ( int i = 0 ; i < n; i++)
			System.out.println(s[i]+ " ");
		System.out.println(" Enter a student name ");
		String s1 = input2.nextLine();
		
		// Search a name is on database list
		if (searchName(s1)) System.out.println("Yes");
		else System.out.println("No");
	}

}
