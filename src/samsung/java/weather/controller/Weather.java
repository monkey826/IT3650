package samsung.java.weather.controller;

import javax.swing.SwingUtilities;

/**
 * 
 * @author Dao Nam Tien
 * The Main Program
 *
 */
public class Weather {
	public static void main(String[] args) {
		// Run GUI codes in the Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainUIController(); // Let the constructor do the job
			}
		});
	}
}
