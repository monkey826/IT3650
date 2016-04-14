package samsung.java.smart.store.model;

public class Product implements IProduct {
	private String ID;
	private String name;
	private int amount;
	
	/**
	 * Default construct
	 */
	public Product(){
		
	}
	
	/**Constructs new product with initial values
	 * @param initID The identification
	 * @param initName The name
	 * @param initAmount The amount of product in stock
	 */
	public Product(String initID, String initName, int initAmount){
		this.ID = initID;
		this.name = initName;
		this.amount = initAmount;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IProduct#getID()
	 */
	@Override
	public String getID(){
		return this.ID;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IProduct#getName()
	 */
	@Override
	public String getName(){
		return this.name;
	}
	
	/* (non-Javadoc)
	 * @see samsung.java.smart.store.model.IProduct#getAmount()
	 */
	@Override
	public int getAmount(){
		return this.amount;
	}
}
