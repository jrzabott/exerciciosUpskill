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
public class Chain {
    String color;
    String material;
    double length;

    public Chain(String color, String material, double length) {
        this.color = color;
        this.material = material;
        this.length = length;
    }

    public Chain() {
        this.color = "Silver";
        this.material = "Inox Steel";
        this.length = 1320.8; // milimeters 
    }

    @Override
    public String toString() {
        return "Chain{" + "color=" + color + ", material=" + material + ", length=" + length + '}';
    }
    
}
