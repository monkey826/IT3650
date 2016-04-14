package samsung.java.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * Class Sensor
 * @author Monkey
 */
public final class Sensor implements ISensor {

    private String sensorID;
    private double longitude;
    private double latitude;
    private int numberResults = 0;

    /**
     * The constructor Set data for the attribute
     *
     * @param sensorID
     * @param longitude
     * @param latitude
     */
    public Sensor(String sensorID, double longitude, double latitude) {
        setSensorID(sensorID);
        setLongitude(longitude);
        setLatitude(latitude);
    }

   
    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#getNumberResults()
     */
    @Override
    public int getNumberResults() {
        int n = this.numberResults;
        this.numberResults = 0;
        return n;

    }

    /**
     * (non-Javadoc)
     * @see samsung.java.model.ISensor#readFile() 
     */
    @Override
    public String[][] readFile() {
        String[][] rowData = new String[1000][4];
        try (FileReader fr = new FileReader(ISensorList.SENSOR_DIRECTORY + this.sensorID + ".txt")) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            StringTokenizer tk;
            try {
                while ((line = br.readLine()) != null) {
                    tk = new StringTokenizer(line, "|");
                    for (int j = 0; j <= 3; j++) {
                        rowData[this.numberResults][j] = tk.nextToken();
                    }
                    this.numberResults++;
                }
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return rowData;
    }

    /**
     * Write data random from Thread sensor into file
     *
     */
    @Override
    public void writeFile(String data) {
        try (FileWriter fw = new FileWriter(ISensorList.SENSOR_DIRECTORY + getSensorID() + ".txt", true)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#getSensorID()
     */
    @Override
    public String getSensorID() {
        return sensorID;
    }

    /**
     * (non-Javadoc)
     * @see samsung.java.model.ISensor#setSensorID()
     */
    @Override
    public void setSensorID(String sensorID) {
        if (sensorID.length() == 4) {
            this.sensorID = sensorID;
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#getLongitude()
     */
    @Override
    public double getLongitude() {
        return longitude;
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#setLongitude(double)
     */
    @Override
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#getLatitude()
     */
    @Override
    public double getLatitude() {
        return latitude;
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#setLatitude(double)
     */
    @Override
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
