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
public class ExtendedThread extends Thread{

    public ExtendedThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println(String.format("In %s, count is %d", getName(), i));
            }
        } catch (Exception e) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " terminanting...");
    }
    
    
    
}
