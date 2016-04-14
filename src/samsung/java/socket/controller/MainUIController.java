package samsung.java.socket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import samsung.java.socket.model.ISensor;
import samsung.java.socket.model.ISensorList;
import samsung.java.socket.model.SensorList;
import samsung.java.socket.view.IMainUI;
import samsung.java.socket.view.MainUI;

public class MainUIController {
	private IMainUI mainUI;
	private ISensorList ssList;
	/**
	 *  The constructor processing many ActionListener and to control the View, edit/new data with Model 
	 */
	public MainUIController() {
		mainUI = new MainUI();
		ssList = new SensorList();
		ISensor[] sensorList = ssList.getSensorList();
		/**
		 * About me action
		 */
		mainUI.setAboutMeActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Author: Dao Nam Tien - K58 - HUST", "About me", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/**
		 * Set View weather desktop
		 */
		mainUI.setViewWeatherActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
				JComboBox<String> list = new JComboBox<>();
				for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
					model.addElement(sensorList[i].getSensorID());
				}
				list.setModel(model);
				mainUI.viewWeather(list);
			}
		});
		/**
		 * Set Exit program
		 */
		mainUI.setExitActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainUI.closeForm();
			}
		});
		/**
		 * Open new sensor form and take data sent to the Model
		 */
		mainUI.setNewSensorActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NewSensorFormController();
				mainUI.closeForm();
			}
		});
		/**
		 * Change Time-updating table
		 */
		mainUI.setChangeTimeActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String timeUpdate = JOptionPane
						.showInputDialog("Enter new time-updating : ");
				int timeUpdating = 10;
				try
				{
					timeUpdating = Integer.parseInt(timeUpdate);
					JOptionPane.showMessageDialog(null, "OK. Done");
				}
				catch (NumberFormatException nfe){
					System.out.println(nfe.getMessage());
				}
				ssList.setTimeUpdating(timeUpdating);
			}
		});
		/**
		 * Show Table data
		 */
		mainUI.setFileActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/** 
				 * New thread with table
				 */
							Thread thread = new Thread(){
								@Override
								public void run(){
								while(1 != 0){
									String colName[] = { "Time", "Date", "Temperature", "Humidity" };
									JComboBox<String> comboBox = mainUI.getBoxSensor();
									Object selected = comboBox.getSelectedItem();
									for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
										if (selected.equals(sensorList[i].getSensorID())) {
											String[][] buffer = sensorList[i].readFile(sensorList[i].getSensorID());
											int n = sensorList[i].getNumberResults();
											String[][] rowData = new String[n+1][4];
											for (int j = 0 ; j <= n ; j++){
												for (int k = 0 ; k <= 3 ; k ++)
													rowData[j][k] = buffer[j][k];
											}
											mainUI.showTable(colName, rowData);
											break;
										}
									}
										try {
											sleep(ssList.getTimeUpdating()*1000);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							};
							thread.start();
				}
		}); 
	}
}
