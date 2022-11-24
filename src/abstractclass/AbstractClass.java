/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;

import javafx.scene.shape.Circle;

/**
 *
 * @author LAB_621
 */
public class AbstractClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Geometric a = new Geometric(); //abstract cant new like this before override
        // Geometric a = new Cricle(); 
          Geometric a = new Triangle();
          Geometric[] arr = new Geometric[10];
          arr[0] = new Cricle();
          
          Comparable1 o = new Circle();
          
    }
    
}
interface Comparable1{
    abstract void compareA();
}
abstract class Geometric{ //abstract class
    double area;
    double peri;
    abstract void calArea(); //abstract method
    abstract void calPeri(); 
}

class Circle extends Geometric implements Comparable1{
    double r;
    @Override
    void calArea() { //implement abstact method
        area = 3.14 * r * r;
    }
    public abstract compareA(){};
    @Override
    void calPeri() {
        
    }
    
}

class Square extends Geometric{

    @Override
    void calArea() { //implement abstract method
        
    }

    @Override
    void calPeri() {
        
    }
    
}

class Triangle extends Geometric{

    @Override
    void calArea() {
        
    }

    @Override
    void calPeri() {
        
    }
    
}