package samsung.java.smart.store.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import samsung.java.smart.store.model.Account;
import samsung.java.smart.store.model.AccountList;
import samsung.java.smart.store.model.IAccount;
import samsung.java.smart.store.model.IAccountList;
import samsung.java.smart.store.model.IProduct;
import samsung.java.smart.store.model.IProductList;
import samsung.java.smart.store.model.ProductList;
import samsung.java.smart.store.view.CreateAccountForm;
import samsung.java.smart.store.view.ICreateAccountForm;
import samsung.java.smart.store.view.IMainView;
import samsung.java.smart.store.view.MainView;

/**
 * @author Bui Trong Tung and Dao Nam Tien The class MainViewController controls
 *         the main windows of the Smart Store application
 */
public class MainViewController {
	private IMainView mainWindow;

	/**
	 * The constructor
	 */
	public MainViewController() {
		mainWindow = new MainView();
		// ////// Set Sign Out
		mainWindow.setSignOutActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// Close the Sign in window when the user cancels
				mainWindow.closeForm();
				new SignInController();
			}
		});
		// // Set Exit program
		mainWindow.setExitActionListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				mainWindow.closeForm();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
			}
		});
		mainWindow.setButtonFileChooserActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// / windows background
				LookAndFeel old = UIManager.getLookAndFeel();
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Throwable ex) {
					old = null;
				}
				// / Add window choose file
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					String path = f.getPath();
					System.out.println(path);
					IProductList productList = new ProductList(path);
					String colName[] = { "Product ID", "Product Name", "Amount" };
					int numberOfProduct = productList.getNumberOfProduct();
					String rowData[][] = new String[numberOfProduct][3];
					IProduct[] list = productList.getList();
					for (int i = 0; i < numberOfProduct; i++) {
						rowData[i][0] = new String(list[i].getID());
						System.out.println(rowData[i][0]);
						rowData[i][1] = new String(list[i].getName());
						rowData[i][2] = new String();
						rowData[i][2] += list[i].getAmount();
					}
					// create table
					mainWindow.createTable(rowData, colName);
				}
				new FileChooseController(mainWindow);
			}
		});
		mainWindow.setFileChooserActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// / windows background
				LookAndFeel old = UIManager.getLookAndFeel();
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Throwable ex) {
					old = null;
				}
				// / Add window choose file
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					String path = f.getPath();
					System.out.println(path);
					IProductList productList = new ProductList(path);
					String colName[] = { "Product ID", "Product Name", "Amount" };
					int numberOfProduct = productList.getNumberOfProduct();
					String rowData[][] = new String[numberOfProduct][3];
					IProduct[] list = productList.getList();
					for (int i = 0; i < numberOfProduct; i++) {
						rowData[i][0] = new String(list[i].getID());
						System.out.println(rowData[i][0]);
						rowData[i][1] = new String(list[i].getName());
						rowData[i][2] = new String();
						rowData[i][2] += list[i].getAmount();
					}
					// create table
					mainWindow.createTable(rowData, colName);
				}
				new FileChooseController(mainWindow);
			}
		});
	}

	/**
	 * Change the main window if the user has administrator permission
	 */
	public void setAdminView() {
		mainWindow.addCreateAccountMenu();
		mainWindow.setCreateAccountActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.closeForm();
				LookAndFeel old = UIManager.getLookAndFeel();
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Throwable ex) {
					old = null;
				}
				ICreateAccountForm createAccountForm = new CreateAccountForm();
				// TODO Auto-generated method stub

				createAccountForm
						.setCreateAccountButtonActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								String userName = createAccountForm
										.getUserNameOnSignInForm().trim();
								String password = createAccountForm
										.getPasswordOnSignInForm();
								int permission = createAccountForm
										.getPermissionOnSignInForm();
								if ((!userName.equals(""))
										&& (!password.equals(""))) {
									if ((userName.indexOf(" ") != -1)
											|| (password.indexOf(" ") != -1)) {
										JOptionPane.showMessageDialog(null,
														"Error. The username or password not have any space characters !");
									} else {
										IAccountList accList = new AccountList();
										if (!accList.checkAcc(userName)) {
											IAccount acc = new Account(userName, password,permission);
											if (accList.addAccount(acc)) {
												JOptionPane.showMessageDialog(null, " Successful !");
												JOptionPane.showMessageDialog(null," Your username is "+ userName);
											} else {
												JOptionPane.showMessageDialog(null,"Failed. Cannot add new account, because the list account is full");
											}
										} else {
											JOptionPane.showMessageDialog(null," This username have existed. ");
										}
									}
									createAccountForm.closeForm();
									MainViewController main = new MainViewController();
									main.setAdminView();
								} else {
									if (userName.equals(""))
										JOptionPane.showMessageDialog(null," Error. Username was empty");
									if (password.equals(""))
										JOptionPane.showMessageDialog(null," Error. Password was empty");
								}
							}
						});
			}
		});
	}
}
