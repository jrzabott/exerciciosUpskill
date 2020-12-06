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
public class Frame {
    double weight;
    String material;
    String color;

    public Frame(double weight, String material, String color) {
        this.weight = weight;
        this.material = material;
        this.color = color;
    }

    public Frame() {
        this.weight = 11.3; //kg
        this.material = "Inox Steel";
        this.color = "Silver";
    }

    @Override
    public String toString() {
        return "Frame{" + "weight=" + weight + ", material=" + material + ", color=" + color + '}';
    }
    
    
}
