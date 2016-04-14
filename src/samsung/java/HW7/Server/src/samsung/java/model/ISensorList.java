package samsung.java.model;

public interface ISensorList {
	/**
	 * The Directory have all file about sensor here
	 */
	public final String SENSOR_DIRECTORY = System.getProperty("user.dir").concat("\\database\\");
	/**
	 * The File have list sensor
	 */
	public final String SENSOR_FILE = System.getProperty("user.dir").concat("/database/SensorList.txt");
        /**
         * Time update table
         */
        public final int timeUpdating = 60;
        /**
         * Write data random from Thread sensor into file
         * @param sensorID
         * @param data 
         */
        public void writeFile(String sensorID, String data);
        
	/**
	 * Add a new sensor and new thread for this sensor
	 * @param sensor
	 * 
	 */
	public void addSensor(ISensor sensor);

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
}
