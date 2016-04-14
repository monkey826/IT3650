package samsung.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import samsung.java.model.ISensor;
import samsung.java.model.ISensorList;
import samsung.java.model.SensorList;
import samsung.java.view.IMainUI;
import samsung.java.view.MainUI;

public class MainUIController {

    private IMainUI mainUI;
    public ISensorList ssList;

    /**
     * The constructor processing many ActionListener and to control the View,
     * edit/new data with Model
     */
    public MainUIController() {
        mainUI = new MainUI();
        JOptionPane.showMessageDialog(null, "The database will be saved in " + ISensorList.SENSOR_DIRECTORY);
        ssList = new SensorList();

        ISensor[] sensorList = (ISensor[]) ssList.getSensorList();
//        Thread update = new Thread() {
//            @Override
//            public void run() {
//                while (true) {
//                    JComboBox<String> list = mainUI.getBoxSensor();
//                    list.removeAllItems();
//                    if (ssList.getNumberOfSensors() != 0) {
//                        for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
//                            list.addItem(sensorList[i].getSensorID()); // Add new sensorID into combobox
//                        }
//                    }
//                    try {
//                        //update each 5 seconds
//                        sleep(5000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        update.start();
        /**
         * Show Table data
         */
        mainUI.showDataActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                /**
                 * New thread with table
                 */
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        while (1 != 0) {
                            String colName[] = {"Time", "Date", "Temperature", "Humidity"};
                            JComboBox<String> comboBox = mainUI.getBoxSensor();
                            Object selected = comboBox.getSelectedItem();
                            for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
                                if (selected.equals(sensorList[i].getSensorID())) {
                                    String[][] buffer = sensorList[i].readFile();
                                    int n = sensorList[i].getNumberResults();
                                    String[][] rowData = new String[n + 1][4];
                                    for (int j = 0; j <= n; j++) {
                                        for (int k = 0; k <= 3; k++) {
                                            rowData[j][k] = buffer[j][k];
                                        }
                                    }
                                    mainUI.showTable(colName, rowData);
                                    break;
                                }
                            }
                            try {
                                sleep(ssList.timeUpdating * 1000);
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

    public void addItemComboBox(String sensorID) {
        JComboBox<String> list = mainUI.getBoxSensor();
//        list.removeAllItems();
//        if (ssList.getNumberOfSensors() != 0) {
//            for (int i = 0; i < ssList.getNumberOfSensors(); i++) {
                list.addItem(sensorID); // Add new sensorID into combobox
//            }
//        }
    }

    /**
     * Close Form mainUI
     */
    public void closeForm() {
        mainUI.closeForm();
    }
}
