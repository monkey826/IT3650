package samsung.java.socket.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
/**
 * 
 * @author Dao Nam Tien
 * The New Sensor Form class inheriting the JFrame displays the new sensor form
 */
@SuppressWarnings("serial")
public class NewSensorForm extends JFrame implements INewSensorForm{
	private JTextField tfSensorID;
	private JTextField tfSensorAddress;
	private JTextField tfLongitude;
	private JTextField tfLatitude;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnQuit;
	/**
	 * The constructor show new sensor Form and get Data sent to The Controller
	 * 
	 */
	public NewSensorForm(){
		LookAndFeel old = UIManager.getLookAndFeel();
	    try {
	       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Throwable ex) {
	       old = null;
	    } 
	    JLabel lbSensorID = new JLabel(" Sensor ID ");
	    JLabel lbSensorAddress= new JLabel (" Sensor Address ");
	    JLabel lbLatitude = new JLabel(" Latitude ");
	    JLabel lbLongitude = new JLabel(" Longitude ");
	    this.tfSensorID = new JTextField(4);
	    this.tfSensorAddress = new JTextField(15);
	    this.tfLatitude = new JTextField(16);
	    this.tfLongitude = new JTextField(16);
	    this.btnStart = new JButton(" Start ");
	    this.btnStop = new JButton(" Stop ");
		this.btnQuit = new JButton("Cancel");
//		JPanel  = new JPanel(new GridLayout(4,2,10,5));
		lbSensorID.setBounds(5,10,20,10);
		JPanel panel = new JPanel();
		panel.setLayout(null);

		tfSensorID.setBounds(150,10,150,30);
		tfSensorAddress.setBounds(150,50,150,30);
		tfLatitude.setBounds(150,90,150,30);
		tfLongitude.setBounds(150,130,150,30);
		lbSensorID.setBounds(20, 10, 100, 30);
		lbSensorAddress.setBounds(20,50,100,30);
		lbLatitude.setBounds(20,90, 100, 30);
		lbLongitude.setBounds(20, 130 , 100, 30);
		btnStart.setBounds(20,170,80,30);
		btnStop.setBounds(120, 170, 80 ,30);
		btnQuit.setBounds(220,170,80,30);
		panel.add(tfSensorID);
		panel.add(lbSensorID);
		panel.add(lbSensorAddress);
		panel.add(tfSensorAddress);
		panel.add(tfLongitude);
		panel.add(lbLongitude);
		panel.add(tfLatitude);
		panel.add(lbLatitude);
		panel.add(btnStart);
		panel.add(btnStop);
		panel.add(btnQuit);
		Container cp = this.getContentPane();
		cp.add(panel);
		setSize(360,260);
		setTitle(" Create new sensor ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#getSensorID()
	 */
	@Override
	public String getSensorID(){
		return tfSensorID.getText();
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#getLatitude()
	 */
	@Override
	public double getLatitude(){
		double latitude = -1;
		if (!tfLatitude.getText().equals("")){
			try{
				latitude = Double.parseDouble(tfLatitude.getText());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());
			}
		}
		else {
			return 0;
		}
		
		return latitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#getLongitude()
	 */
	@Override
	public double getLongitude(){
		double longitude = -1;
		if (!tfLatitude.getText().equals("")){
			try{
				longitude = Double.parseDouble(tfLongitude.getText());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());
			}
		}
		else {
			return 0;
		}
		
		return longitude;
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#setCancelButtonActionListener(ActionListener)
	 */
	@Override
	public void setCancelButtonActionListener(ActionListener listener){
		this.btnQuit.addActionListener(listener);
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#setCreateButtonActionListener(ActionListener)
	 */
	@Override
	public void setCreateButtonActionListener(ActionListener listener){
//		this.btnOK.addActionListener(listener);
	}	
	/**
	 * (non-Javadoc)
	 * @see samsung.java.weather.view.INewSensorForm#closeForm()
	 */
	@Override
	public void closeForm(){
		super.dispose();
	}
}
