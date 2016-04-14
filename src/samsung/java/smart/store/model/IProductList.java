package samsung.java.smart.store.model;

public interface IProductList {
	/**Get the list of products in store
	 * @return A list of products
	 */
	public IProduct[] getList();
	/** Get number of products in store
	 * 
	 * @return number of products
	 */
	public int getNumberOfProduct();
}