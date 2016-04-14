package samsung.java.socket.view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 * 
 * @author Monkey
 * Client UI 
 */
@SuppressWarnings("serial")
public class ClientUI extends JFrame implements IClientUI{
	private JTextField tfServerAddress;
	private JTextField tfServerPort;
	private JButton btnConnect;
	private JButton btnQuit;
	/**
	 * The constructor setting a client.
	 */
	public ClientUI() {
		LookAndFeel old = UIManager.getLookAndFeel();
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Throwable ex){
			old = null; 
		}
		JLabel lbServerAddress = new JLabel(" Server Address: ");
		JLabel lbServerPort = new JLabel (" Server Port: ");
		tfServerAddress = new JTextField(15);
		tfServerPort = new JTextField(4);
		btnConnect = new JButton("Connect");
		btnQuit = new JButton("Quit");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		lbServerAddress.setBounds(10,10,100,30);
		lbServerPort.setBounds(10,50,100,30);
		tfServerAddress.setBounds(120,10,150,30);
		tfServerPort.setBounds(120,50,150,30);
		btnConnect.setBounds(50,90,80,30);
		btnQuit.setBounds(150,90,80,30);
		panel.add(lbServerAddress);
		panel.add(tfServerAddress);
		panel.add(lbServerPort);
		panel.add(tfServerPort);
		panel.add(btnConnect);
		panel.add(btnQuit);
		Container cp = this.getContentPane();
		cp.add(panel);
		setSize(300,170);
		setTitle(" Client Setting ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public String getServerAddress(){
		return tfServerAddress.getText();
	}
	public int getServerPort(){
		int serverPort = 5050;
		try{
			serverPort = Integer.parseInt(tfServerPort.getText());
		}
		catch ( NumberFormatException nfe){
			nfe.printStackTrace();
		}
		return serverPort;
	}
	/**
	 * 
	 */
	@Override
	public void setConnectActionListener(ActionListener listener){
		this.btnConnect.addActionListener(listener);
	}
	
	/**
	 * 
	 */
	@Override
	public void setQuitActionListener(ActionListener listener) {
		this.btnQuit.addActionListener(listener);
	}
	@Override
	public void close(){
		this.close();
	}
}
