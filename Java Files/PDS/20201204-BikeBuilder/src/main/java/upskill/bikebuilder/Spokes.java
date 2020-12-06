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
public class Spokes {
    String color;
    String material;
    double gauge;
    double width;

    public Spokes(String color, String material, double gauge, double width) {
        this.color = color;
        this.material = material;
        this.gauge = gauge;
        this.width = width;
    }

    public Spokes() {
        this.color = "Silver";
        this.material = "Inox Steel";
        this.gauge = 1.8; // milimeters
        this.width = 300; //milmeters
    }

    @Override
    public String toString() {
        return "Spokes{" + "color=" + color + ", material=" + material + ", gauge=" + gauge + ", width=" + width + '}';
    }
    
    
}
