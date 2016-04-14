package samsung.java.smart.store.model;

/**
 * @author Bui Trong Tung
 * The Account class implementing IAccount illustrates an user in system
 */
public class Account implements IAccount {
	private String userID;
	private String password;
	int permission;
	/**
	 * Default constructor
	 */
	public Account(){
		
	}
	
	/**
	 * Construct a new user account with initial values
	 * @param initID The identification
	 * @param initPassword The password
	 * @param initPermission The 0 value is user account, the 1 value is administrator account 
	 */
	public Account(String initID, String initPassword, int initPermission){
		this.userID = initID;
		this.password = initPassword;
		this.permission = initPermission;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IAccount#getID()
	 */
	@Override
	public String getID(){
		return this.userID;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IAccount#getPassword()
	 */
	@Override
	public String getPassword(){
		return this.password;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IAccount#getPermission()
	 */
	@Override
	public int getPermission() {
		return this.permission;
	}
}
