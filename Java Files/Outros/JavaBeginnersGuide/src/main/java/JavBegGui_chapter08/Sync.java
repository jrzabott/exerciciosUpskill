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
public class Sync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        
        MyThreadSumArray mt1 = MyThreadSumArray.createAndStart("Child #1", a);
        MyThreadSumArray mt2 = MyThreadSumArray.createAndStart("Child #2", a);
        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
    
}
