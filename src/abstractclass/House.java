/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractclass;

/**
 *
 * @author BENBENZ
 */
public class House implements Cloneable, Comparable<House> {

    private int id; //declare private int id
    private double area; //declare private double  area
    private java.util.Date whenBuilt; //declare private date class name whenBuilt

    public House(int id, double area) { //constructor House have 2 perimeter
        this.id = id; //set private id = id
        this.area = area; //set private area = area
        whenBuilt = new java.util.Date(); //create a new object date class
    }

    public int getId() { //method get id value
        return id; //return id value
    }

    public double getArea() { //method get area value
        return area; //return area value
    }

    public java.util.Date getWhenBuilt() { //method get whenBuilt value
        return whenBuilt; //return whenBuilt value
    }

    @Override
    public Object clone() { // Implement the clone method defined in Cloneable
        try {
            return super.clone(); //return object class to call clone  method
        } catch (CloneNotSupportedException ex) {//fix error
            return null; //return null when error about clone
        }
    }

    @Override // Implement the compareTo method defined in Comparable
    public int compareTo(House o) {
        if (area > o.area) { //when area > area in class House return 1;
            return 1;
        } else if (area < o.area) {//when area < area in class House return -1;
            return -1;
        } else {
            return 0;//other case return 0
        }
    }
    //*** can't see result
    public static void main(String[] args){
        House house1 = new House(1, 1750.50); //create new House past value to constructor
        House house2 = (House)house1.clone(); //new instance of the class copy of an object.
    }
}
