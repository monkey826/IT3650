package samsung.java.smart.store.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import samsung.java.smart.store.controller.MainViewController;
@SuppressWarnings("serial")
public class CreateAccountForm extends JFrame implements ICreateAccountForm{
	private JTextField tfUserName;
	private JPasswordField pwField;
	private JButton btnCreate;
	private JButton btnCancel;
	private JRadioButton rbtnYes;
	private JRadioButton rbtnNo;
	/**
	 * Constructs the form for add new account
	 */
	public CreateAccountForm(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel lbUserName = new JLabel("Username:");
		lbUserName.setBounds(30, 20, 100, 30);
		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setBounds(30,70,100,30);
		this.tfUserName = new JTextField(15);
		tfUserName.setBounds(110,20,150,30);
		this.pwField = new JPasswordField(15); // x,y,w,h
		pwField.setBounds(110,70,150,30);
		this.btnCreate = new JButton("Create");
		btnCreate.setBounds(80, 200, 90, 30);
		this.btnCancel = new JButton("Cancel");
		btnCancel.setBounds(180, 200, 90, 30);
		btnCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Container frame = btnCancel.getParent();
				do 
					frame = frame.getParent();
				while (!(frame instanceof JFrame));
				((JFrame) frame).dispose();
				new MainViewController();
			}
		});
		panel.add(lbUserName);
		panel.add(tfUserName);
		panel.add(lbPassword);
		panel.add(pwField);
		///////////////////////////////////////
		/* Add two button into new Panel */
		JPanel panelPermission = new JPanel();
		rbtnYes= new JRadioButton("Yes",true);
		rbtnYes.setBounds(20,25,50, 20);
		rbtnNo= new JRadioButton("No");
		rbtnNo.setBounds(80,25,50, 20);
		panelPermission.setLayout(null);
		panelPermission.add(rbtnYes);
		panelPermission.add(rbtnNo );
		panelPermission.setBounds(28,120,233,60);
		panelPermission.setBorder(BorderFactory.createTitledBorder(" Administrator account: "));
		////////////////////
		panel.add(panelPermission);
		panel.add(btnCreate);
		panel.add(btnCancel);
		panel.add(lbPassword);
		panel.add(lbUserName);
		// Add two button into a group 
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtnYes);
		bg.add(rbtnNo);
		///////////////////////////////////////
		Container cp = this.getContentPane();
		cp.add(panel);
		setTitle("Create new account");
		setSize(310, 290);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	/**(non-Javadoc)
	 * @see samsung.java.smart.store.view.ICreateAccountForm#setCreateAccountButtonActionListener()
	 */

	public void setCreateAccountButtonActionListener(ActionListener listener){
		this.btnCreate.addActionListener(listener);
	}
	/** (non-Javadoc)
	 * @see samsung.java.smart.store.view.ICreateAccountForm#getUserNameOnSignInForm()
	 */
	
	public String getUserNameOnSignInForm() {
		// TODO Auto-generated method stub
		return this.tfUserName.getText();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see samsung.java.smart.store.view.ICreateAccountForm#getPasswordOnSignInForm()
	 */
	public String getPasswordOnSignInForm() {
		// TODO Auto-generated method stub
		return (new String (this.pwField.getPassword()));
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.smart.store.view.ICreateAccountForm#getPermissionOnSignInForm()
	 */
	
	public int getPermissionOnSignInForm(){
		if (rbtnYes.isSelected()) return 1;
		return 0;
	}
	/** (non-Javadoc)
	 * @see samsung.java.smart.store.view.ICreateAccountForm#closeForm()
	 */
	public void closeForm(){
		super.dispose();		
	}
}
