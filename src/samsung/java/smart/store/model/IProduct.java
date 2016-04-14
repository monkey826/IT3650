package samsung.java.smart.store.model;

public interface IProduct {

	/**Get the identification of the product
	 * @return The identification
	 */
	public String getID();

	/**
	 * Get the name of the product
	 * @return The name
	 */
	public String getName();

	/**Get the remain amount of the product in the store
	 * @return An integer is the amount of the product
	 */
	public int getAmount();

}