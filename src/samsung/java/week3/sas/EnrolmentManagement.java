package samsung.java.week3.sas;

import java.io.IOException;
import java.util.Scanner;
/** The management enrolment class presents this project
 * 
 * @author monkey
 *
 */
public class EnrolmentManagement {
	private final int MAX = 50; // MAX LIST 
	private int n = -1; // Length of list at this time
	private ISubject[] IS = new ISubject[MAX]; // List subject
	private Scanner input1 = new Scanner(System.in); // int 
	private Scanner input2 = new Scanner(System.in);// String
	/** Enrol Subject : normal subject or special subject . discriminate by a value 1 or 2 references from displayMenu method.
	 * 
	 * @param c : for determining   normal or special subject 
	 */
	public void enrolSubject(int c){
		if ( n == MAX - 1) // IF MAX, CANNOT ADD MORE
		{
			System.out.println(" This list was full"); // NOTICE
		}
		else{
			/**
			 * Require enter information :
			 */
			System.out.println(" Enter information about subject. ");
			// ID
			String ID;
			do {
				System.out.println(" Enter subject ID: ");
				ID = input2.nextLine();
				ID = ID.trim();
				ID = ID.toUpperCase();
				if (isExist(ID)) {
					System.out.println((" This id is on list, please enter a different ID "));
				}
			}
			while (ID.length()>6 || ID.length() <=0 || isExist(ID));	 // Form required
			
			// Name
			String name;
			do {
				System.out.println(" Enter subject name: ");
				name = input2.nextLine();
			}
			while (name.length() <= 0 || name.length() > 20);
			
			// Number of credits
			System.out.println(" Enter the number of credits: ");
			int nc = input1.nextInt();
			
			//number of practice credits
			System.out.println(" Enter the number of practice credits ");
			int pc = input1.nextInt();
			/**
			 *  If normal subject
			 */
			if (c == 1 ){
				n++;
				Subject sb = new Subject(ID,name,nc,pc);
				IS[n] = sb; // Upcasting
			}
			else if ( c== 2){
				/**
				 * IF special subject
				 */
				System.out.println(" The name of program SIE/ICT/HEDSPI:"); // Add one information
				String nameProgram = input2.nextLine();
				nameProgram = nameProgram.toUpperCase();
				// check name of program 
				while ( !nameProgram.equals("SIE") && !nameProgram.equals("HEDSPI") && !nameProgram.equals("ICT")){
					System.out.println(" This name is not valid! Please enter name of program again. "); // Add one information
					nameProgram = input2.nextLine();
					nameProgram = nameProgram.toUpperCase();
				}
				n++;
				SpecialSubject ssb = new SpecialSubject(ID,name,nc,pc,nameProgram);
				IS[n] = ssb; // Upcasting
			}		
		}
	}
	/** Unenrol subject
	 * 
	 */
	public void unEnrolSubject(){
		System.out.println(" Enter subject ID: ");
		String ID = input2.nextLine();
		int i = getPosition(ID);
		if (i < 0 ) System.out.println(" This id is not on list ");
		else {
			for (int j = i  ; j < n; j++) 
				IS[j] = IS[j+1];
			IS[n] = null;
			n--;
			System.out.println(" Successful ");
		}
	}
	/** Display Fee information 
	 * 
	 */
	public void displayFee(){
		System.out.println(" FEE INFORMATION ");
		System.out.println(" ***** ");
		System.out.println(" Normal Subjects");
		long t1 = 0;
		long t2 = 0;
		for (int i = 0 ; i <= n; i++ )
			if (IS[i] instanceof ISubject && !(IS[i] instanceof SpecialSubject)){
				t1 += IS[i].getFee();
				System.out.println(IS[i].getEnrolmentLine());
			}
		System.out.println(" -----");
		System.out.println(" Total: "+ t1);
		System.out.println(" ***** ");
		System.out.println(" Special Subject ");
		for (int i = 0 ; i <= n; i++ )
			if (IS[i] instanceof ISpecialSubject ){
				t2 += IS[i].getFee();
				System.out.println(IS[i].getEnrolmentLine());
			}
		System.out.println(" -----");
		System.out.println(" Total: "+ t2);
		System.out.println(" *****");
		System.out.println(" Total Fee: "+ (t1+t2));	
	}
	/**
	 *  
	 * @param ID : ID input 
	 * @return index of subject have this id
	 */
	public int getPosition(String ID){
		for ( int i = 0 ; i <= n ; i++ )
		{
			if (IS[i].getID().equals(ID)) 
				return i;
		}
		return -1;
	}
	/** Check string id input is on list?
	 * 
	 * @param ID
	 * @return true if exist this id on list , false if not
	 */
	public boolean isExist(String ID){
		if (getPosition(ID) >= 0 ) return true;
		return false;
	}
	/**
	 *  Show next : ...
	 */
	public void displayNext(){
		System.out.println(" Press enter to continue ... ");
		try{
			System.in.read();
		}
		catch ( IOException e){
			e.printStackTrace();
		}
		input2.nextLine();
			
	}
	/** Menu Program have function to display Menu
	 * 
	 */
	public void displayMenu(){
		System.out.println(" Enrolment Management System ");
		System.out.println(" ------------------------------------------------ ");
		System.out.println(" 1. Enrol a normal subject ");
		System.out.println(" 2. Enrol a special subject ");
		System.out.println(" 3. Unenrol a subject ");
		System.out.println(" 4. Display fee information");
		System.out.println(" Your choice (1-4, other to quit ): ");
		int c = input1.nextInt();
		switch(c){
		case 1: 
			enrolSubject(1);  // Normal subject 
			displayNext();
			displayMenu();
			break;
		case 2: 
			enrolSubject(2); // Special subject 
			displayNext();
			displayMenu();
			break;
		case 3: 
			unEnrolSubject();
			displayNext();
			displayMenu(); 
			break;
		case 4:
			displayFee();
			displayNext(); 
			displayMenu();
			break;
		default :
			break;
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EnrolmentManagement em = new EnrolmentManagement();
		em.displayMenu();
	}
}
