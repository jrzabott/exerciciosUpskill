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
public class ThreadCom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThreadTickTock mt1 = MyThreadTickTock.createAndStart("Tick", tt);
        MyThreadTickTock mt2 = MyThreadTickTock.createAndStart("Tock", tt);
        
        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}
