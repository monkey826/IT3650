package samsung.java.week3.train;
/** RailCar class describe a rail car with ID and unWeight
 * 
 * @author monkey
 *
 */
public class RailCar {
	protected String ID;
	protected double unWeight;
	/** The constructor with 2 arguments : ID and unWeight
	 * 
	 */
	public RailCar(String ID, double unWeight){
		setID(ID);
		setUnWeight(unWeight);
	}
	/** Getter : Get rail car id
	 * 
	 * @return rail car id
	 */
	protected String getID() {
		return ID;
	}
	/** Setter : Set rail car id
	 * 
	 * @param iD : id input
	 */
	protected void setID(String ID) {
		this.ID = ID;
	}
	/** Getter : 
	 * 
	 * @return
	 */
	protected double getUnWeight() {
		return unWeight;
	}
	/** setter: set unweight
	 * 
	 * @param unWeight
	 */
	protected void setUnWeight(double unWeight) {
		this.unWeight = unWeight;
	}
	/** The method to display all information about a rail car
	 *  
	 */
	public void displayAll(){
		System.out.println("  ID : " + getID());
		System.out.println("  unWeight : " +getUnWeight() + " tons");
	}
	
}
