package samsung.java.week3.sas;

public interface ISubject {
	/**
	 * 
	 * @return the cost of this subject
	 */
	public long getFee();
	/**
	 * 
	 * @return String form for printing notice pay tuition fees
	 */
	public String getEnrolmentLine();
	/**
	 * 
	 * @return Subject ID
	 */
	public String getID();
	/**
	 * 
	 * @return Subject name
	 */
	public String getName();
	/**
	 * 
	 * @return number of credits
	 */
	public int getNumberCredits();
}
