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
public class EnumTest {

    enum Transport {
        CAR, TRUCK, AIRPLANE, TRAIN, BOAT
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transport tp, tp2, tp3;

        //Obtain all ordinal values using ordinal()
        System.out.println("Here are all Transport constants and their orginal values: ");
        for (Transport t : Transport.values()) {
            System.out.println(t + " " + t.ordinal());
        }
        tp = Transport.AIRPLANE;
        tp2 = Transport.TRAIN;
        tp3 = Transport.AIRPLANE;

        System.out.println();

        // Demonstrato CompareTo()
        if (tp.compareTo(tp2) < 0) {
            System.out.println(tp + " comes before " + tp2);
        }
        if (tp.compareTo(tp2) > 0) {
            System.out.println(tp2 + " comes before " + tp);
        }
        if (tp.compareTo(tp3) == 0) {
            System.out.println(tp + " equals " + tp3);
        }
    }

}
