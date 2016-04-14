package samsung.java.sms;

public class StudentScore {
	private String lastName;
	private String midName;
	private String firstName;
	private String studentID;
	private double pointProgress;
	private double finalPoint;
	public double score = 0;
	/**
	 * The constructor default. No parameters.
	 */
	public StudentScore(){	
	};
	/**
	 * The constructor defined
	 * @param lastName
	 * @param midName
	 * @param firstName
	 * @param studentID
	 * @param pointprogress
	 * @param finalPoint
	 */
	public StudentScore(String lastName, String midName, String firstName,
			String studentID, double pointProgress, double finalPoint) {
		setLastName(lastName);
		setMidName(midName);
		setFirstName(firstName);
		setStudentID(studentID);
		setPointProgress(pointProgress);
		setFinalPoint(finalPoint);
		
	}
	/**
	 * Set Subject Score . 
	 * @param pointprogressRate
	 * @param finalPointRate
	 * @return  Subject Score 
	 */
	protected double setScore(double pointProgressRate, double finalPointRate ){
		this.score = (pointProgressRate*getPointProgress() + finalPointRate*getFinalPoint())/100;
		return score;
	}
	/**
	 * 
	 * @return subject score
	 */
	protected double getScore(){
		return score;
	}
	/**
	 * 
	 * @return Last name
	 */
	protected String getLastName() {
		return lastName;
	}
	/**
	 * Set Last name
	 * @param lastName
	 */
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Getter 
	 * @return Middle name
	 */
	protected String getMidName() {
		return midName;
	}
	/**
	 * Set middle name
	 * @param midName
	 */
	protected void setMidName(String midName) {
		this.midName = midName;
	}
	/**
	 * 
	 * @return first name
	 */
	protected String getFirstName() {
		return firstName;
	}
	/**
	 * Setter: set first name
	 * @param firstName
	 */
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return student ID
	 */
	protected String getStudentID() {
		return studentID;
	}
	/**
	 * Setter: Set student ID
	 * @param studentID
	 */
	protected void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	/**
	 * 
	 * @return point progress
	 */
	protected double getPointProgress() {
		return pointProgress;
	}
	/**
	 * Setter: Set point progress
	 * @param pointProgress
	 */
	protected void setPointProgress(double pointProgress) {
		if ( pointProgress >= 0.0  && pointProgress <= 10.0)
			this.pointProgress = pointProgress;
	}
	/**
	 * 
	 * @return final point
	 */
	protected double getFinalPoint() {
		return finalPoint;
	}
	/**
	 * Set final point
	 * @param finalPoint
	 */
	protected void setFinalPoint(double finalPoint) {
		if ( finalPoint >= 0.0 && finalPoint<=10.0  )
			this.finalPoint = finalPoint;
	}
	/**
	 * Get Mark char.
	 * @param pointProgressRate
	 * @param finalPointRate
	 * @return Mark char.
	 */
	public String getMark(double pointProgressRate, double finalPointRate ){
		double score = setScore(pointProgressRate,finalPointRate);	
		if (score < 4.0 ) return "F";
		else if (score < 5.5) return "D";
		else if (score < 7.0) return "C";
		else if (score < 8.4) return "B";
		else return "A";
	}
	/**
	 * Get all information about score of student.
	 * @param pointProgressRate
	 * @param finalPointRate
	 * @return Get Mark Line 
	 */
	public String getMarkLine(double pointProgressRate, double finalPointRate ){
		String s="";
		s = "S|" + getStudentID()+"|"+getLastName()+" "+getMidName();
		s = s +"  |"+getFirstName()+ " | "+getPointProgress()+ " | "+getFinalPoint()+" | " + getMark(pointProgressRate,finalPointRate ) +" |";
		return s;
	}
	/**
	 * Change Score of student
	 * @param pointProgress
	 * @param finalPoint
	 */
	public void changeScore(double pointProgress, double finalPoint){
		setPointProgress(pointProgress);
		setFinalPoint(finalPoint);
	}
}
