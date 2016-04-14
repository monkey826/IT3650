package samsung.java.week3.train;
/** Describe a passenger carriage with number of passenger
 * 
 * @author monkey
 *
 */
public class PassengerCarriage extends RailCar{
	private int numPassenger;
	private static double weightContains;
	/** The constructor method with 3 arguments input
	 * 
	 * @param ID : Rail Car ID
	 * @param unWeight : unweight
	 * @param numPassenger : number of passenger
	 */
	public PassengerCarriage(String ID, double unWeight,int numPassenger){
		super(ID,unWeight);
//		this.numPassenger = numPassenger;
		setNumPassenger(numPassenger);
	}
	/** Getter: Get number of passenger
	 * 
	 * @return number of passenger
	 */
	protected int getNumPassenger() {
		return numPassenger;
	}
	/** Setter: set number of passenger
	 * 
	 * @param numPassenger : input
	 */
	protected void setNumPassenger(int numPassenger) {
		this.numPassenger = numPassenger;
	}
	/** update weight contains
	 * 
	 */
	public void updateWeightContains(){
		weightContains = (double)getNumPassenger()/10;
	}
	/** Calculate total weight of this passenger carriage
	 *  
	 * @return total weight
	 */
	public double calTotalWeight(){
		// Need to update weight contains before call  super
		return getUnWeight() + weightContains;
		
	}
	/** display all information about passenger carriage
	 * 
	 */
	public void displayAll(){
		super.displayAll();
		System.out.println(" Number of passenger : " + getNumPassenger());
		System.out.println(" Total weight " + calTotalWeight() + " tons");
	}
	/**  Reject more passenger into this rail car with number input
	 * 
	 */
	public void getOffPassenger(int n){
		int np = getNumPassenger();
		if ( np - n >=0 ){
			setNumPassenger( np - n );
			System.out.println(" Succesful ");
		}		
		else 
			System.out.println(" Failed. This number input is higher than the current passenger in train");
	}
	/** Add more passenger into this rail car with number input
	 * 
	 */
	public void takePassenger(int n){
		setNumPassenger( getNumPassenger() + n );
		System.out.println(" Succesful ");
	}
	

	
}
