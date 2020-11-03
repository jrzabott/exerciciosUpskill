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
public class Rectangle {

    private double height;
    private double width;
    
    final private double HEIGHT_DEFAULT = 0.0;
    final private double WIDTH_DEFAULT = 0.0;

    public Rectangle() {
        this.height = HEIGHT_DEFAULT;
        this.width = WIDTH_DEFAULT;
    }
    
    
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" 
                + "height=" + height 
                + ", width=" + width 
                + ", area=" + getArea()
                + ", perimeter=" + getPerimeter()
                + '}';
    }

    
}
