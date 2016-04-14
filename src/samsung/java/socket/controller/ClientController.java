package samsung.java.socket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import samsung.java.socket.view.ClientUI;
import samsung.java.socket.view.IClientUI;

public class ClientController {
	private static IClientUI clientUI;
	public static void main(String[] args){
		clientUI = new ClientUI();
		clientUI.setConnectActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try(Socket clientSocket = new Socket(clientUI.getServerAddress(),clientUI.getServerPort());
						BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
						BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
					){
					String message;
					while(true){
						System.out.println("Send to server ");
						message = user.readLine();
						if (message.length() == 0)
							break;
						out.println(message);
						out.flush();
						String reply;
						reply = in.readLine();
						System.out.println("Reply from Server : " + reply);
					}
					clientSocket.close();
				}
				catch (IOException ioe){
					ioe.printStackTrace();
				}
				
			}
		});
		clientUI.setQuitActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clientUI.close();
			}
		});
	}
}
