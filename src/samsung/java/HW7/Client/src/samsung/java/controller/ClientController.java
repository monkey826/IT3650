package samsung.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import samsung.java.view.ClientUI;
import samsung.java.view.IClientUI;

/**
 *  Client Controller 
 * @author Monkey
 */
public class ClientController {

    private static IClientUI clientUI; // UI client 
    public static Socket clientSocket = null; // Socket 
    private static String serverAddress = null;
    private static int serverPort = 0;

    public static void main(String[] args) {
        clientUI = new ClientUI(); 
        clientUI.setConnectActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
//                // TODO Auto-generated method stub
                // Get serverAddress and port and create Connect. ( call Connect method )
                serverAddress = clientUI.getServerAddress();
                serverPort = clientUI.getServerPort();
                System.out.println(serverPort);
                if (isError(serverAddress, serverPort)) {
                    System.err.println("Error!");
                } else {
                    connect();
                    clientUI.close();
                }
            }
        });
        
        // Quit Action 
        
        clientUI.setQuitActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                clientUI.close();
                new ClientController(); 
            }
        });
    }
    /**
     * Connect socket
     */
    public static void connect() {
        try {
            // Loi nhap sai gia tri --> Die chuong trinh
            clientSocket = new Socket(serverAddress, serverPort);
            new NewSensorFormController();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    /**
     *  Close socket
     */
    public static void close() {
        try {
            // Loi nhap sai gia tri --> Die chuong trinh
            clientSocket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    /**
     * Check fill information in form
     * @param address
     * @param port
     * @return error or not?
     */
    public static boolean isError(String address, int port) {
        if (address.equals("") && port == 0) {
            JOptionPane.showMessageDialog(null, " Please fill server address");
            return true;
        } else if (port == -1) {
            JOptionPane.showMessageDialog(null, " Please fill server port again ");
            return true;
        }
        return false;
    }
}
