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
public class Bike {
    Brake brake;
    Chain chain;
    ChainWheel cw;
    Crank crank;
    Frame frame;
    HandleBar hb;
    Pedal pedal;
    Seat seat;
    Wheel frontWheel;
    Wheel backWheel;

    public Bike(Brake brake, Chain chain, ChainWheel cw, Crank crank, Frame frame, HandleBar hb, Pedal pedal, Seat seat, Wheel frontWheel, Wheel backWheel) {
        this.brake = brake;
        this.chain = chain;
        this.cw = cw;
        this.crank = crank;
        this.frame = frame;
        this.hb = hb;
        this.pedal = pedal;
        this.seat = seat;
        this.frontWheel = frontWheel;
        this.backWheel = backWheel;
    }

    @Override
    public String toString() {
        return "Bike{" + "brake=" + brake + ", chain=" + chain + ", cw=" + cw + ", crank=" + crank + ", frame=" + frame + ", hb=" + hb + ", pedal=" + pedal + ", seat=" + seat + ", frontWheel=" + frontWheel + ", backWheel=" + backWheel + '}';
    }

    
    
}
