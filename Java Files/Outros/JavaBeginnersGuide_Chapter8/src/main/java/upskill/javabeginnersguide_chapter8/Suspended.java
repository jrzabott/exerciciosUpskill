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
public class Suspended {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyThread mt1 = MyThread.createAndStart("My Thread");

        try {
            Thread.sleep(1500); // let ob1 thread start executing
            
            mt1.mySuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1500); // let ob1 thread start executing
            
            mt1.myResume();
            System.out.println("Resuming thread.");
            Thread.sleep(1500); // let ob1 thread start executing
            
            mt1.mySuspend();
            System.out.println("Suspending thread (again).");
            Thread.sleep(1500); // let ob1 thread start executing
            
            mt1.myResume();
            System.out.println("Resuming thread.");
            Thread.sleep(1500); // let ob1 thread start executing
            
            mt1.mySuspend();
            System.out.println("Stopping thread.");
            mt1.myStop();
            
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        // wait for thread to finish
        try {
            mt1.myThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("Main thread exiting...");
    }

}
