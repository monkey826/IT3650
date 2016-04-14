package samsung.java.hw1;

import java.util.Scanner;
// This Program just solve with EngLish words, not special character
public class Problem8 {
	private static Scanner input;
	private static int calNumberWord(String s){
		int n = 0;
		
		String[] split = s.split(" ");
		n = split.length;			
		return n;
	}
	private static void calNumberChar(String s){
		// Using toCharArray and sort.
		
		// Convert string to lower case to distinguish A or a, ....
		s.toLowerCase();
		// Convert string to char array
		char[] c = s.toCharArray();
		// Create new String have only alphabet word
		String s1 =  new String();
		for (int i = 0 ; i < s.length() ; i++ )
			if ((int)c[i]>96 && (int)c[i]<123)
				 s1 += c[i];
			
		// Convert s1 to char array and set to c array
		c = s1.toCharArray();
		// Sort c char array
		for ( int i = 0 ; i < s1.length() ; i++ )
			for ( int j = i + 1 ; j <= s1.length()-1 ; j++ )
				if (c[i]>c[j]){
					char tg = c[i];
					c[i]=c[j];
					c[j]=tg;
				}
		System.out.println(" The number of character : ");
		int j = 0; // New stage ( for calculate frequency appearance of a character )
		for ( int i = 0 ; i < s1.length()-1; i++ ){
			
				if (c[i]!=c[i+1]) {				
					System.out.println(c[i] + " " + (i+1-j));
					j=i+1;
				}			
		}
		// Because last char not equal any char, so not println on this for loop
		System.out.println(c[s1.length()-1] + " " + (s1.length()-j));		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		System.out.println(" Enter a String text:");
		String s = input.nextLine();
		s.trim();
		System.out.println(" The number words is : " + calNumberWord(s));
		calNumberChar(s);
	}
}
