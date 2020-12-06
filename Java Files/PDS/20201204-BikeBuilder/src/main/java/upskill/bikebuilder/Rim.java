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
public class Rim {
    double diameter;
    String material;

    public Rim() {
        this.diameter = 622; // milimeters
        this.material = "Inox Steel";
    }

    public Rim(double diameter, String material) {
        this.diameter = diameter; // milimeters
        this.material = material;
    }

    @Override
    public String toString() {
        return "Rim{" + "diameter=" + diameter + ", material=" + material + '}';
    }
    
    
}
