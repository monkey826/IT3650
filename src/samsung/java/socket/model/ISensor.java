package samsung.java.socket.model;

public interface ISensor {
	/**
	 * Get Sensor ID
	 * @return
	 */
	public String getSensorID();
	/**
	 * Set Sensor ID
	 * @param sensorID
	 */
	public void setSensorID(String sensorID);
	/**
	 * Get Sensor's Longitude
	 * @return
	 */
	public double getLongitude();
	/**
	 * 	Set Sensor's Longitude
	 * @param longitude
	 */
	public void setLongitude(double longitude);
	/**
	 * Get Sensor's Latitude
	 * @return
	 */
	public double getLatitude();
	/**
	 * Set sensor's Latitude
	 * @param latitude
	 */
	public void setLatitude(double latitude);
	/**
	 * Start sensor Thread.
	 */
	public void start();
	/**
	 * 
	 * @param sensorID
	 * @return
	 */
	public String[][] readFile(String sensorID);
	public int getNumberResults();
}
