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
public class Wheel {
    Rim rim;
    Tire tire;
    Spokes sp;

    public Wheel(Rim rim, Tire tire, Spokes sp) {
        this.rim = rim;
        this.tire = tire;
        this.sp = sp;
        
    }

    public Wheel() {
        this.rim = new Rim();
        this.tire = new Tire();
        this.sp = new Spokes();
    }

    @Override
    public String toString() {
        return "Wheel{" + "rim=" + rim + ", tire=" + tire + ", sp=" + sp + '}';
    }
    
    
}
