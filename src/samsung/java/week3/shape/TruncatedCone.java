/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samsung.java.week3.shape;

/**  TruncatedCone class : describe a TruncatedCone shape
 *  Inherited : Cone Class 
 *  <br> Aggregation from Round class
 * @author monkey
 * 
 */
public class TruncatedCone {
   public double height; // height of this Cone
   public Round round1; // round smaller aggregation from 
   public Round round2; // round bigger
   public double LH; // literal height
   /**  The constructor inherited from the constructor Cone(height) and add more 
    *  attributes default, set value of literal height
    * 
    * @param height : height of this TruncatedCone
    * @param round1 : round smaller of this TruncatedCone
    * @param round2 : round bigger of this TruncatedCone
    * 
    */
   public TruncatedCone(double height ,double radius1, double radius2 ){
	   setHeight(height);
	   round1 = new Round(radius1) ; 
       round2 = new Round(radius2) ;
       setLH();
   }
   /** Getter method : get radius round smaller
    * 
    * @return  a  radius round small 
    */
   public double getRadius1(){
       return round1.getRadius();
   }
   /** Getter method : get radius round bigger
    * 
    * @return  a radius round big 
    */
   public double getRadius2(){
       return round2.getRadius();
   }
   /** Setter method: set length of height 
    * 
    * @param height : length of height
    */
   public void setHeight(double height ){
	   this.height = height;
   }
   /** Getter method : get length of height
    * @return  the length of height
    */
   public double getHeight(){
       return height;
   }
   /** Getter method : get length of literal height
    * 
    * @return  the length of literal height
    */
   public double getLH(){
       return LH;
   }
   /** Setter: Set LH value
    * 
    */
   public void setLH(){
	   double r1 = getRadius1();
	   double r2 = getRadius2();
	   double h = getHeight();
	   this.LH = Math.sqrt((Math.pow(r2, 2)-Math.pow(r1,2))+Math.pow(h,2));
   }
   /** Calculate the value of surrounding area
    *  @return  the value of surrounding area
    */
   public double calSurroundingArea(){
	   double r1 = getRadius1();
	   double r2 = getRadius2();
	   return Math.PI*getLH()*(r1 + r2);
   }
   /**  Calculate the value of full area
    * @return  Calculate the value of full area
    */
   public double calFullArea(){
	   double r1 = getRadius1();
	   double r2 = getRadius2();
	   double l = getLH();
	   return Math.PI*( r1*(r1+l) + r2*(r2+l) );
   }
   /**  Calculate the value of Volume
    * @return  Calculate the value of Volume
    */
   public double calVolume(){
	   double h = getHeight();
	   double r1 = getRadius1();
	   double r2 = getRadius2();
	   return Math.PI*h*(r1*r1 +r1*r2 + r2*r2)/3;
   }
}
