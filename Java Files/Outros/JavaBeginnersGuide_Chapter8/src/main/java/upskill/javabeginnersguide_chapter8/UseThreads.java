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
public class UseThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main thread starting...");
        
        // First: construct the MyThread object
        MyThread mt = new MyThread("Child #1");
        
        // Next, construct a thread from that object.
        Thread newThread = new Thread(mt);
        
        // FInally, start execution of the thread.
        newThread.start();
        
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Main Thread Interrupted!");
            }
        }
        System.out.println("Main Thread Ending.");
    }
    
}
