/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.lixo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class lixoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ArrayList<Double> myAL = new ArrayList<Double>();
//        ArrayList<Double> myAL = new ArrayList<Double>();
//        myAL.add(1.0);
//        myAL.add(10.0);
//        myAL.add(100.0);
//        myAL.add(103.0);
//        
//        
//        myAL.removeIf((t) -> {
//            return (t % 5 == 0);
//        });
//        System.out.println(myAL);
//System.out.println(null instanceof Object);
//System.out.println(null == myAL.getClass());
        int[] arr = {1, 12, 123, 1234, 1234567890};
        int[] newArray = new int[arr.length];
        int dig;

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = inverterNumero(arr[i]);
        }
        listar(newArray);

    }

    static int inverterNumero(int num) {
        int temp = num;
        int dig;
        String inverted = "";
        while (temp != 0) {
            dig = temp % 10;
            inverted += dig;
            temp /= 10;
        }
        return Integer.parseInt(inverted);
    }

    static void listar(int[] arr) {
        System.out.println("END ARRAY: ");
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }

}
