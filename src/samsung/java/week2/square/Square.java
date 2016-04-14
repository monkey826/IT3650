package samsung.java.week2.square;
/**Set class Square : describe a square
 * 
 * @author monkey
 *
 */
public class Square {
	
	private float edge;
	/** The constructor with float argument
	 * 
	 * @param edge : set edge of this square
	 */
	public Square(float edge){
		
		setEdge(edge);
	}
	/** Getter method
	 * 
	 * @return : Edge of this square
	 */
	public float getEdge() {
		return edge;
	}
	/** Setter method
	 * 
	 * @param edge 
	 */
	public void setEdge(float edge) {
		if ( edge > 0 && Float.isFinite(edge))
			this.edge = edge;
	}
	/**
	 *  Display length of square edge
	 */
	public void displayLength(){
		
		System.out.println("Length of square edge is : "+ getEdge());
	}
	/**
	 *  Display the perimeter of square
	 */
	public void displayPerimeter(){	
		System.out.println("The perimeter of square is : "+ getEdge()*4);
	}
	/**
	 * Display the area of square
	 */
	public void displayArea(){	
		System.out.println("The area of square is : " + Math.pow(getEdge(), 2));
	}
	/** 
	 * Display the length of square edge, 
	 * Display the perimeter,area of square
	 */
	public void displayAllInfo(){	
		displayLength();
		displayPerimeter();
		displayArea();
	}
}
