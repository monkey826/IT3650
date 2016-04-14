package samsung.java.sms;

import java.io.IOException;
import java.util.Scanner;

public class ScoreManagement {
	private Scanner input;
	private ScoreBoard[] scoreBoard = new ScoreBoard[100];
	private int n = 0;
	/**
	 * String input
	 * @return
	 */
	public String enterString() {
		input = new Scanner(System.in);
		String ID = input.nextLine();
		ID = ID.trim();
		ID = ID.toUpperCase();
		return ID;
	}
	/**
	 *  Number input
	 * @return
	 */
	public double enterNumber() {
		input = new Scanner(System.in);
		double number = 0.0;
		try {
			number = Double.parseDouble(input.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			System.out.println(" <Warning> The number value will be 0 if not enter again.");
		}
		return number;
	}
	/**
	 * Ask user want to continue this function ???
	 * @return
	 */
	public boolean askContinue(){
		System.out.println(" Do you want to continue... ");
		System.out.println(" Y/N ? ");
		String s = enterString();
		if ( s.equalsIgnoreCase("Y")) return true;
		return false;
	}
	/**
	 *  Add new subject
	 * @return 
	 */
	public Subject addNewSubject() {
		System.out.println(" Enter Subject ID");
		String ID = enterString();
		while (ID.length() == 0) {
			System.out.println(" Error. SubjectID is empty");
			ID = enterString();
		}
		System.out.println(" Enter Subject name ");
		String name = input.nextLine();
		double ppr;
		do{
			System.out.println(" Enter point prgress rate (0<ppr<100) ");
			ppr = enterNumber();
		}
			while( ppr > 100 || ppr == 0);
//		if (ppr == 0) {
//			System.out.println(" Error! This value is wrong. ");
//			return null;
//		}
		Subject subject = new Subject(ID, name, ppr);
		return subject;
	}
	/**
	 *  Case 1 :add new Score board
	 */
	public void addNewScoreBoard() {
		Subject subject = addNewSubject();
		System.out.println(" Enter semester ID ");
		String semesterID = enterString();
		while (semesterID.length() == 0) {
			System.out.println(" Error. SemesterID is empty");
			semesterID = enterString();
		}
		System.out.println(" Enter the number of student ");
		int number = (int)enterNumber();
		n++;
		scoreBoard[n] = new ScoreBoard(subject, semesterID, number);
		if (askContinue()) addNewScoreBoard();
		
	}
	/**
	 *  Get index of score board is list
	 * @param subjectID
	 * @param semesterID
	 * @return 
	 */
	public int getIndexScoreBoard(String subjectID, String semesterID) {
		for (int i = 1; i <= n; i++)
			if (scoreBoard[i].getSubject().getSubjectID().equalsIgnoreCase(subjectID)
					&& scoreBoard[i].getSemesterID().equalsIgnoreCase(semesterID)) {
				return i;
			}
		return 0;
	}
	/** 
	 *  Case 2 : Add new score student and about student information
	 *  <br> Update Score file
	 */
	public void addNewScoreStudent() {
		System.out.println(" Enter subject ID");
		String subjectID = enterString();
		System.out.println(" Enter semester ID ");
		String semesterID = enterString();
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0)
			System.out.println(" Sorry. The database don't have subject "
					+ subjectID + " on semester " + semesterID);
		else {
			scoreBoard[i].addScoreInfor();
			scoreBoard[i].updateFile();
		}
		if (askContinue()) addNewScoreStudent();
	}
	/**
	 *  Case 3:  Remove Score
	 *  <br> Update Score file.
	 */
	public void removeScore() {
		System.out.println(" Enter subject ID");
		String subjectID = enterString();
		System.out.println(" Enter semester ID ");
		String semesterID = enterString();
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0){
			System.out.println(" Sorry. The database don't have subject. "
					+ subjectID + " on semester " + semesterID);
		}
			
		else {
			System.out.println(" Enter Student ID");
			String studentID = enterString();
			scoreBoard[i].eraseStudentScore(studentID);
			scoreBoard[i].updateFile();
		}
		if (askContinue()) removeScore();
	}
	/**
	 * Case 4: Search score 
	 *  
	 */
	public void searchScore() {
		System.out.println(" Enter subject ID");
		String subjectID = enterString();
		System.out.println(" Enter semester ID ");
		String semesterID = enterString();
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0)
			System.out.println(" Sorry. The database don't have subject "
					+ subjectID + " on semester " + semesterID);
		else {
			System.out.println(" Enter Student ID");
			String studentID = enterString();
			System.out.println(scoreBoard[i].getScore(studentID));
		}
		if (askContinue()) searchScore();

	}
	/**
	 * Case 5: Display all information about score board. : score and score report
	 * <br> Update all files.
	 */
	public void displayScoreBoard(){
		System.out.println(" Enter subject ID");
		String subjectID = enterString();
		System.out.println(" Enter semester ID ");
		String semesterID = enterString();
		
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0)
			System.out.println(" Sorry. The database don't have subject "
					+ subjectID + " on semester " + semesterID);
		else {
			if (scoreBoard[i].n == 0) {
				System.out.println(" Please enter student score information before use this function");
			}
			else{
				scoreBoard[i].updateFile();
				scoreBoard[i].displayScore();
				scoreBoard[i].createFileReport();
			}
			
		}
		if (askContinue()) displayScoreBoard();
	}
	/**
	 * Show continue sentence,
	 */
	public void displayNext() {
		System.out.println(" Press enter to continue ");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input.nextLine();
	}
	/**
	 * Show Menu and realize the program.
	 */
	public void displayMenu() {
		System.out.println(" Learning management system ");
		System.out.println(" ---------------------------------------------- ");
		System.out.println(" 1. Add a new score board ");
		System.out.println(" 2. Add score ");
		System.out.println(" 3. Remove score ");
		System.out.println(" 4. Search score ");
		System.out.println(" 5. Display score board and score report ");
		System.out.println(" Your choice (1-5, other to quit): ");
		int c = (int)enterNumber();
		switch (c) {
		case 1:
			addNewScoreBoard();
			displayNext();
			displayMenu();
			break;
		case 2:
			addNewScoreStudent();
			displayNext();
			displayMenu();
			break;
		case 3:
			removeScore();
			displayNext();
			displayMenu();
			break;
		case 4:
			searchScore();
			displayNext();
			displayMenu();
			break;
		case 5:
			displayScoreBoard();
			displayNext();
			displayMenu();
			break;
		default:
			break;
		}
	}
}
