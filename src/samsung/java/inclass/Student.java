package samsung.java.inclass;

import java.util.Random;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class Student {
	private String studentID;
	private String fullName;
	private int level;
	private int maxRegisteredCredits;
	private int currentCredits;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxRegisteredCredits() {
		return maxRegisteredCredits;
	}
	public void setMaxRegisteredCredits(int maxRegisteredCredits) {
		this.maxRegisteredCredits = maxRegisteredCredits;
	}
	public int getCurrentCredits() {
		return currentCredits;
	}
	public void setCurrentCredits(int numberCredits) {
		int n = numberCredits + currentCredits;
		if ( n < getMaxRegisteredCredits())
			this.currentCredits += numberCredits;
		else 
			System.out.println(" Cannot add this subject because over MaxRegisteredCredits");
	}
	public Student(String initStudentID, String initFullName, int initLevel, int initMaxRegisteredCredits, int initCurrentCredits){
		this.studentID = initStudentID;
		this.fullName = initFullName;
		this.level = initLevel;
		this.maxRegisteredCredits = initMaxRegisteredCredits;
		this.currentCredits = initCurrentCredits;
	}
	public void enrolSubject(int numberCredits){
		/** Java doc
		 *  Add subject for this student
		 */
		if (numberCredits > 0 && numberCredits < 15)
			setCurrentCredits(numberCredits);
	}
	public void unEnrolSubject(int numberCredits){
		if (numberCredits > 0 && numberCredits < 15)
			setCurrentCredits(-numberCredits);
	}
	public void displayStudentInfo(){
		System.out.println(" Student ID : " + getStudentID());
		System.out.println(" Full name : " +getFullName());
		System.out.println(" Level : " + getLevel());
		System.out.println(" Max Registered Credits : "+ getMaxRegisteredCredits());
		System.out.println(" Current Credits : "+ getCurrentCredits());
	}
	
	public static void main(String[] args){
		Random rd = new Random();
		double tempMin = 5;
		double tempMax = 45;
		Double temperatureValue = tempMin + (tempMax - tempMin)*rd.nextDouble();
		
		System.out.println(temperatureValue.toString().substring(0, 5));
		double humidityMin = 50;
		double humidityMax = 100;
		double humidityValue = humidityMin + (humidityMax - humidityMin)*rd.nextDouble();
		System.out.println((float)(Math.random()*100+0));
		Student s1 = new Student("20133924","Dao Nam Tien",3,24,17);
		s1.displayStudentInfo();
		s1.enrolSubject(3);
		s1.displayStudentInfo();
		s1.unEnrolSubject(4);
		s1.displayStudentInfo();
		JFrame frame = new JFrame("MenuSample Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();

	    // File Menu, F - Mnemonic
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(fileMenu);

	    // File->New, N - Mnemonic
	    JMenuItem newMenuItem = new JMenuItem(new ShowAction(frame));
	    fileMenu.add(newMenuItem);

	    frame.setJMenuBar(menuBar);
	    frame.setSize(350, 250);
	    frame.setVisible(true);
	}
	

 
}
class ShowAction extends AbstractAction {
	  Component parentComponent;

	  public ShowAction(Component parentComponent) {
//	    super("About");
	    putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_A));
	    this.parentComponent = parentComponent;
	  }

	  public void actionPerformed(ActionEvent actionEvent) {
	    Runnable runnable = new Runnable() {
	      public void run() {
	        JOptionPane.showMessageDialog(parentComponent, "About Swing", "About Box V2.0",
	            JOptionPane.INFORMATION_MESSAGE);
	      }
	    };
	    EventQueue.invokeLater(runnable);
	  }
	}