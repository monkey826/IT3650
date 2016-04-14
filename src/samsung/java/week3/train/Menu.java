package samsung.java.week3.train;

import java.io.IOException;
import java.util.Scanner;
/** Menu program
 * 
 * @author monkey
 *
 */
public class Menu {
	private Scanner input1 = new Scanner(System.in); // int
	private Scanner input2 = new Scanner(System.in); // String
	private Scanner input3 = new Scanner(System.in); // double
	private  final int MAX_LIST = 40;
	private  RailCar[] rc = new RailCar[MAX_LIST];
	private  int noRC = -1; // number of RailCar list
	private  PassengerCarriage[] pc = new PassengerCarriage[MAX_LIST];
	private  int noPC = -1;// number of PassengerCarriage list
	private  GoodsCar[] gc = new GoodsCar[MAX_LIST];
	private  int noGC = -1; // number of GoodsCar list
	/** Append new type of train : rail car or passenger carriage or goods car
	 * 
	 */
	public void appendTrain(){
		System.out.println(" Choose type of train ");
		System.out.println(" 1. Rail Car");
		System.out.println(" 2. PassengerCarriage ");
		System.out.println(" 3. GoodsCar");
		System.out.println(" Other to quit . ");
		int c1 = input1.nextInt();
		// Check id exist
		String ID ="";
		do{
			System.out.println(" Enter train ID :");
			ID = input2.nextLine();
		}
		while (ID.length() <= 0);
		// Check unweight input < 0
		double unWeight = -1;
		do{
			System.out.println(" Enter train unweight ");
			unWeight = input3.nextDouble();
		}
		while (unWeight < 0.0);
		switch(c1){
		case 1: 
			appendObject(1,noRC,ID,unWeight,0);
			break;
		case 2: 
			int numPassenger =0;
			do{
				System.out.println(" Enter the number of passenger ");
				numPassenger = input1.nextInt();
			}
			while (numPassenger < 0);
			appendObject(2,noPC,ID,unWeight,numPassenger);
			break;
		case 3: 
			double goodsWeight;
			do{
				System.out.println(" Enter the value of goods weight");
				goodsWeight = input3.nextDouble();
			}
			while (goodsWeight < 0.0);
			appendObject(3,noGC,ID,unWeight,goodsWeight);
			break;
		default : 
			break;
		}
	}	
	/** Append new element in list : there are 3 types of list . 
	 * 	So , I have 3 if-else to specify what list need to add new
	 * 
	 * @param c : type of list : 1. RC, 2.PC, 3. GC
	 * @param n : number of this list
	 * @param ID : String ID 
	 * @param unWeight : unweight
	 * @param m : weight status: = 0 if type train = RC, and = other if type = PC, GC depends on type of train.
	 */
	public void appendObject( int c,int n,String ID, double unWeight, double m){
		if ( n == -1 ){
 			/** Add new object with each situation : RC or GC or PC
			 *  
			 */
				if ( c == 1 ){
					noRC = 0;
					rc[noRC] = new RailCar(ID, unWeight);
				}
					
				else if ( c == 2 ){
					if ( isExistID(ID)) System.out.println(" Failed. This id is on list.");
					else {
						noPC = 0;
						pc[noPC]= new PassengerCarriage(ID,unWeight,(int)m);
						pc[noPC].updateWeightContains();
					}	
				}
					
				else if ( c == 3){
					if ( isExistID(ID)) System.out.println(" Failed. This id is on list.");
					else {
						noGC=0;
						gc[noGC] = new GoodsCar(ID, unWeight, m);
					}
				}		
		}
		else 
			/** 
			 *  MAX LIST.
			 */
		if ( n == MAX_LIST - 1 ) {
				System.out.println(" This list was full ");
		}
			/**
			 * Not Max list
			 */
		else {
				if (isExistID(ID)){
					System.out.println(" Error! This id was on list ");
				}
				else{
					if ( c == 1 ){
						noRC++;
						rc[noRC] = new RailCar(ID, unWeight);
					}
					
					else if ( c == 2) {
						noPC++;
						pc[noPC]= new PassengerCarriage(ID,unWeight,(int)m);
						pc[noPC].updateWeightContains();
					}	
					else if ( c == 3){
						noGC++;
						gc[noGC] = new GoodsCar(ID, unWeight, m);
					}
				}				
		}		
	}
	/** Check this id is on 3 lists ?
	 * 
	 * @param ID : String id
	 * @return this ID have existed on list?
	 */
	public boolean isExistID(String ID){
		if (typeTrain(ID)==0) return false;
		// if this list have more than >40, big data then this method is very slow because call loop many times.
		return true;
	}
	/** Find what kind of train have this string ID
	 * 
	 * @param ID : string ID input
	 * @return type of train
	 */
	public int typeTrain(String ID){ // return type of object
		if (getIndexOfRC(ID) != -1)
				return 1;
		if (getIndexOfPC(ID) != -1)
				return 2;
		if (getIndexOfGC(ID) != -1)
				return 3;
		// If big data, this class can add new attributes to store the position of that element have this string id.
		// should be decrease using loop.
		return 0;
	}
	/** Get Index of railcar
	 * 
	 * @param ID : string id input
	 * @return index of rail car have string id
	 */
	public int getIndexOfRC(String ID){
		for ( int i = 0 ; i <= noRC ; i++)
			if (rc[i].getID().equals(ID)){
				return i;
			}
		return -1;
	}
	/** get index of Passenger Carriage 
	 * 
	 * @param ID : string id input
	 * @return index of passenger carriage have string id
	 */
	public int getIndexOfPC(String ID){
		for ( int i = 0 ; i <= noPC ; i++)
			if (pc[i].getID().equals(ID))
				return i;
		return -1;
	}
	/** Get index of goods car
	 * 
	 * @param ID : string id input
	 * @return index of goodscar have string id
	 */
	public int getIndexOfGC(String ID){
		for ( int i = 0 ; i <= noGC ; i++)
			if (gc[i].getID().equals(ID))
				return i;
		return -1;
	}
//	?? QS: Can reference object and using it . Use Object class?
	/**  display all information about this train : all type of train: railcar, passengercarriage,goodscar
	 * 
	 */
	public void displayInfor(){ 
		int x = 0;
		if (noRC != -1)
			for (int i = 0 ; i <= noRC; i++ ){
				x++;
				System.out.println(x + ". ");
				rc[i].displayAll();
				
			}
		if (noGC != -1 )
			for (int i = 0; i<= noGC ; i++ ){
				x++;
				System.out.println(x + ". ");
				gc[i].displayAll();
			}
		if (noPC != -1 ) 
			for ( int i = 0 ; i <= noPC ; i++ )
			{
				x++;
				System.out.println(x + ". ");
				pc[i].displayAll();
			}
			
	}
	/** Get off the train with Passenger Carriage 
	 *  <br> Number of passenger get off is input from outside program
	 */
	public void getOff(){
		System.out.println(" Enter ID: ");
		String ID = input2.nextLine();
		int i = getIndexOfPC(ID);
		if (i == -1 ) 
			System.out.println(" This id is not on list");
		else {
			System.out.println(" Enter the number of passenger get off the train ");
			int n = input1.nextInt();
			pc[i].getOffPassenger(n);
			pc[i].updateWeightContains();
			
		}
		
	}
	/** Take on the train with Passenger Carriage 
	 *  <br> Number of passenger take on is input from outside program
	 */
	public void takeOn(){
		System.out.println(" Enter ID: ");
		String ID = input2.nextLine();
		int i = getIndexOfPC(ID);
		if (i == -1 ) 
			System.out.println(" This id is not on list");
		else {
			System.out.println(" Enter the number of passenger take on the train ");
			int n = input1.nextInt();
			pc[i].takePassenger(n);
			pc[i].updateWeightContains();
			
		}
	}
	/** Display : Enter to continue ..
	 * 
	 */
	public void displayNext(){
		System.out.println("Press Enter to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input2.nextLine();
	}
	/** Display Menu Project/Database
	 * 
	 */
	public void displayMenu(){
		System.out.println(" Railcar Management System ");
		System.out.println(" --------------------------------------");
		System.out.println(" 1. Append new train ");
		System.out.println(" 2. Display the information of train ");
		System.out.println(" 3. Passenger gets off the train ");
		System.out.println(" 4. Passenger takes the train");
		System.out.println(" Your choice (1-4 ,other to quit )");
		int c = input1.nextInt();
		switch(c){
		case 1: 
			appendTrain();
			displayNext();
			displayMenu();
			break;
		case 2:
			displayInfor();
			displayNext();
			displayMenu();
			break;
		case 3:
			if (noPC != -1)
				getOff();
			else 
				System.out.println(" Error ! The train don't have passenger carriage");
			displayNext();
			displayMenu();
			break;
		case 4:
			if (noPC != -1)
				takeOn();
			else 
				System.out.println(" Error ! The train don't have passenger carriage");
			displayNext();
			displayMenu();
			break;
		default:
			break;
		}
	}
}
