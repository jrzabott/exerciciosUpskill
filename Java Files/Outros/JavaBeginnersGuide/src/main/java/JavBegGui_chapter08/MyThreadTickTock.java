package JavBegGui_chapter08;


import JavBegGui_chapter08.TickTock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class MyThreadTickTock implements Runnable{

    Thread thread;
    TickTock ttObj;
    
    // Construct a new thread.
    MyThreadTickTock(String name, TickTock tt) {
        thread = new Thread(this, name);
        ttObj = tt;
    }

    //A factory methos that creates and starts a thread
    public static MyThreadTickTock createAndStart(String name, TickTock tt){
        MyThreadTickTock myThreadTickTock = new MyThreadTickTock(name, tt);
        myThreadTickTock.thread.start();
        return myThreadTickTock;
    }
    
    @Override
    public void run() {
        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) {
                ttObj.tick(true);
            }
            ttObj.tick(false);
        } else {
            for (int i = 0; i < 5; i++) {
                ttObj.tock(true);
            }
            ttObj.tock(false);
        }
    }
    
}
