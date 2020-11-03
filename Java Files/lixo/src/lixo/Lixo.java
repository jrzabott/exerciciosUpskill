/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lixo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Junior
 */
public class Lixo {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @@code intends to write the first thousand prime numbers to a file.
     */
    public static void main(String[] args) throws FileNotFoundException {
        
    }
//        int[] arr = {11, 12, 14, 16, 17, 19, 100};
//        int tmp, counter = 0;
//        for (int i = arr.length - 1; i >= arr.length / 2; i--) {
//            tmp = arr[counter];
//            arr[counter] = arr[i];
//            arr[i] = tmp;
//            counter++;
//        }
//        for (int i : arr) {
//            System.out.println(i);

//    private static void escreverPrimosEmFicheiro() throws FileNotFoundException {
//        Formatter fichPrimos = new Formatter(new File("1000primos.txt"));
//        for (int i = 0; i < 1000; i++) {
//            if(isPrime(i))
//                fichPrimos.format("%d%n", i);
//        }
//        fichPrimos.close();
//    }
//
//    private static boolean isPrime(int i) {
//        boolean result = true;
//        if (i <= 1) {
//            return !result;
//        }
//        if (i == 2) {
//            return result;
//        }
//        if(i % 2 == 0){
//            return !result;
//        }
//        for (int j = 3; j < Math.sqrt(i); j+=2) {
//            if(i % j == 0) {
//                return !result;
//            }
//        }
//        return result;
//    }
}
