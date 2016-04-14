package samsung.java.smart.store.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import samsung.java.smart.store.model.AccountList;
import samsung.java.smart.store.model.IAccountList;
import samsung.java.smart.store.view.ISignInForm;
import samsung.java.smart.store.view.SignInForm;



/**
 * @author Bui Trong Tung
 * The SignInController class handles the sign in request of the user 
 */
public class SignInController {

	private IAccountList accList = new AccountList();
	private final ISignInForm signInForm = new SignInForm();
	
	/**
	 * The constructor 
	 */
	public SignInController(){
		signInForm.setSignInButtonActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = signInForm.getUserNameOnSignInForm();
				String password = signInForm.getPasswordOnSignInForm();
				int checkAcc = accList.check(userName, password);
				if ( checkAcc == -1){					
					JOptionPane.showMessageDialog(null, "Invalid username or password!");					
				}
				else{
					signInForm.closeForm();
					MainViewController main = new MainViewController();
					if (checkAcc == 1)
						main.setAdminView();
				}								
			}			
		});
	}
}
