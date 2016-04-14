package samsung.java.smart.store.view;

import java.awt.event.ActionListener;

public interface ICreateAccountForm {
	/**
	 * Set listener to create button on form
	 * @param listener The ActionListener listens and handles the event when the user click on create button   
	 */
	public void setCreateAccountButtonActionListener(ActionListener listener);
	
	/**Get user name that user entered on the Sign in form
	 * @return A user name
	 */
	public String getUserNameOnSignInForm();
	
	/**Get password that user entered on the Sign in form
	 * @return A password
	 */
	public String getPasswordOnSignInForm();
	/** Get permission that user entered on the Sign in form
	 * @return permission
	 */
	public int getPermissionOnSignInForm();
	/**
	 * Close the sign in form
	 */
	public void closeForm();
}
