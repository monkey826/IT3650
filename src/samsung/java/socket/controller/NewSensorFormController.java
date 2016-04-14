package samsung.java.socket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import samsung.java.socket.model.ISensor;
import samsung.java.socket.model.ISensorList;
import samsung.java.socket.model.Sensor;
import samsung.java.socket.model.SensorList;
import samsung.java.socket.view.INewSensorForm;
import samsung.java.socket.view.NewSensorForm;

public class NewSensorFormController {
	private final INewSensorForm newSensorForm = new NewSensorForm();
	/**
	 * The constructor control View and Model. about new Sensor
	 */
	public NewSensorFormController(){
		/**
		 * Close new Sensor Form and don't do anything
		 */
		newSensorForm.setCancelButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newSensorForm.closeForm();
				new MainUIController();
			}
		});
		/**
		 * Accept to create new Sensor
		 */
		newSensorForm.setCreateButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sensorID = newSensorForm.getSensorID().trim().toUpperCase();
				double longitude = newSensorForm.getLongitude();
				double latitude = newSensorForm.getLatitude();
				if (isError(sensorID, longitude, latitude)) System.out.println("Error");
				else {
					// Add new sensor
					ISensorList sensorList = new SensorList();
					if (sensorList.checkID(sensorID)){
						JOptionPane.showMessageDialog(null," This sensor have existed. ");
					}
					else if (sensorList.checkPosition(latitude, longitude)){
						JOptionPane.showMessageDialog(null," This position have placed by a different sensor. ");
					}
					else {
						createFileSensor(sensorID);
						ISensor sensor = new Sensor(sensorID,longitude,latitude);
						if (sensorList.addSensor(sensor)){
							JOptionPane.showMessageDialog(null, "Successful !");
							JOptionPane.showMessageDialog(null," Sensor ID :  "+ sensorID);
							// Thread Start.
							sensor.start();
							newSensorForm.closeForm();
							new MainUIController();
						}
						else {
							JOptionPane.showMessageDialog(null,"Failed. Cannot add new account, because the list account is full");
						}
					}
				}
			}
		});
		
	}
	/**
	 * Check Error while new Sensor
	 * @param sensorID
	 * @param longitude
	 * @param latitude
	 * @return
	 */
	public boolean isError(String sensorID,double longitude,double latitude){
		int check = 1;
		// Check empty
		if (longitude == 0 || latitude == 0 || sensorID.equals("")) {
			JOptionPane.showMessageDialog(null, " Please fill out information! ");
			check = 0;
		}
		// Check wrong position
		else if (longitude == -1 || latitude == -1) {
			JOptionPane.showMessageDialog(null, " Please type again! The position isn't right ");
			check = 0;
		}
		// Check ID have 4 letters
		else if (sensorID.length() != 4){ 
			JOptionPane.showMessageDialog(null, " Error. The sensor ID have 4 letters ");
			check = 0;
		}
		// Check sensor is existed?
		else if (sensorID.indexOf(" ") != -1){ 
			JOptionPane.showMessageDialog(null,
					"Error. The sensor ID not have any space letter !");
			check = 0;
		}
		if (check == 0 ) return true;
		return false;
	}
	/**
	 * Create new Sensor method.
	 * @param sensorID
	 */
	public void createFileSensor(String sensorID){
		try {
			String path =  ISensorList.SENSOR_DIRECTORY + sensorID + ".txt" ;  
			File file = new File(path);
			if (file.createNewFile()) {
				System.out.println("File was created!");
			} else {
				 System.out.println("File already exists.");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
