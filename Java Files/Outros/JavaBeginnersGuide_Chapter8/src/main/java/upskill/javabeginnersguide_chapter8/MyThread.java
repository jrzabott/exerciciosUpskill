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

    public MyThread(String threadName) {
        myThread = new Thread(this, threadName);
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
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                txt = String.format("In %s, count is %s.", myThread.getName(), i);
                System.out.println(txt);
            }
        } catch (InterruptedException e) {
            txt = String.format("%s interrupted!", myThread.getName());
            System.out.println(txt);
        }
        txt = String.format("%s terminating...", myThread.getName());
        System.out.println(txt);

    }

}
