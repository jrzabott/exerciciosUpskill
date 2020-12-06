/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.bikebuilder;

/**
 *
 * @author user
 */
public class HandleBar {
    double length;
    boolean curved;
    double weigth;
    String color;

    public HandleBar(double length, boolean curved, double weigth, String color) {
        this.length = length;
        this.curved = curved;
        this.weigth = weigth;
        this.color = color;
    }

    public HandleBar() {
        this.length = 300.0 ; //milimeters
        this.curved = true;
        this.weigth = 1.2; //kg
        this.color = "Black";
    }

    @Override
    public String toString() {
        return "HandleBar{" + "length=" + length + ", curved=" + curved + ", weigth=" + weigth + ", color=" + color + '}';
    }
    
    
}
