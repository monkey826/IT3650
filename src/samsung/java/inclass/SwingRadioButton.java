package samsung.java.inclass;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingRadioButton extends JFrame {
	private JTextField tfCount;
	private int count = 0;
	private boolean countingUp = true;
	private int step = 1; 
	public SwingRadioButton (){
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Counter:"));
		tfCount = new JTextField("0",5);
		tfCount.setEditable(false);
		tfCount.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfCount);
		JRadioButton rbUp = new JRadioButton("Up",false);
		rbUp.setMnemonic(KeyEvent.VK_U);
		cp.add(rbUp);
		rbUp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e ){
				countingUp = true;
			}
		});
		JRadioButton rbDown = new JRadioButton("Down",true);
		rbDown.setMnemonic(KeyEvent.VK_D);
		cp.add(rbDown);
		rbDown.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e ){
				countingUp = false;
			}
		});
		ButtonGroup btnGp = new ButtonGroup();
		btnGp.add(rbUp);
		btnGp.add(rbDown);
		add(new JLabel ("Step:"));
		final Integer[] steps = {1,2,3,4,5};
		final JComboBox<Integer> comboCount = new JComboBox<Integer>(steps);
		comboCount.setPreferredSize(new Dimension(60,20));
		cp.add(comboCount);
		comboCount.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED ){
					step = (Integer)comboCount.getSelectedItem();
				}
				// TODO Auto-generated method stub
				
			}
		});
		JButton btnCount = new JButton("Count");
		btnCount.setMnemonic(KeyEvent.VK_C);
		cp.add(btnCount);
		btnCount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!countingUp){
					count += step;
				}
				else {
					count -= step;
				}
				tfCount.setText(count + "");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Swing counter with RadioButton & ComboBox");
		setSize(480, 100);
		setVisible(true);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SwingRadioButton();
			}
		});
	}
}
