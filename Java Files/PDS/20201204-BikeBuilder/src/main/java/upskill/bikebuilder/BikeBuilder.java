/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.bikebuilder;


public class BikeBuilder {

    private Brake brake;
    private Chain chain;
    private ChainWheel cw;
    private Crank crank;
    private Frame frame;
    private HandleBar hb;
    private Pedal pedal;
    private Seat seat;
    private Wheel frontWheel;
    private Wheel backWheel;

    public BikeBuilder() {
    }

    public BikeBuilder setBrake(Brake brake) {
        this.brake = brake;
        return this;
    }

    public BikeBuilder setChain(Chain chain) {
        this.chain = chain;
        return this;
    }

    public BikeBuilder setCw(ChainWheel cw) {
        this.cw = cw;
        return this;
    }

    public BikeBuilder setCrank(Crank crank) {
        this.crank = crank;
        return this;
    }

    public BikeBuilder setFrame(Frame frame) {
        this.frame = frame;
        return this;
    }

    public BikeBuilder setHb(HandleBar hb) {
        this.hb = hb;
        return this;
    }

    public BikeBuilder setPedal(Pedal pedal) {
        this.pedal = pedal;
        return this;
    }

    public BikeBuilder setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }

    public BikeBuilder setFrontWheel(Wheel frontWheel) {
        this.frontWheel = frontWheel;
        return this;
    }

    public BikeBuilder setBackWheel(Wheel backWheel) {
        this.backWheel = backWheel;
        return this;
    }

    public Bike createBike() {
        return new Bike(brake, chain, cw, crank, frame, hb, pedal, seat, frontWheel, backWheel);
    }
    
}
