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
public class ThreadVariations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main thread starting...");
        
        // Create and starts a thread;
        MyThread mt = MyThread.createAndStart("Child #1");
        
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Main thread interrupted!");
            }
        }
            System.out.println("Main Thread Ending...");
    }
    
}
