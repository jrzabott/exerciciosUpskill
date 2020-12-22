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
public class QExcDemo {

    public static void main(String args[]) {
        FixedQueue q = new FixedQueue(10);
        int i;

        try {
            //overrun the queue
            for (int j = 0; j < 11; j++) {
                char tmpChar = (char) ('A' + j);
                System.out.printf("Attempting to store: %c", tmpChar);
                q.put(tmpChar);
                System.out.println(" - OK");
            }
            System.out.println("");
        } catch (QueueFullException e) {
            System.out.println(e);
        }
        System.out.println("");

        try {
            //over-empty the queue
            for (int j = 0; j < 11; j++) {
                System.out.printf("Getting next char: %c%n", q.get());

            }
        } catch (QueueEmptyException e) {
            System.out.println(e);
        }
    }
}
