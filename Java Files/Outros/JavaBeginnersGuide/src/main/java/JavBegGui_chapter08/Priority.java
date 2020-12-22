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
public class Priority implements Runnable {

    int count;
    Thread t;

    static boolean stop = false;
    static String currentName;

    public Priority(String name) {
        t = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s starting...", t.getName()));

        do {
            count++;

            if (currentName.compareTo(t.getName()) != 0) {
                currentName = t.getName();
                // System.out.println(String.format("In %s.", currentName));
            }
        } while (stop == false && count < 10_000_000);
        stop = true;

        System.out.println(String.format("%n%s terminating", t.getName()));
    }

}
