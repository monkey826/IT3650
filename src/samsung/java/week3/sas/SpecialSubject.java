package samsung.java.week3.sas;
/** The special subject class presents a special subject inherited from subject class
 * 
 * @author monkey
 *
 */
public class SpecialSubject extends Subject implements ISpecialSubject{
	private String nameProgram; // Name of special program
	/** The constructor method 
	 * 
	 * @param ID
	 * @param name
	 * @param numberCredits
	 * @param practiceCredits
	 * @param nameProgram
	 */
	public SpecialSubject(String ID, String name,int numberCredits,int practiceCredits,String nameProgram ){
		super(ID,name,numberCredits,practiceCredits);
		this.nameProgram = nameProgram;
	}
	/** Getter: Get name of program
	 * 
	 * @return Name of program
	 */
	public String getNameProgram(){
		return nameProgram;
	}

	/** The method for getting special fee
	 *  @return special fee
	 */
	public long getSpecialFee(){
		String name = getNameProgram();
		if (name.equals("SIE")) return 50000*getTuitionCredits();
		if (name.equals("HEDSPI")) return 20000*getTuitionCredits();
		if (name.equals("ICT")) return 30000*getTuitionCredits();
		return 0;
	}
	/** The method for getting total fee
	 * @return get total fee
	 */
	public long getFee(){
		return super.getFee() + getSpecialFee();
	}
	/** The method for getting enrolment Line
	 * @return String form : get enrolment Line
	 */
	public String getEnrolmentLine(){
		String name = super.getName();
		if (name.length() > 20 ) name = name.substring(20);
		String s = " "+ super.getID()+ "  " + name +"  " +  nameProgram ;
		s = s +"  "+ super.getTuitionCredits() + " " +super.getFee() + "  "+ getSpecialFee();
		return s;
	}
}
