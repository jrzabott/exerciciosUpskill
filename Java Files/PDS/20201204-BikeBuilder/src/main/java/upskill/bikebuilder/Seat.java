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
public class Seat {
    String material;
    String type;

    public Seat() {
        this.material = "Fake Leather";
        this.type = "Regular";
        
    }

    public Seat(String material, String type) {
        this.material = material;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Seat{" + "material=" + material + ", type=" + type + '}';
    }
    
    
}
