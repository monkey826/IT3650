package samsung.java.weather.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * 
 * @author Dao Nam Tien
 *
 */
public class SensorList implements ISensorList{
	private final int MAX_LIST = 50;
	private ISensor[] sensorList;
	private int numberOfSensors = -1;
	private int timeUpdating = 10;
	/**
	 * The constructor create FileList sensor or read from file
	 */
	public SensorList(){
		this.sensorList = new Sensor[MAX_LIST];
		File file = new File(ISensorList.SENSOR_DIRECTORY);
		file.mkdir();
		try {
			file = new File(ISensorList.SENSOR_FILE);
			if (file.createNewFile()){
				System.out.println(" File is created. ");
			}
			else{
				Path filePath = Paths.get(ISensorList.SENSOR_FILE);
				numberOfSensors = 0;
				try (BufferedReader rd = Files.newBufferedReader(filePath)){
					String line, sensorID;
					double longitude = 0d , latitude = 0d ;
					StringTokenizer tk ;
					while ((line = rd.readLine()) != null){
						tk = new StringTokenizer(line);
						sensorID = tk.nextToken();
						try{
							longitude = Double.parseDouble(tk.nextToken());
						}catch (NumberFormatException nfe ){
							System.out.println(nfe.getMessage());
						}
						try{
							latitude = Double.parseDouble(tk.nextToken());
						}catch (NumberFormatException nfe ){
							System.out.println(nfe.getMessage());
						}
						Sensor sensor = new Sensor(sensorID, longitude, latitude);
						sensorList[numberOfSensors] = sensor;
						numberOfSensors++;
						/// New Thread.
						sensor.start();
						
					}
				}
				catch(IOException e){
					System.out.println(e.getMessage());
				}
			}	
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
//	public String[][] readFile(String sensorID){
//		String[][] rowData = new String[1000][4];
//		try(FileReader fr = new FileReader(ISensorList.SENSOR_DIRECTORY+sensorID+".txt")){
//			BufferedReader br = new BufferedReader(fr);
//			String line ;
//			StringTokenizer tk;
//			try{
//				while ((line = br.readLine()) != null ){
//					tk = new StringTokenizer(line,"|");
//					for (int  j = 0 ; j <= 3; j++){
//						rowData[][j] = tk.nextToken();
//					}
//					
//				}
//			}
//			catch (RuntimeException re){
//				System.out.println(re.getMessage());
//			}
//			br.close();
//		}
//		catch(IOException ioe){
//			System.out.println(ioe.getMessage());
//		}
//		return rowData;
//	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#setTimeUpdating(int)
	 */
	@Override
	public void setTimeUpdating(int time){
		this.timeUpdating = time;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#getTimeUpdating()
	 */
	@Override
	public int getTimeUpdating(){
		return this.timeUpdating;
	}
	/*
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#getNumberOfSensors()
	 */
	@Override
	public int getNumberOfSensors(){
		return numberOfSensors;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#addSensor(ISensor)
	 * @param sensor
	 * @return
	 */
	@Override
	public boolean addSensor(ISensor sensor){
		if (numberOfSensors < MAX_LIST){
			sensorList[numberOfSensors] = sensor;
			numberOfSensors++;
			try (FileWriter fw = new FileWriter(ISensorList.SENSOR_FILE,true)){
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(sensor.getSensorID() + " " + sensor.getLongitude()+ " "
						+ sensor.getLatitude());
				bw.newLine();
				bw.close();
			}
			catch(IOException ioe){
				System.out.println(ioe.getMessage());
			}
			return true;
		}
		return false;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#getSensorList()
	 */
	@Override
	public ISensor[] getSensorList(){
		return sensorList;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#checkID(String)
	 * @param sensorID
	 * @return
	 */
	@Override
	public boolean checkID(String sensorID){
		if (numberOfSensors == 0) return false;
		for (int i = 0 ; i < numberOfSensors ; i++ )
		{
			if (sensorID.equalsIgnoreCase(sensorList[i].getSensorID()))
					return true;
		}
		return false;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.model.ISensorList#checkPosition(double, double)
	 */
	@Override
	public boolean checkPosition(double latitude, double longitude){
		if (numberOfSensors == 0) return false;
		for (int i = 0 ; i < numberOfSensors ; i++ )
		{
			if (sensorList[i].getLatitude() == latitude 
					&& sensorList[i].getLongitude() == longitude)
					return true;
		} 
		return false;
	}
}
