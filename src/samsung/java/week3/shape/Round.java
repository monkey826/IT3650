/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samsung.java.week3.shape;

/** Describe a round shape
 *
 * @author monkey
 */
public class Round {
    private double radius;
    /**  Constructor default;
     * 
     */
    public Round(){
        
    }
    /** Constructor modified
     * 
     * @param r : radius input
     */
    public Round(double r){
        setRadius(r);
    }
    /** Getter: Take radius of round
     * 
     * @return  radius
     */
    public double getRadius(){
        return radius;
    }
    /** Setter: Set radius of round
     * 
     * @param r : radius input
     */
    public void setRadius(double r){
    	if ( r > 0 ) 
    		this.radius = r;
    }
    /** Calculate diameter
     * 
     * @return value of diameter.
     */
    public double calDiameter(){
        return getRadius()*2;
    }
    /** calculate Circumference of round
     * 
     * @return circumference of round
     */
    public double calCircumference(){
        return Math.PI*getRadius()/2;
    }
    /** calculate the area of round
     * 
     * @return  area
     */
    public double calArea(){
        return Math.PI*Math.pow(getRadius(), 2);
    }
}
