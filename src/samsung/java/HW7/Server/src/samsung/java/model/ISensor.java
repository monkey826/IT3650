package samsung.java.model;

public interface ISensor {
	/** Get Sensor ID
	 * 
	 * @return Sensor ID
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
	 * Read file data and 
	 * 
        * @return String[] for row of table values
	 */
	public String[][] readFile();
        /**
         * Write data to file
         * @param data 
         */
        public void writeFile(String data);
        /**
         * 
         * @return number of results record
         */
	public int getNumberResults();
       
}
