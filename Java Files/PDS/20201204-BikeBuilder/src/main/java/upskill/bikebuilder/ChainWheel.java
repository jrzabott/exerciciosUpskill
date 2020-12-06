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
public class ChainWheel {
    String color;
    String material;
    double weigth;

    public ChainWheel(String color, String material, double weigth) {
        this.color = color;
        this.material = material;
        this.weigth = weigth;
    }

    public ChainWheel() {
        this.color = "Black";
        this.material = "Inox Steel";
        this.weigth = 3.0; //kg
    }

    @Override
    public String toString() {
        return "ChainWheel{" + "color=" + color + ", material=" + material + ", weigth=" + weigth + '}';
    }
    
    
}
