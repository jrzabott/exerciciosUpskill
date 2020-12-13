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
public class MoreThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main thread starting...");

        MyThread mt1 = MyThread.createAndStart("Child #1");
        MyThread mt2 = MyThread.createAndStart("Child #2");
        MyThread mt3 = MyThread.createAndStart("Child #3");

// Basic way to do it.
//        for (int i = 0; i < 50; i++) {
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.println("Main thread interrupted.");
//            }
//        }
// Checking is MyThread.isAlive()
//        do {
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.println("Main thread interrupted.");
//            }
//        } while (
//                mt1.myThread.isAlive()
//                || mt2.myThread.isAlive()
//                || mt3.myThread.isAlive()
//                );
// Checking if the thread "joined" the main thread.
        try {
            mt1.myThread.join();
            System.out.println("Child #1 joined.");
            mt2.myThread.join();
            System.out.println("Child #2 joined.");
            mt3.myThread.join();
            System.out.println("Child #3 joined.");
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted.");
        }
        

        System.out.println("Main thread ending.");
    }

}
