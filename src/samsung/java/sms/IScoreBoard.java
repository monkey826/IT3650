package samsung.java.sms;

public interface IScoreBoard {
	public int getIndexStudent(String studentID);
	public String enterID();
	public double enterNumber();
	public boolean readFile(String subjectID, String semesterID);
	public void updateFile();
	public int addScoreInfor();
	public boolean eraseStudentScore(String studentID);
	public String getScore(String studentID);
	public void swapName();
	public StudentScore getHighestStudentScore();
	public StudentScore getLowestStudentScore();
	public String displayStar(int number);
	public void updateFileReport(String pathReport);
	public void createFileReport();
	public void displayScore();
	public void displayScoreReport(String pathReport);
}
