package samsung.java.weather.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;


public class Sensor extends Thread implements ISensor{
	private String sensorID;
	private double longitude;
	private double latitude;
	private int numberResults = 0;
	/**
	 * The constructor Set data for the attribute 
	 * @param sensorID
	 * @param longitude
	 * @param latitude
	 */
	public Sensor(String sensorID, double longitude, double latitude){
		setSensorID(sensorID);
		setLongitude(longitude);
		setLatitude(latitude);
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#start()
	 */
	public void start(){
		super.start();
	}
	/**
	 * inherited run from Thread.
	 */
	@Override
	public void run(){
		while(1 != 0){
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/**
			 * Random result and write it to file
			 */
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss|yyyy-MM-dd");
			Date date = new Date();
			String time = timeFormat.format(date); /// Time|Date
			Random rd = new Random();
			double tempMin = 5;
			double tempMax = 45;
			Double temperatureValue = tempMin + (tempMax - tempMin)*rd.nextDouble();  // temperature 
			double humidityMin = 50;
			double humidityMax = 100;
			Double humidityValue = humidityMin + (humidityMax - humidityMin)*rd.nextDouble(); // Humidity
			String temperature = temperatureValue.toString().substring(0, 5);
			String humidity = humidityValue.toString().substring(0, 5);
			String data = time + "|"+ temperature + "|" +humidity;
			writeFile(data);
		}
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#getNumberResults()
	 */
	public int getNumberResults(){
		int n = this.numberResults;
		this.numberResults = 0;
		return n;
		
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#readFile(String)
	 */
	@Override
	public String[][] readFile(String sensorID){
		String[][] rowData = new String[1000][4];
		try(FileReader fr = new FileReader(ISensorList.SENSOR_DIRECTORY+sensorID+".txt")){
			BufferedReader br = new BufferedReader(fr);
			String line ;
			StringTokenizer tk;
			try{
				while ((line = br.readLine()) != null ){
					tk = new StringTokenizer(line,"|");
					for (int  j = 0 ; j <= 3; j++){
						rowData[this.numberResults][j] = tk.nextToken();
					}
					this.numberResults++;
				}
			}
			catch (RuntimeException re){
				System.out.println(re.getMessage());
			}
			br.close();
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return rowData;
	}
	/**
	 * Write data random from Thread sensor into file
	 * 
	 */
	public void writeFile(String data){
		try(FileWriter fw = new FileWriter(ISensorList.SENSOR_DIRECTORY+ getSensorID() +".txt",true)){
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.newLine();
			bw.close();
		} catch( IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#getSensorID()
	 */
	@Override
	public String getSensorID() {
		return sensorID;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#setSensorID()
	 */
	@Override
	public void setSensorID(String sensorID) {
		if (sensorID.length() == 4 )
			this.sensorID = sensorID;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#getLongitude()
	 */
	@Override
	public double getLongitude() {
		return longitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#setLongitude(double)
	 */
	@Override
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#getLatitude()
	 */
	@Override
	public double getLatitude() {
		return latitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensor#setLatitude(double)
	 */
	@Override
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
