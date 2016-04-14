package samsung.java.week3.sas;
/** The subject class presents a subject with many attributes : ID,name,numberCredits, practiceCredits, tuitionCredits, 
 *  tuitionFee.
 * @author monkey
 *
 */
public class Subject implements ISubject{
	private String ID;
	private String name;
	private int numberCredits;
	private int practiceCredits;
	/** The constructor initiate 5 attributes with arguments input
	 * 
	 * @param ID
	 * @param name
	 * @param numberCredits
	 * @param practiceCredits
	 */
	public Subject(String ID, String name,int numberCredits,int practiceCredits ){
		setID(ID);
		setName(name);
		setNumberCredits(numberCredits);
		setPracticeCredits(practiceCredits);
//		setTuitionCredits();
	}
	/** Getter: Get subject ID
	 * 
	 * @return ID
	 */
	@Override
	public String getID() {
		return ID;
	}
	/**  Setter: Set subject ID
	 * 
	 * @param ID
	 */
	protected void setID(String ID) {
		this.ID = ID;
	}
	/** Getter: Get subject name
	 * 
	 * @return  name
	 */
	@Override
	public String getName() {
		return name;
	}
	/** Setter: Set name subject
	 * 
	 * @param name 
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/** Getter: Get number credits
	 * 
	 * @return number credits
	 */
	@Override
	public int getNumberCredits() {
		return numberCredits;
	}
	/** Setter: Set number credits. 
	 * 
	 * @param numberCredits : number credits. 
	 */
	protected void setNumberCredits(int numberCredits) {
		this.numberCredits = numberCredits;
	}
	/** Getter: Get practice credits 
	 * 
	 * @return practice credits 
	 */
	protected int getPracticeCredits() {
		return practiceCredits;
	}
	/** Setter: Set practice credits 
	 * 
	 * @param practiceCredits : practice credits 
	 */
	protected void setPracticeCredits(int practiceCredits) {
		this.practiceCredits = practiceCredits;
	}
	/** : get tuition Credits
	 * 
	 * @return tuition Credits
	 */
	protected int getTuitionCredits() {
	int pc = getPracticeCredits();
	int nc = getNumberCredits();
	return pc*2 + ( nc - pc );
	}
	/** Get tuition Fee
	 * @return Tuition Fee
	 */
	public long getFee(){
		return getTuitionCredits()*150000;
	}
	/** The method for getting enrolment line
	 * 
	 */
	@Override
	public String getEnrolmentLine(){
		String name = getName();
		if (name.length() > 20) name=name.substring(20);
		String s =" "+ getID() + "  " + getName() + "  " + getTuitionCredits()+ "  " + getFee();
		return s;
	}
}
