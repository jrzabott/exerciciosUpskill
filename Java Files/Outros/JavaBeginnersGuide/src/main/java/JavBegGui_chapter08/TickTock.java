/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter08;

/**
 *
 * @author user
 */
// Use wait() and notify() too reate a ticking clock.
public class TickTock {

    String state;
    
    synchronized void tick(boolean running) {
        if (!running) { // stops the clock
            state = "ticked";
            notify(); // tick() notifies tock()
            return;
        }
        System.out.print("Tick ");
        
        state = "ticked"; // Set the current stsate to ticked
        notify(); // let tock() run
        
        try {
            while(!state.equals("tocked"))
                wait(); // wait for the tock() to complete <-- tick() waits for tock()
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted.");
        }
    }
    synchronized void tock(boolean running) {
        if (!running) { // stops the clock
            state = "tocked";
            notify(); // tock() notifies tick()
            return;
        }
        System.out.println("Tock");
        
        state = "tocked"; // Set the current stsate to ticked
        notify(); // let tock() run
        
        try {
            while(!state.equals("ticked"))
                wait(); // wait for the tock() to complete <-- tock() waits for tick()
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted.");
        }
    }
    
}
