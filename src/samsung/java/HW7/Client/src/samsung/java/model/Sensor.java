package samsung.java.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Sensor Class
 *
 * @author Monkey
 */
public final class Sensor extends Thread implements ISensor {

    private String sensorID;
    private double longitude;
    private double latitude;

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
     * @see samsung.java.model.ISensor#start()
     */
    @Override
    public void start() {
        super.start();
    }

    /**
     * inherited run from Thread.
     */
    @Override
    public void run() {
        recordData();
    }

    /**
     * (non-Javadoc)
     * @see samsung.java.model.ISensor#sleepThread() 
     */
    @Override
    public void sleepThread() {
        try {
            Random rd = new Random();
            int timeSleep = 1000 + (int) ((30000 - 1000) * rd.nextDouble());
            sleep(timeSleep);
        } catch (InterruptedException ie) {
            // TODO Auto-generated catch block
            ie.printStackTrace();
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see samsung.java.model.ISensor#recordData() 
     */
    @Override
    public String recordData() {
        /**
         * Random result and write it to file
         */
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss|yyyy-MM-dd");
        Date date = new Date();
        String time = timeFormat.format(date); /// Time|Date
        Random rd = new Random();
        double tempMin = 5;
        double tempMax = 45;
        Double temperatureValue = tempMin + (tempMax - tempMin) * rd.nextDouble();  // temperature 
        double humidityMin = 50;
        double humidityMax = 100;
        Double humidityValue = humidityMin + (humidityMax - humidityMin) * rd.nextDouble(); // Humidity
        String temperature = temperatureValue.toString().substring(0, 5);
        String humidity = humidityValue.toString().substring(0, 5);
        String data = time + "|" + temperature + "|" + humidity;
        return data;
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
     *
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
