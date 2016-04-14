package samsung.java.sms;

public class Subject {
	private String subjectID;
	private String subjectName;
	private double pointProgressRate;
	private double finalPointRate;
	/**
	 * Subject constructor 
	 * @param ID
	 * @param name
	 * @param pointProgressRate
	 */
	public Subject(String ID, String name, double pointProgressRate){
		setSubjectID(ID);
		setSubjectName(name);
		setPointProgressRate(pointProgressRate);
		setFinalPointRate();
	}
	/**
	 * Get Subject ID
	 * @return Subject ID
	 */
	protected String getSubjectID() {
		return subjectID;
	}
	/**
	 * Set Subject ID
	 * @param subjectID
	 */
	protected void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	/**
	 * 
	 * @return Subject Name
	 */
	protected String getSubjectName() {
		return subjectName;
	}
	/**
	 * Set Subject name
	 * @param subjectName
	 */
	protected void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * 
	 * @return point progress rate
	 */
	protected double getPointProgressRate() {
		return pointProgressRate;
	}
	/**
	 * Set point progress rate
	 * @param pointProgressRate
	 */
	protected void setPointProgressRate(double pointProgressRate) {
		this.pointProgressRate = pointProgressRate;
	}
	/**
	 * 
	 * @return final point rate
	 */
	protected double getFinalPointRate() {
		return finalPointRate;
	}
	/**
	 * Set final point rate in 100 level.
	 */
	protected void setFinalPointRate() {
		
		this.finalPointRate = 100.0 - getPointProgressRate();
	}
	
}
