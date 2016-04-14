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

@SuppressWarnings("serial")
public class ServerUI extends JFrame implements IServerUI{
	private JTextField tfServerPort;
	private JButton btnStart;
	private JButton btnStop;
	/**
	 * The constructor setting a client.
	 */
	public ServerUI() {
		LookAndFeel old = UIManager.getLookAndFeel();
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Throwable ex){
			old = null; 
		}
		JLabel lbServerPort = new JLabel (" Server Port: ");
		tfServerPort = new JTextField(4);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		lbServerPort.setBounds(10,10,100,30);
		tfServerPort.setBounds(120,10,150,30);
		btnStart.setBounds(50,50,80,30);
		btnStop.setBounds(150,50,80,30);
		panel.add(lbServerPort);
		panel.add(tfServerPort);
		panel.add(btnStart);
		panel.add(btnStop);
		Container cp = this.getContentPane();
		cp.add(panel);
		setSize(300,130);
		setTitle(" Server Setting ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
//	public static void main(String[] args){
//		new ServerUI();
//	}
	@Override
	public int getServerPort(){
		int serverPort = 5050;
		try {
			serverPort = Integer.parseInt(tfServerPort.getText());
		}
		catch ( NumberFormatException nfe){
			
		}
		return serverPort;
	}
	@Override
	public void setStartActionListener(ActionListener listener){
		this.btnStart.addActionListener(listener);
	}
	@Override
	public void setStopActionListener(ActionListener listener) {
		this.btnStop.addActionListener(listener);
	}
	@Override
	public void close() {
		this.close();
	}
	
}
