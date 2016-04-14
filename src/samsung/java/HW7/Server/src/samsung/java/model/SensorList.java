package samsung.java.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * List sensor client sent.
 * @author Dao Nam Tien
 *
 */
public class SensorList implements ISensorList {

    private final int MAX_LIST = 50;
    private final ISensor[] sensorList;
    private int numberOfSensors = 0;

    /**
     * The constructor create FileList sensor or read from file
     */
    public SensorList() {
        this.sensorList = new Sensor[MAX_LIST];
        File file = new File(ISensorList.SENSOR_DIRECTORY);
        file.mkdir();
    }

    /**
     *
     * @param sensorID
     * @return
     */
    public int getIndexSensor(String sensorID) {
        if (numberOfSensors >= 0) {
            for (int i = 0; i < numberOfSensors; i++) {
                if (sensorList[i].getSensorID().equals(sensorID)) {
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * Check sensor existed? 
     * @param sensorID
     * @return 
     */
    public boolean isExistSensor(String sensorID) {
        return getIndexSensor(sensorID) == -1;
    }

    /**
     *  (non-Javadoc)
	@see samsung.java.model.ISensorList#writeFile()
     */
    @Override
    public void writeFile(String sensorID, String data) {
        int i = getIndexSensor(sensorID);
        if (i != -1) {
            sensorList[i].writeFile(data);
        } else {
            System.err.println("Error");
        }

    }
//	

    /*
	 * (non-Javadoc)
	 * @see samsung.java.model.ISensorList#getNumberOfSensors()
     */
    @Override
    public int getNumberOfSensors() {
        return numberOfSensors;
    }

    /**
     * Create new Sensor method.
     *
     * @param sensorID
     */
    public void createFileSensor(String sensorID) {
        try {
            String path = ISensorList.SENSOR_DIRECTORY + sensorID + ".txt";
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File sensor was created!");
            } else {
                System.out.println("File sensor already exists.");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensorList#addSensor(ISensor)
     * @param sensor
     * 
     */
    @Override
    public void addSensor(ISensor sensor) {
        if (numberOfSensors < MAX_LIST) {
            sensorList[numberOfSensors] = sensor;
            numberOfSensors++;
            if (!isExistSensor(sensor.getSensorID()) && !checkPosition(sensor.getLatitude(), sensor.getLongitude())){
                createFileSensor(sensor.getSensorID());
            }
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensorList#getSensorList()
     */
    @Override
    public ISensor[] getSensorList() {
        return sensorList;
    }

    

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensorList#checkPosition(double, double)
     */
    @Override
    public boolean checkPosition(double latitude, double longitude) {
        if (numberOfSensors == 0) {
            return false;
        }
        for (int i = 0; i < numberOfSensors; i++) {
            if (sensorList[i].getLatitude() == latitude
                    && sensorList[i].getLongitude() == longitude) {
                return true;
            }
        }
        return false;
    }
}
