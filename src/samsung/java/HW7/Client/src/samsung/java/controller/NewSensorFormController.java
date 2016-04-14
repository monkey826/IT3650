package samsung.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;
import samsung.java.model.ISensor;
import samsung.java.model.Sensor;
import samsung.java.view.INewSensorForm;
import samsung.java.view.NewSensorForm;

public class NewSensorFormController {

    private final INewSensorForm newSensorForm = new NewSensorForm();
    public String data;
    private final int START = 1;
    private final int STOP = 0;
    private String flagStop = "Stopped! ";
    public int status = -1;
    private Socket clientSocket = ClientController.clientSocket;

    /**
     * The constructor control View and Model. about new Sensor
     */
    public NewSensorFormController() {
        /**
         * Close new Sensor Form and don't do anything
         */
        newSensorForm.setQuitButtonActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                newSensorForm.closeForm();
                
            }
        });
        /**
         * Accept to create new Sensor , and start recording.
         */
        newSensorForm.setStartButtonActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // Create a sensor

                Thread startClient;
                startClient = new Thread() {
                    @Override
                    public void run() {
                        String sensorID = newSensorForm.getSensorID().trim().toUpperCase();
                        String sensorAddress = newSensorForm.getSensorAddress().trim().toUpperCase();
                        double longitude = newSensorForm.getLongitude();
                        double latitude = newSensorForm.getLatitude();
                        if (isError(sensorID, longitude, latitude)) {
                            System.out.println("Error");
                        } else {

                            ISensor sensor = new Sensor(sensorID, longitude, latitude);
                            JOptionPane.showMessageDialog(null, "Successful ! \nSensor ID : " + sensorID);
                            // Thread Start.
                            sensor.start();
                            status = START;
                            // Enable Stop Button and Disable Start Button
                            newSensorForm.getStartButton().setEnabled(false);
                            newSensorForm.getStopButton().setEnabled(true);
                            // Notification
                            JOptionPane.showMessageDialog(null, "Start");
                            System.out.println("Send to server ");
                            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                    PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));) 
                            {
                                out.println(sensorID);
                                out.flush();
                                out.println(longitude);
                                out.flush();
                                out.println(latitude);
                                out.flush();
                                while (status == START) {
                                    out.println(sensor.recordData());
                                    out.flush();
                                    String reply = in.readLine();
                                    System.out.println("Reply from server:" + reply);
                                    if (reply.equals(flagStop)){
                                        status = STOP;
                                        clientSocket.close();
                                        newSensorForm.closeForm();
                                        break;
                                    }
                                    sensor.sleepThread();
                                    if (status == STOP) {
                                        System.out.println("The client was stopped");
                                        break;
                                    }
                                }
                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            }
                        }
                    }
                };
                startClient.start();

            }
        });
        newSensorForm.setStopButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = STOP;
                JOptionPane.showMessageDialog(null, "Stop");
                newSensorForm.getStartButton().setEnabled(true);
                newSensorForm.getStopButton().setEnabled(false);
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));) {
                    {
                        out.println(flagStop);
                        out.flush();
                        String reply;
                        reply = in.readLine();
                        System.out.println("Reply from server:" + reply);
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });
    }

    /**
     * Check Error while new Sensor
     *
     * @param sensorID
     * @param longitude
     * @param latitude
     * @return
     */
    public boolean isError(String sensorID, double longitude, double latitude) {
        int check = 1;
        // Check empty
        if (longitude == 0 || latitude == 0 || sensorID.equals("")) {
            JOptionPane.showMessageDialog(null, " Please fill out information! ");
            check = 0;
        } // Check wrong position
        else if (longitude == -1 || latitude == -1) {
            JOptionPane.showMessageDialog(null, " Please type again! The position isn't right ");
            check = 0;
        } // Check ID have 4 letters
        else if (sensorID.length() != 4) {
            JOptionPane.showMessageDialog(null, " Error. The sensor ID have 4 letters ");
            check = 0;
        } // Check sensor is existed?
        else if (sensorID.contains(" ")) {
            JOptionPane.showMessageDialog(null,
                    "Error. The sensor ID not have any space letter !");
            check = 0;
        }
        return check == 0;
    }

}
