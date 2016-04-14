package samsung.java.week2.bank;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/** Main interface Account 
 * 
 * @author monkey
 * @category more methods to resolve solution
 */
public class ManageBank {
	private static final int MAX_ACC = 50; // List saving account: Acc
	private static SavingAccount[] Acc = new SavingAccount[MAX_ACC]; // Begin with element of number 0
	private static int n = -1; // There are n accounts on list.
	private Scanner input1;
	private Scanner input2;
	private Scanner input3;
	/**  Create new Account 
	 * 	@param id : Not NULL , Account ID
	 * @param name : Not NULL , Account Name
	 */
	public void appendAccount(){
		if ( n != MAX_ACC-1) { // Because The begin from 0 , so MAX_ACC = n + 1
			String id = enterID();
			input2 = new Scanner(System.in);
			if (!isExist(id)){
				System.out.println(" Enter account name ");
				String name = input2.nextLine();
				/////////////// Enter money information, date, rate..
				System.out.println(" Did this saving account have money ? ");
				System.out.println(" 1. Yes");
				System.out.println(" Or any number mean No ");
				input1 = new Scanner(System.in);
				int c = input1.nextInt();
                
				if ( c == 1){ // YEs
					
                // ******* Input Assets,date,rate ************/// 
					// Input assets
		        	double assets;
		    		do {
		    			input3 = new Scanner(System.in);
		    			System.out.println(" Enter assets amount: ");
		    			assets = input3.nextDouble();
		    		}
		    		while (assets < 0);
		    		// Input date given : Can give money in the future .. Set day to give .
		    		Date dateGiven = null;
		    		do{
		    			input2 = new Scanner(System.in);
		    			System.out.println(" Enter day given form like:  DD/MM/YYYY");
		    	        String date = input2.nextLine();
		    			dateGiven = convertSTD(date);
		    		}
		    		while (dateGiven==null );
		    		// Enter day interest rate
		    		double rate;
		    		do {
		    			System.out.println(" Enter day interest rate ");
		    			rate = input3.nextDouble();
		    		}
		    		while (rate <= 0.0);
		    		
                    // ******** New Saving Account **********   //	   
					if ( n == -1 ) 
					{
						n = 0;  // The begin number 
						Acc[n] = new SavingAccount(id, name, assets,dateGiven,rate);
					}
					else if ( n < MAX_ACC ){ 
							n++;
							Acc[n] = new SavingAccount(id, name, assets,dateGiven,rate);
					}
					System.out.println(" Thank you for choosing my bank ! ");
							
				}	// No 
				else { 
					// ***** Create new account with id and name ****** ///
					if ( n== -1 ) 
					{
						n = 0;  // The begin number 
						Acc[n] = new SavingAccount(id, name);
					}
					else if ( n < MAX_ACC ){
						  n++;
						  Acc[n] = new SavingAccount(id, name);
						}
					System.out.println(" Thank you ");
				}
			}
			else 
				System.out.println(" This id is exist on list ");
		}	
		else {
			System.out.println(" The list saving account is full.");
		}
	}
	/** display all information about this account
	 *  
	 */
	public void displayInformation(){
		// Scanner account
		String id = enterID();
		int index = getIndex(id);
		if (index == -1){
			System.out.println(" This account id is not on list. ");			
		}
		else {
			System.out.println(" Account ID : " + Acc[index].getAccountID());
			System.out.println(" Account Name : " + Acc[index].getAccountName());
			System.out.println(" Assets Account  : " + Acc[index].getAssets());
			System.out.println(" Time given : " + Acc[index].getDateGive());
			System.out.println(" Interest Rate in Day: " + Acc[index].getIRate());
		}
	}
	/** Convert String to Date Type
	 * 
	 * @param date
	 * @return
	 */
	public Date convertSTD(String date){
		String expectedPattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		Date dateGiven = null;
		try
		{
			dateGiven = formatter.parse(date);
		}catch (ParseException e){
			e.printStackTrace();
		}
		return dateGiven;
	}
	/** Get index of List account number have id as known as id input 
	 * @return 
	 * index if this id is on the list Saving Account
	 * @see
	 * -1 if if this id isn't on the list Saving Account
	 */
	public int getIndex(String id){
		for ( int i = 0 ; i <= n; i++ )
			if (Acc[i].getAccountID().equals(id)) {
				return i;
			}	
		return -1;
	}
	/** Check this id have existed in list Account ?
	 *  @param id : String input AccountID 
	 */
	public boolean isExist(String id){
		if (getIndex(id) != -1)
			return true;		
		return false;
	}
	/** Enter Account ID from keyboard 
	 * 
	 */
	public String enterID(){
		input2 = new Scanner(System.in);
		System.out.println(" Enter account ID : ");
		String id = input2.nextLine();
		id.trim();
		return id;
	}
	/** Interrupt program to notice ... 
	 * 
	 * @param input
	 */
	public void showEnd(Scanner input){	
		System.out.println("Press Enter to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.nextLine();
	}
	
	public void showMenu(){
		System.out.println(" Subject Management System ");
		System.out.println(" ----------------------------------------------- " );
		System.out.println(" 1. Append new Account ");
		System.out.println(" 2. Withdraw interest ");
		System.out.println(" 3. Partially withdraw ");
		System.out.println(" 4. Totally withdraw ");
		System.out.println(" 5. Deposit ");
		System.out.println(" 6. Display information ");
		System.out.println(" Your choice (1-6, other to quit) :");
		input1 = new Scanner(System.in);
		int c = input1.nextInt();	
		switch(c){
		case 1: // append new account
			appendAccount();	
			showEnd(input1);
			showMenu();
			break;
		case 2: // withdraw interest
			String id = enterID();
			int index = getIndex(id);	
			if (index == -1){
				System.out.println(" This account id is not on list. ");			
			}
			else {
				Acc[index].withdrawInterest();
			}
			
			showEnd(input1);
			showMenu();
			break;
		case 3 : // partially withdraw
			id = enterID();
			index = getIndex(id);
			if (index == -1){
				System.out.println(" This account id is not on list. ");			
			}
			else {
				double money;
				do {
					input3 = new Scanner(System.in);
					System.out.println(" Enter how much money do you want to withdraw with your root saving account ? ");
					money = input3.nextDouble();
					int t = Acc[index].withdrawPartially(money);
					if ( t == 0 ) break;
				}
				while ( money <= 0.0 || money > Acc[index].getAssets());
			}
			showEnd(input1);
			showMenu();
			break;
		case 4: // totally withdraw
			id = enterID();
			index = getIndex(id);
			if (index == -1){
				System.out.println(" This account id is not on list. ");			
			}
			else {
				Acc[index].withdrawTotally();
			}
			
			showEnd(input1);
			showMenu();
			break;
		case 5:	// Deposit
			id =enterID();
			index = getIndex(id);
			if (index == -1){
				System.out.println(" This account id is not on list. ");			
			}
			else {
				double rate=0.0 ,money = 0.0;
				do{
					input3 = new Scanner(System.in);
					System.out.println(" Enter the number you want to give in bank :");
					money = input3.nextDouble();
					if ( money <= 0.0 ) continue;
				}	
				while (money <= 0.0   );
				do {
					System.out.println(" Enter the interest rate : ");
					rate = input3.nextDouble();
					if ( rate <= 0.0 ) continue;
				}
				while (rate <= 0.0);
				Acc[index].Deposit(money,rate);
			}	
			showEnd(input1);
			showMenu();
			break;
		case 6: 
			displayInformation();	
			showEnd(input1);
			showMenu();
			break;	
		default : break;
		}
	}

}
