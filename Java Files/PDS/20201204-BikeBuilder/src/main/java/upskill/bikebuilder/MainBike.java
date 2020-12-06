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
public class MainBike {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bike myBike = new BikeBuilder()
                .setBackWheel(new Wheel())
                .setFrontWheel(new Wheel())
                .setBrake(new Brake())
                .setChain(new Chain())
                .setCrank(new Crank())
                .setCw(new ChainWheel())
                .setFrame(new Frame())
                .setHb(new HandleBar())
                .setPedal(new Pedal())
                .setSeat(new Seat())
                .createBike();
        
        System.out.println(myBike);
    }
    
}
