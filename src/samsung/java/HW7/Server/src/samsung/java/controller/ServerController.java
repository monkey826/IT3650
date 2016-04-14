package samsung.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import samsung.java.model.ISensor;
import samsung.java.model.Sensor;
import samsung.java.view.IServerUI;
import samsung.java.view.ServerUI;

/**
 * Server
 *
 * @author Monkey
 */
public class ServerController {

    private static final String flagStop = "Stopped! ";
    private static IServerUI serverUI;
    private static final int READY = -1;
    private static final int START = 1;
    private static final int STOP = 0;
    private static int status = READY;
    private static MainUIController mainUI;
    private static ServerSocket servSocket = null;

    public static void main(String[] args) {

        serverUI = new ServerUI(); // Let the constructor do the job
        serverUI.setStartActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Disable Start button and enable stop button
                serverUI.getStartButton().setEnabled(false);
                serverUI.getStopButton().setEnabled(true);

                int serverPort = serverUI.getServerPort(); // Get Port
                if (isError(serverPort)) {
                    System.err.println("Error!");
                } else {
                    Thread serverStart = new Thread() { // Thread server
                        @Override
                        public void run() {
                            try {
                                servSocket = new ServerSocket(serverPort);
                                mainUI = new MainUIController();
                                while (true) {
                                    status = START;
                                    Socket connSocket;
                                    if ((connSocket = servSocket.accept()) != null) {
                                        Thread multilSocket = new Thread() { // Thread will receive data and write to file
                                            public void run() {
                                                System.out.println("Accepted client: "
                                                        + connSocket.getInetAddress().getHostAddress());
                                                try (BufferedReader in = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
                                                        PrintWriter out = new PrintWriter(new OutputStreamWriter(connSocket.getOutputStream()))) {
                                                    // Get Sensor ID
                                                    String sensorID = in.readLine(); // Sensor ID
                                                    double longtitude = 0; // Longtitude 
                                                    double latitude = 0; // LAatitude
                                                    try { // Convert String to Double
                                                        longtitude = Double.parseDouble(in.readLine());
                                                        latitude = Double.parseDouble(in.readLine());
                                                    } catch (NumberFormatException nfe) {
                                                        System.out.println(nfe.getMessage());
                                                    }
                                                    /// New sensor
                                                    ISensor sensor = new Sensor(sensorID, longtitude, latitude);
                                                    mainUI.ssList.addSensor(sensor);
                                                    mainUI.addItemComboBox(sensorID);
                                                    String message;
                                                    // Add sensor.
                                                    while (status == START) {
                                                        message = in.readLine();
                                                        System.out.println("Receive from client: " + sensorID + " " + message);
                                                        out.println(message);
                                                        out.flush();
                                                        if (message.equals(flagStop)) {
                                                            // If client notify stop, break listening.
                                                            break;
                                                        }
                                                        mainUI.ssList.writeFile(sensorID, message);
                                                        if (status == STOP) {
                                                            // If click button Stop on Server , close MainUI and break;
                                                            out.println(flagStop);
                                                            out.flush();
                                                            break;
                                                        }
                                                    }
                                                    out.print(flagStop);
                                                    out.flush();
                                                    System.out.println("Client " + sensorID + " has stopped sending data!");
                                                } catch (IOException ioe) {
                                                    ioe.printStackTrace();
                                                }
                                            }
                                        };
                                        multilSocket.start();
                                    }
                                }
                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            }
                        }
                    };
                    serverStart.start();
                }

            }
        });
        serverUI.setStopActionListener(new ActionListener() {
            // Set Stop Server
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                serverUI.getStartButton().setEnabled(true);
                serverUI.getStopButton().setEnabled(false);
                status = STOP;
                mainUI.closeForm();

            }
        });
    }

    public static boolean isError(int port) {
        if (port == 0) {
            JOptionPane.showMessageDialog(null, " Please fill server address");
            return true;
        } else if (port == -1) {
            JOptionPane.showMessageDialog(null, " Please fill server port again ");
            return true;
        }
        return false;
    }
}
