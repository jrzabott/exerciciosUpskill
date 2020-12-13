/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter8;

/**
 *
 * @author user
 */
public class PriorityDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");
        Priority mt3 = new Priority("Normal Priority #1");
        Priority mt4 = new Priority("Normal Priority #2");
        Priority mt5 = new Priority("Normal Priority #3");

        // setting priorities
        mt1.t.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.t.setPriority(Thread.NORM_PRIORITY - 2);
        
        // Let's leave mt3...mt5 with normal priority.
        
        // starting the threads
        mt1.t.start();
        mt2.t.start();
        mt3.t.start();
        mt4.t.start();
        mt5.t.start();
        
        try {
            mt1.t.join();
            mt2.t.join();
            mt3.t.join();
            mt4.t.join();
            mt5.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.print(String.format("%nHigh Priority thread counted to %d", mt1.count));
        System.out.print(String.format("%nLow Priority thread counted to %d", mt2.count));
        System.out.print(String.format("%n1st Normal Priority thread counted to %d", mt3.count));
        System.out.print(String.format("%n2nd Normal Priority thread counted to %d", mt4.count));
        System.out.print(String.format("%n3rd Normal Priority thread counted to %d", mt5.count));
    }
    
}
