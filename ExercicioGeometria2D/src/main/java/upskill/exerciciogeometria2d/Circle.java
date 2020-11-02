/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciogeometria2d;

/**
 *
 * @author user
 */
public class Circle {

    private double radius;
    
    final private double PI = Math.PI;
    final private double RADIUS_DEFAULT = 0.0;

    public Circle() {
        this.radius = RADIUS_DEFAULT;
    }

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
        return PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2.0 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" 
                + "radius=" + radius 
                + ", PI=" + PI 
                + ", Area=" + getArea()
                + ", Perimeter=" + getPerimeter()
                + '}';
    }

}
