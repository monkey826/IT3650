package samsung.java.weather.view;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
public interface IMainUI {
	/**
	 * ActionListener : Set Exit Program
	 * @param listener
	 */
	public void setExitActionListener(ActionListener listener);
	/**
	 * ActionListener : Change time-updating file
	 * @param listener
	 */
	public void setChangeTimeActionListener(ActionListener listener);
	/**
	 * ActionListener: New a weather sensor
	 * @param listener
	 */
	public void setNewSensorActionListener(ActionListener listener);
	/**
	 * ActionListener: Open View Desktop.
	 * @param listener
	 */
	public void setViewWeatherActionListener(ActionListener listener);
	/**
	 * Set Enable Visible View Desktop
	 * @param boxSensor
	 */
	public void viewWeather(JComboBox<String> boxSensor);
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
	 * ActionListener: Take data from file and put it to table
	 * @param listener
	 */
	public void setFileActionListener(ActionListener listener);
	/**
	 * ActionListener: Show information about me.
	 * @param listener
	 */
	public void setAboutMeActionListener(ActionListener listener);
	/**
	 * Close Main Form
	 */
	public void closeForm();
	
}
