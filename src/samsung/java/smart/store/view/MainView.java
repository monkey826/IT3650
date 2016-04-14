package samsung.java.smart.store.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.MenuListener;

/**
 * @author Bui Trong Tung
 * The MainView extending JFrame displays the main view of the Smart Store System. This class imple
 */
@SuppressWarnings("serial")
public class MainView extends JFrame implements IMainView {
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem fileChooser;
	private JMenuItem createAccountItem;
	private JMenuItem signOutMenu;
	private JButton btnFileChooser;
	private static JPanel panel;
	/**
	 * Constructs the main windows of the Smart Store System
	 */
	public MainView(){
		LookAndFeel old = UIManager.getLookAndFeel();
	    try {
	       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Throwable ex) {
	       old = null;
	    } 
		/////////////////////////////////////////
		String colName[] = {"Product ID","Product Name","Amount"};
		String rowData[][]= { {" "," ", " "} };
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(20, 20, 500, 450);
		JTable table = new JTable(rowData, colName);
		table.getTableHeader().setBackground(Color.DARK_GRAY);
		table.getTableHeader().setForeground(Color.BLUE);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		scrollPane.setBounds(40, 15, 500, 370);
		btnFileChooser = new JButton("Choose data file…");
		panel.add(btnFileChooser);
		btnFileChooser.setBounds(40, 400, 150, 30);
		Container cp = this.getContentPane();
		cp.add(panel);
		/**
		 * Create menu bar
		 */
		createMenuBar();
		//////////
		setTitle("Smart Store");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#createChooseFileButton()
	 */
	@Override
	public void createMenuBar(){
		menuBar = new JMenuBar();
		//Product menu
		menu = new JMenu("Products");
		menu.setMnemonic(KeyEvent.VK_P);
		menuBar.add(menu);
		
		fileChooser = new JMenuItem("Choose file data. ");
		menu.add(fileChooser);
		menuBar.add(menu);
		//Account menu
		menu = new JMenu("Account");
		menu.setMnemonic(KeyEvent.VK_A);
		
		signOutMenu = new JMenuItem("Sign out", KeyEvent.VK_S);
		menu.add(signOutMenu);
		menuBar.add(menu);
		//Exit menu
		menu = new JMenu("Exit");
		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	/**(non-Javadoc)
	 *  @see samsung.java.smart.store.view.IMainView#setExitActionListener()
	 */
	@Override
	public void setExitActionListener(MenuListener listener){
		menu = menuBar.getMenu(2);
		this.menu.addMenuListener(listener);
	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#addAdminMenuItem()
	 */
	@Override
	public void addCreateAccountMenu(){
		createAccountItem = new JMenuItem("Create new account", KeyEvent.VK_C);
		menu = menuBar.getMenu(1);
		menu.add(createAccountItem);
		this.validate();
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setAdminItemActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setCreateAccountActionListener(ActionListener listener){
		this.createAccountItem.addActionListener(listener);
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setSignOutActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void setSignOutActionListener(ActionListener listener) {
		this.signOutMenu.addActionListener(listener);		
	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setButtonFileChooserActionListener()
	 */
	@Override
	public void setButtonFileChooserActionListener(ActionListener listener){
			this.btnFileChooser.addActionListener(listener);
	}
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#setFileChooserActionListener()
	 */
	@Override
	public void setFileChooserActionListener(ActionListener listener){
		this.fileChooser.addActionListener(listener);
	}
	/** (non-Javadoc)
	 *  @see samsung.java.smart.store.view.IMainView#createTable()
	 */
	@Override
	public void createTable(String rowData[][], String colName[]){
		panel.removeAll();
		panel.setLayout(null);
		panel.setBounds(20, 20, 500, 450);
		JTable table = new JTable(rowData, colName);
		table.getTableHeader().setBackground(Color.DARK_GRAY);
		table.getTableHeader().setForeground(Color.BLUE);
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		scrollPane.setBounds(40, 15, 500, 370);
		btnFileChooser = new JButton("Choose data file…");
		panel.add(btnFileChooser);
		btnFileChooser.setBounds(40, 400, 150, 30);
//		setButtonFileChooserActionListener();
		Container cp = this.getContentPane();
		cp.add(panel);
		validate();
		
	}
	/**
	 * (non-Javadoc)
	 * @see samsung.java.smart.store.view.IMainView#closeForm()
	 */
	public void closeForm(){
		super.dispose();		
	}
	
	
}
