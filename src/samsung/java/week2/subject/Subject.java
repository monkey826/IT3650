package samsung.java.week2.subject;
/** This class service information with 4 attributes : id, name, MaxRegister and CurrentRegister
 * 
 * @author Nam Tien
 * @since 25/1/2016
 * 
 */
public class Subject {
	private String subjectID;
	private String subjectName;
	private int quota;
	private int currentEnrolment;
	/** Getter: take subjectID
	 * 
	 * @return  Subject ID
	 */
	public String getSubjectID() {
		return subjectID;
	}
	/** Setter: Set subject ID
	 *  
	 * @param subjectID : SubjectID input
	 */
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	/** Getter: Take subject name
	 *  
	 * @return subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/** Setter : Set subject name
	 * 
	 * @param subjectName : SubjectName input
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/** Getter: Take Quota
	 * 
	 * @return quota
	 */
	public int getQuota() {
		return quota;
	}
	/** Setter: Set quota 
	 *  
	 * @param quota : quota input
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}
	/** Getter: Take current Enrolment
	 * 
	 * @return : current enrolment
	 */
	public int getCurrentEnrolment() {
		return currentEnrolment;
	}
	/** Setter: set Current Enrolment
	 * 
	 * @param currentEnrolment : currentEnrolment input
	 */
	public void setCurrentEnrolment(int currentEnrolment) {
		this.currentEnrolment = currentEnrolment;
	}
	/** 
	 *  Add a student with this subject
	 */
	public void addAnEnrolment(){			
		this.currentEnrolment += 1 ;
	}
	/** 
	 *  reject a student with this subject
	 */
	public void rejectAnEnrolment(){
		this.currentEnrolment -= 1 ;
	}
	
	
	
}
