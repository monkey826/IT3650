package samsung.java.smart.store.model;

public interface IAccountList {
	/**
	 * The path of the file that contains account data
	 */
	public static final String ACCOUNT_FILE = "E:\\user.txt";
	
	/**
	 * Append an account to system
	 * @param acc : new account

	 */
	public boolean addAccount(IAccount acc);

	/**Check the account that the user enter on Sign in form
	 * @param name The checked identification
	 * @param password The check password
	 * @return Return the -1 value if the account is invalid. Return the permission of the account if the user successfully signin 
	 */
	public int check(String name, String password);
	/**
	 * Check the account that the user name have exist . Yes or No  
	 * @param name
	 * @return return true if the account is exist. Return false if not.
	 */
	public boolean checkAcc(String name);
}