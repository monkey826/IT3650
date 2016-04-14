package samsung.java.sms;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreBoard implements IScoreBoard{
	private Subject subject;
	private StudentScore[] studentScoreList = new StudentScore[100];
	public int n = 0;
	private String semesterID;
	private int numberStudent;
	private String path = ""; // create a empty path for creating a new file
	private double max ;  // calculate Max Score on list
	private double min ;  // calculate Max Score on list
	private double avg ;  // calculate Max Score on list
	private int scoreA = 0; // count the number of A score
	private int scoreB = 0; // count the number of B score
	private int scoreC = 0; // count the number of C score
	private int scoreD = 0; // count the number of D score
	private int scoreF = 0; // count the number of F score
	public ScoreBoard(){
		
	}
	/** Constructor create a new Score Board 
	 * <br> if File Score exist, read information from this file
	 * @param subject
	 * @param semesterID
	 * @param numberStudent
	 */
	public ScoreBoard(Subject subject, String semesterID, int numberStudent) {
		setSubject(subject);
		setSemesterID(semesterID);
		path = "src/samsung/java/database/" + subject.getSubjectID()
				+ "_" + semesterID + ".txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {
				System.out.println("File was created!");
				setNumberStudent(numberStudent);
			} else {
				 System.out.println("File already exists.");
				 readFile(subject.getSubjectID(), semesterID);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * @return Subject 
	 */
	public Subject getSubject() {
		return subject;
	}
	/** Setter: Set subject for ScoreBoard
	 * 
	 * @param subject
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	/** Get Semester ID
	 * 
	 * @return
	 */
	public String getSemesterID() {
		return semesterID;
	}
	/**
	 *  Set Semester ID
	 * @param semesterID
	 */
	public void setSemesterID(String semesterID) {
		this.semesterID = semesterID;
	}
	/**  Get number of students .
	 * 
	 * @return
	 */
	public int getNumberStudent() {
		return numberStudent;
	}
	/** Set number of student
	 * 
	 * @param numberStudent
	 */
	public void setNumberStudent(int numberStudent) {
		this.numberStudent = numberStudent;
	}
	/** Get index of student on list Score Board.
	 * 
	 * @param studentID
	 * @return
	 */
	@Override
	public int getIndexStudent(String studentID) {
		for (int i = 1 ; i <= n; i++ )
			if (studentScoreList[i].getStudentID().equals(studentID)) 
				return i;
		return 0;

	}
	/**
	 *  Enter String id
	 * @return
	 */
	@Override
	public String enterID(){
		Scanner input = new Scanner(System.in);
		String ID = input.nextLine();
		ID = ID.trim();
		ID = ID.toUpperCase();
		return ID;
	}
	/**
	 * Enter a number type of double
	 * @return
	 */
	@Override
	public double enterNumber(){
		Scanner input = new Scanner(System.in);
		double number = 0;
		try {		
			number = Double.parseDouble(input.nextLine());
		}
		catch (NumberFormatException nfe){
			System.out.println(nfe.getMessage());
			System.out.println(" The value will be 0 if not enter again.");
		}
		return number;
	}
	/** Read File Score....
	 * 
	 */
	@Override
	public boolean readFile(String subjectID, String semesterID){
		try(FileReader fr = new FileReader(path)){
			BufferedReader br = new BufferedReader(fr);	
			String line ="";
			StringTokenizer readData;
			// subject ID
			line = br.readLine();
			if (line == null ) {
				return false; // if file error
			}
//			String subjectID = getSubject().getSubjectID();
			// subject Name
			line = br.readLine();
			readData = new StringTokenizer(line,"|");
			readData.nextToken();
			String subjectName = readData.nextToken();
			// subject rate.
			line = br.readLine();
			readData = new StringTokenizer(line,"|");
			readData.nextToken();
			Double pointProgressRate = Double.parseDouble(readData.nextToken());
			Subject subject = new Subject(subjectID,subjectName,pointProgressRate);
			setSubject(subject);
			// semester
			line = br.readLine();
			// number of student
			line = br.readLine();
			readData = new StringTokenizer(line,"|");
			readData.nextToken();
			setNumberStudent(Integer.parseInt(readData.nextToken()));
			while ( (line=br.readLine()) != null){
				// Read until end of file
				readData = new StringTokenizer(line,"|");
				readData.nextToken();
				String studentID = readData.nextToken();
				String studentLastName = readData.nextToken("| ");
				String studentMidName = readData.nextToken("| ");
				String studentFirstName = readData.nextToken();
				double pointProcess = Double.parseDouble(readData.nextToken(" | "));
				double finalPoint = Double.parseDouble(readData.nextToken(" | "));			
				n++;
				studentScoreList[n] = new StudentScore(studentLastName, studentMidName,
						studentFirstName, studentID, pointProcess, finalPoint);
			}
			br.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		return true;
	}
	/**
	 *  Update File Score
	 */
	@Override
	public void updateFile(){
		setNumberStudent(n);
		swapName();
		try(FileWriter wr = new FileWriter(path)){
			BufferedWriter bw = new BufferedWriter(wr);
			bw.write("SubjectID|" + getSubject().getSubjectID());
			bw.newLine();
			bw.write("Subject|"+getSubject().getSubjectName());
			bw.newLine();
			bw.write("F|"+getSubject().getPointProgressRate() + "|" + getSubject().getFinalPointRate());
			bw.newLine();
			bw.write("Semester|"+ getSemesterID());
			bw.newLine();
			bw.write("StudentCount|"+ getNumberStudent());
			bw.newLine();
			for ( int i = 1 ; i <= n ; i++ ){
				bw.write(studentScoreList[i].getMarkLine(getSubject().getPointProgressRate(),getSubject().getFinalPointRate()));
				bw.newLine();
			}
			bw.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	} 
	/**
	 * Add new Student Score information
	 * @return
	 */
	@Override
	public int addScoreInfor(){
		System.out.println(" Enter Student ID");
		String studentID = enterID();
		int j = getIndexStudent(studentID);
		if ( j != 0 ) {
			// if have student on list
			System.out.println(" This student is existed on list");
			System.out.println(" Do you want change student data? ");
			System.out.println(" 1. Yes");
			System.out.println(" 2. No ");
			int c = (int)enterNumber();
			if ( c == 2) return 0; // Nothing to do
			else if ( c == 1){
				// Change values
				System.out.println(" Enter point process");
				double pointProcess = enterNumber();
				if (pointProcess == 0) {
					System.out.println(" Error! This value is wrong. ");
					return 0;
				}
				System.out.println(" Enter final point");
				double finalPoint = enterNumber();
				if (finalPoint == 0) {
					System.out.println(" Error! This value is wrong. ");
					return 0;
				}
				studentScoreList[n].changeScore(pointProcess, finalPoint);
			}
		}		
		else {
			// If student is not on list
			System.out.println(" The list not have this id, append new student");
			System.out.println(" Enter Student last name");
			String lastName = enterID();	
			System.out.println(" Enter Student middle name");
			String midName = enterID();	
			System.out.println(" Enter Student first name");
			String firstName = enterID();	
			System.out.println(" Enter point process");
			double pointProcess = enterNumber();
			if (pointProcess == 0) {
				System.out.println(" Error! This value is wrong. ");
				return 0;
			}
			System.out.println(" Enter final point");
			double finalPoint = enterNumber();	
			if (finalPoint == 0) {
				System.out.println(" Error! This value is wrong. ");
				return 0;
			}
			n++; // Increase number of student.
			studentScoreList[n] = new StudentScore(lastName, midName, firstName, studentID, pointProcess, finalPoint);
		}
		System.out.println(" Do you want to continue add new student score with this subject... ");
		System.out.println(" 1. Yes ");
		System.out.println(" 2. No ");
		int c = (int)enterNumber();
		if ( c == 1 ) addScoreInfor();
		return 1;	
	}
	/** Erase score of a student on list
	 *  
	 * @param studentID
	 */
	@Override
	public boolean eraseStudentScore(String studentID){
		int i = getIndexStudent(studentID);
		if ( i == 0 ) {
			System.out.println(" Sorry. This student is not on list");
			return false;
		}
		else {
			studentScoreList[i].changeScore(0.0,0.0);
			return true;
		}
	}
	/** Get score of student
	 * 
	 * @param studentID
	 * @return
	 */
	@Override
	public String getScore(String studentID){
		int i = getIndexStudent(studentID);
		if ( i == 0 ) System.out.println(" Sorry. This student is not on list");
		else return studentScoreList[i].getMarkLine(getSubject().getPointProgressRate(),getSubject().getFinalPointRate() );
		return null;
	}
	/**
	 * Swap first name follow form list
	 */
	@Override
	public void swapName(){
		StudentScore studentScore = new StudentScore();
		for (int i = 1 ; i < n ; i++)
			for ( int j = i +1 ; j <=n ; j++)
				if (studentScoreList[i].getFirstName().compareToIgnoreCase(studentScoreList[j].getFirstName()) > 0){
					studentScore = studentScoreList[i];
					studentScoreList[i] = studentScoreList[j];
					studentScoreList[j] = studentScore;
				}
	}
	/**
	 * 
	 * <br> calculate the value of Max,min,average Score
	 * <br> count how many A,B,C,D,F score on list score Board.
	 * @return Get Highest Student Score and this student.
	 */
	@Override
	public StudentScore getHighestStudentScore(){
		max = 0.0;
		min = 10.0;
		avg = 0.0;
		if ( n > 0){
			for (int i = 1 ; i <= n; i++ ){
				double score = studentScoreList[i].getScore();
				if (score>max) 
					max = score;
				if (score<min) 
					min = score;
				avg += score;
				if (score < 4.0 ) scoreF++;
				else if (score < 5.5) scoreD++;
				else if (score < 7.0) scoreC++; 
				else if (score < 8.4) scoreB++;
				else scoreA++;
			}
			avg = avg/(double)n;
			for (int i = 1 ; i <= n; i++ )
				if (studentScoreList[i].score==max) 
					return studentScoreList[i];
		}
		else {
			System.out.println(" Error. The database not have information about any students.");
			return null;
		}	
		return null;
	}
	/**
	 * 
	 * @return get lowest student score and this student.
	 */
	@Override
	public StudentScore getLowestStudentScore(){
		if ( n > 0){
			for (int i = 1 ; i <= n; i++ )
				if (studentScoreList[i].score==min) 
					return studentScoreList[i];
		}
		else {
			System.out.println(" Error. The database not have information about any students.");
			return null;
		}
		return null;
	}
	/**
	 * Print the number of * .
	 * @param number
	 * @return the number of *
	 */
	@Override
	public String displayStar(int number){
		String s = "";
		for (int i = 0 ; i < number; i++)
			s += "*";
		return s;
	}
	/*
	 * Update File Report.
	 */
	@Override
	public void updateFileReport(String pathReport){
		try(FileWriter fw = new FileWriter(pathReport)){
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(getSubject().getSubjectID()+"_"+getSemesterID()+"_rp.txt");
			bw.newLine();
			bw.newLine();
			StudentScore studentH = getHighestStudentScore();
			StudentScore studentL = getLowestStudentScore();
			bw.write("The student with the highest mark is: "+ studentH.getLastName() + " "+studentH.getMidName() + " "+studentH.getFirstName());
			bw.newLine();
			bw.write("The student with the highest mark is: "+ studentL.getLastName() + " "+studentL.getMidName() + " "+studentL.getFirstName());
			bw.newLine();
			bw.write("The average mark is: "+avg);
			bw.newLine();
			bw.newLine();
			bw.write("A histogram of the subject "+getSubject().getSubjectID() +" is:  ");
			bw.newLine();
			bw.newLine();
			bw.write("A:"+displayStar(scoreA));
			bw.newLine();
			bw.write("B:"+displayStar(scoreB));
			bw.newLine();
			bw.write("C:"+displayStar(scoreC));
			bw.newLine();
			bw.write("D:"+displayStar(scoreD));
			bw.newLine();
			bw.write("F:"+displayStar(scoreF));			
			bw.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Create File report. If file is exist, update file.
	 */
	@Override
	public void createFileReport(){
		String pathReport = "src/samsung/java/database/" + getSubject().getSubjectID()
				+ "_" + getSemesterID() + "_rp.txt";
		try{
			File file = new File(pathReport);
			if (!file.createNewFile()){
				System.out.println(" File report is exist. Updating information ");
				updateFileReport(pathReport);
				displayScoreReport(pathReport);
			}
			else {
				System.out.println(" Creating new file record and updating now.");
				updateFileReport(pathReport);
				displayScoreReport(pathReport);
			}	
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Display Student Score information to Console window
	 */
	@Override
	public void displayScore(){
		try(FileReader fr = new FileReader(path)){
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null ){
				System.out.println(line);
			}
			System.out.println();
			br.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Display Student Score Report information to Console window
	 * @param pathReport : link to file report
	 */
	@Override
	public void displayScoreReport(String pathReport){
		try(FileReader fr = new FileReader(pathReport)){
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null ){
				System.out.println(line);
			}
			System.out.println();
			br.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}


	
}
