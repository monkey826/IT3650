package samsung.java.smart.store.model;

public interface IAccount {

	/**Get the identification of the user
	 * @return The identification (ID)
	 */
	public String getID();
	
	/**Get the password of the account
	 * @return A string contains password
	 */
	public String getPassword();
	
	/**Get the permission of the account
	 * @return The permission
	 */
	public int getPermission();
}