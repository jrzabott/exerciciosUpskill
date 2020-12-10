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
public class MyThread implements Runnable {

    String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        String txt = String.format("%s starting...", this.threadName);
        System.out.println(txt);
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                txt = String.format("In %s, count is %s.", this.threadName, i);
                System.out.println(txt);
            }
        } catch (InterruptedException e) {
            txt = String.format("%s interrupted!", this.threadName);
            System.out.println(txt);
        }
        txt = String.format("%s terminating...", this.threadName);
        System.out.println(txt);

    }

}
