package samsung.java.weather.model;

public interface ISensorList {
	/**
	 * The Directory have all file about sensor here
	 */
	public final String SENSOR_DIRECTORY = "src/samsung/java/database/";
	/**
	 * The File have list sensor
	 */
	public final String SENSOR_FILE = "src/samsung/java/database/SensorList.txt";
	/**
	 * Set time-updating Table 
	 * @param time
	 */
	public void setTimeUpdating(int time);
	/**
	 * Get time-updating Table
	 * @return
	 */
	public int getTimeUpdating();
	/**
	 * Add a new sensor and new thread for this sensor
	 * @param sensor
	 * @return
	 */
	public boolean addSensor(ISensor sensor);
	/**
	 * Check Sensor ID have existed?
	 * @param sensorID
	 * @return
	 */
	public boolean checkID(String sensorID);
	/**
	 * Check position have placed by any sensors?
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public boolean checkPosition(double latitude, double longitude);
	/**
	 * Get number of sensors
	 * @return
	 */
	public int getNumberOfSensors();
	/**
	 * Get Sensor List
	 * @return
	 */
	public ISensor[] getSensorList();
//	public String[][] readFile(String sensorID);
}
