package samsung.java.smart.store.view;

import java.awt.event.ActionListener;

/**
 * @author Bui Trong Tung
 * The ISignInForm list methods for the Sign in form
 */
public interface ISignInForm {

	/**
	 * Set listener to Sign in button on form
	 * @param listener The ActionListener listens and handles the event when the user click on Sign in button   
	 */
	public void setSignInButtonActionListener(ActionListener listener);
	
	/**Get user name that user entered on the Sign in form
	 * @return A user name
	 */
	public String getUserNameOnSignInForm();
	
	/**Get password that user entered on the Sign in form
	 * @return A password
	 */
	public String getPasswordOnSignInForm();
	
	/**
	 * Close the sign in form
	 */
	public void closeForm();

}