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
public class GeometryMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a circle, a square and a rectangle
        Circle circle = new Circle(10.0);
        Rectangle square = new Rectangle(5.0, 5.0);
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        
        System.out.println("CIRCLE: " + circle.toString());
        System.out.println("SQUARE: " + square.toString());
        System.out.println("RECTANGLE: " + rectangle.toString());
    }
    
}
