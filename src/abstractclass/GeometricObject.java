/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractclass;

/**
 *
 * @author BENBENZ
 */
public class GeometricObject {
    
    public static void main(String[] args) throws CloneNotSupportedException {
//        //test class 5.3
//        GeometricObject1 oc1 = new Octagon(5);
//        System.out.println(oc1.getArea());
//        System.out.println(oc1.getPerimeter());
//        GeometricObject1 oc2 = (GeometricObject1) oc1.clone();
//        if (oc1 == oc2) {
//            System.out.println("Object 1 equals Object 2(clone)");
//        } else {
//            System.out.println("Object 1 not equals Object 2(clone)");
//        }
        //test class 5.4
        System.out.println("----------------");
        ComparableCircle circle1 = new ComparableCircle(5);
        ComparableCircle circle2 = new ComparableCircle(4);
        Object circle = Max.max(circle1, circle2);
        if (circle == circle1) {
            System.out.println("The max circle's radius is circle1");
        } else if (circle == circle2) {
            System.out.println("The max circle's radius is circle2");
        }
    }
}
abstract class GeometricObject1 {
    private String color = "white";
    private boolean filled;

    protected GeometricObject1() {}

    protected GeometricObject1(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

//5.1
class Circle extends GeometricObject implements Comparable<Circle> {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Circle circle) {
        if (this.radius == circle.getRadius()) {
            return 0;
        } else if (this.radius > circle.getRadius()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Circle)) {
            return super.equals(obj);
        }
        return super.equals(obj) && radius == ((Circle) obj).radius;
    }
}
//5.2
class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return super.equals(obj);
        }
        return super.equals(obj) && width == ((Rectangle) obj).width && super.equals(obj) && height == ((Rectangle) obj).height;
    }

    @Override
    public int compareTo(Rectangle rectangle) {
        if (getArea() == rectangle.getArea()) {
            return 0;
        } else if (getArea() > rectangle.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }
}
//5.3
class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    double side;

    public Octagon() {}

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(double side, String color, boolean filled) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Octagon)) {
            return super.equals(obj);
        }
        return super.equals(obj) && side == ((Octagon) obj).side;
    }

    @Override
    public int compareTo(Octagon o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//find max obj
class Max {
    public static Object max(Object obj1, Object obj2) {
        if (((Comparable) obj1).compareTo(obj2) > 0) {
            return obj1;
        } else {
            return obj2;
        }
    }
}
//5.4
class ComparableCircle extends Circle implements Comparable<Circle> {
    public ComparableCircle(double radius) {
        super(radius);
    }
    
    public int compareTo(ComparableCircle comparableCircle) {
        if (getRadius() > ((Circle) comparableCircle).getRadius()) {
            return 1;
        } else if (getRadius() < ((Circle) comparableCircle).getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(Circle o) {
        if (getRadius() > ((Circle) comparableCircle).getRadius()) {
            return 1;
        } else if (getRadius() < ((Circle) comparableCircle).getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
