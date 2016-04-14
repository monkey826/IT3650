package samsung.java.smart.store.view;

import java.awt.event.ActionListener;

import javax.swing.event.MenuListener;

/**
 * @author Bui Trong Tung
 *	The IMainView interface assign methods to main window of the Smart Store System  
 */
public interface IMainView {
	/**
	 * Create new menu bar
	 */
	public void createMenuBar();
	/**
	 *  Exit program.
	 *  @param listener A ActionListener listens the event when the user choose exit menu
	 */
	public void setExitActionListener(MenuListener listener);
	/**
	 * Add the Create new account menu item on menu if the signed user is admin
	 */
	public void addCreateAccountMenu();
	
	/**
	 * Set listener to Create new account menu item
	 * @param listener A ActionListener listens the event when the user chooses Create new account menu item
	 */
	public void setCreateAccountActionListener(ActionListener listener);
	
	/**
	 * Set listener to Sign out menu
	 * @param listener A ActionListener listens the event when the user chooses Sign out menu item
	 */
	public void setSignOutActionListener(ActionListener listener);
	/**
	 * Set listener to choose file
	 * @param listener A ActionListener listens the event when the user chooses "Choose data file.." button 
	 */
	public void setButtonFileChooserActionListener(ActionListener listener);
	/**
	 * Set listener to choose file
	 * @param listener A ActionListener listens the event when the user chooses "Choose data file.." menu item 
	 */
	public void setFileChooserActionListener(ActionListener listener);
	/**
	 * Set listener to Open Button in File Chooser
	 *  @param rowData[] : String data with rows
	 *  @param colName[] : String name with columns
	 */
	public void createTable(String rowData[][], String colName[]);
	/**
	 * Close the sign in form
	 */
	public void closeForm();
	
}