package samsung.java.view;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
public interface IMainUI {
	
	/**
	 * ActionListener: Take data from file and put it to table
	 * @param listener
	 */
	public void showDataActionListener(ActionListener listener);
	
	/**
	 * Get ComboBox
	 * @return
	 */
	public JComboBox<String> getBoxSensor();
	/**
	 * Show Table Data about the record.
	 * @param colName : Title
	 * @param rowData : Data
	 */
	public void showTable(String colName[], String rowData[][]);
	
	/**
	 * Close Main Form
	 */
	public void closeForm();
	
}
