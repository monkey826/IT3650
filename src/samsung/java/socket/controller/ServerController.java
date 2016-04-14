package samsung.java.socket.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import samsung.java.socket.view.IServerUI;
import samsung.java.socket.view.ServerUI;

public class ServerController{
	private static IServerUI serverUI;
	public static void main(String[] args){
		serverUI = new ServerUI();
		serverUI.setStartActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try(ServerSocket servSocket = new ServerSocket(serverUI.getServerPort())){
					while(true){
						Socket connSocket = servSocket.accept();
						System.out.println("Accepted client: "
								+ connSocket.getInetAddress().getHostAddress());
						try(BufferedReader in = new BufferedReader(new
								InputStreamReader(connSocket.getInputStream()));
								PrintWriter out = new PrintWriter(new 
										OutputStreamWriter(connSocket.getOutputStream()))
							){
								String message;
								while ((message = in.readLine()) != null ){
									System.out.println("Receive from client: " + message);
									out.println(message);
									out.flush();
								}
								System.out.println("Client has stopped sending data!");
							} catch (IOException ioe){
								ioe.printStackTrace();
							}
					}
				}
				catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
		});
		serverUI.setStopActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
