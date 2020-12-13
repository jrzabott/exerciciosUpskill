/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ExtendThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main thread starting");
        
        ExtendedThread et = new ExtendedThread("Child #1");
                
                et.start();
                
                for (int i = 0; i < 50; i++) {
                System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Main thread interrupted!");
            }
        }
                System.out.println("Main thread ending...");
    }
    
}
