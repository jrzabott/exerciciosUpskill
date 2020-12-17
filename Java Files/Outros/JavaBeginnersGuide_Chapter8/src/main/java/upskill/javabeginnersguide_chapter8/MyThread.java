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
// Variation of MyThread. This version creates a Thread when its constructor is 
// called and stores it in an instance variable called myThread.
// Sets the name of the thread and provides a factory method to create and start
// a thread.
public class MyThread implements Runnable {
    Thread myThread;
    boolean suspended, stopped;

    public MyThread(String name) {
        myThread = new Thread(this, name);
        suspended = stopped = true;
    }

    // Factory method that creates and start a thread.
    public static MyThread createAndStart(String name){
        MyThread mt = new MyThread(name);
        mt.myThread.start();
        return mt;
    }
    //Entry point of the thread.
    @Override
    public void run() {
        String txt = String.format("%s starting...", myThread.getName());
        System.out.println(txt);
        try {
            for (int i = 0; i < 1000; i++) {
                txt = String.format("%d ", i);
                System.out.print(txt);
                if (i % 10 == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }
                
                // Use synchronized block fo check suspended and stopped.
                synchronized(this){
                    while (suspended) {                        
                        wait();
                    }
                    if (stopped) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            txt = String.format("%s interrupted!", myThread.getName());
            System.out.println(txt);
        }
        txt = String.format("%s terminating...", myThread.getName());
        System.out.println(txt);
    }

    // stop the thread
    synchronized void myStop(){
        stopped = true;
        
        // ensures a suspended thread can be stopped.
        suspended = false;
        notify();
    }
    
    //suspend the thread.
    synchronized void mySuspend(){
        suspended = true;
    }
    
    // resume the thread
    synchronized void myResume(){
        suspended = false;
        notify();
    }
}
