/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samsung.java.week3.shape;

/** Cone class : describe a cone shape
 * Aggregation : Round class
 * @author monkey
 */
public class Cone extends TruncatedCone{
   /**  The constructor with more attributes initiate references from argument input
    *  
    * 
    * @param height : height of this Cone
    * @param round : Round type 
    */
   public Cone(double height, double radius){
       super(height,0,radius);
   }
}
