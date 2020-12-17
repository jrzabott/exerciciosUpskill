/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter8;

enum TrafficLightColor {
    RED, GREEN, YELLOW
}

/**
 *
 * @author user
 */
public class TrafficLightSimulator implements Runnable {

    private TrafficLightColor tlc; // holds the traffic light color
    private boolean stop = false;
    private boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                switch (tlc) {
                    case GREEN:
                        Thread.sleep(10000); // green for 10 seconds
                        break;
                    case YELLOW:
                        Thread.sleep(2000); // yellow for 2 seconds
                        break;
                    case RED:
                        Thread.sleep(12000); // red for 12 seconds
                        break;
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            changeColor();
        }
    }

    // change color
    synchronized void changeColor() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }

        changed = true;
        notify();
    }

    //wait until a light change occurs.
    synchronized void waitForChange() {
        try {
            while (!changed) {
                wait(); // wait for light to change
            }
            changed = false;
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // return current color
    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    // stop the traffic light.
    synchronized void cancel() {
        stop = true;
    }
}
