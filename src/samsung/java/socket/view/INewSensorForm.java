package samsung.java.socket.view;

import java.awt.event.ActionListener;

public interface INewSensorForm {
	
	/**
	 * ActionListener: Set Cancel 
	 * @param listener
	 */
	public void setCancelButtonActionListener(ActionListener listener);
	/**
	 * ActionListener : Set Create sensor
	 * @param listener
	 */
	public void setCreateButtonActionListener(ActionListener listener);
	/**
	 * Get Sensor's Latitude value
	 * @return
	 */
	public double getLatitude();
	/**
	 * Get Sensor's Longitude value
	 * @return
	 */
	public double getLongitude();
	/**
	 * Get Sensor ID
	 * @return
	 */
	public String getSensorID();
	/**
	 * Close new Sensor Form
	 */
	public void closeForm();
}
