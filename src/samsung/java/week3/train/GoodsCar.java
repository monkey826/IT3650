package samsung.java.week3.train;
/** Describe a goods train.
 * 
 * @author monkey
 *
 */
public class GoodsCar extends RailCar{
	private double goodsWeight; // weight of goods.
	/** The constructor with 3 arguments input
	 * 
	 * @param ID
	 * @param unWeight
	 * @param goodsWeight
	 */
	public GoodsCar(String ID, double unWeight, double goodsWeight) {
		super(ID,unWeight);
		setGoodsWeight(goodsWeight);
	}
	/** Getter method : Get weight of goods;
	 * 
	 * @return weight of goods;
	 */
	protected double getGoodsWeight() {
		return goodsWeight;
	}
	/** Setter method : Set weight of goods;
	 * 
	 * @param goodsWeight : weight of goods;
	 */
	protected void setGoodsWeight(double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	/** Calculate total weight of this goods  car
	 * 
	 * @return total weight
	 */
	public double calTotalWeight(){
		return getGoodsWeight() + getUnWeight();
	}
	/** Display all information about goodscar
	 * 
	 */
	public void displayAll(){
		super.displayAll();
		System.out.println(" Total weight :" + calTotalWeight() + " tons");
	}

}
