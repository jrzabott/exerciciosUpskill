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
public class Tire {
    String type;
    String brand;
    String shape;
    boolean tubeless;

    public Tire(String type, String brand, String shape, boolean tubeless) {
        this.type = type;
        this.brand = brand;
        this.shape = shape;
        this.tubeless = tubeless;
    }

    public Tire() {
        this.type = "General Usage";
        this.brand = "Pirelli";
        this.shape = "Circular";
        this.tubeless = true;
    }

    @Override
    public String toString() {
        return "Tire{" + "type=" + type + ", brand=" + brand + ", shape=" + shape + ", tubeless=" + tubeless + '}';
    }
    
    
    
}
