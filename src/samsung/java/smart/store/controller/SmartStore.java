package samsung.java.smart.store.controller;

import javax.swing.SwingUtilities;

/**
 * @author Bui Trong Tung This SmartStore class is the main class to start Smart
 *         Store application
 */
public class SmartStore {

	public static void main(String[] args) {
		// Run GUI codes in the Event-Dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SignInController(); // Let the constructor do the job
			}
		});
	}
}
