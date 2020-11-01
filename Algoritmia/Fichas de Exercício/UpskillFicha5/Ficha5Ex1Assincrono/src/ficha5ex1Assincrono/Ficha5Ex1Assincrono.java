/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5ex1Assincrono;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha5Ex1Assincrono {

    final private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[50];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lerInt();
        }

        double media = calcularMediaVetor(arr, arr.length);

        System.out.println("Média: " + String.format("%,.2f", media));
    }

    private static double calcularMediaVetor(int[] arr, int length) {
        double result = 0.0;
        double soma = 0;
        for (int i = 0; i < length; i++) {
            soma += arr[i];
        }
        if (length > 0) {
            result = soma / length;
        } else {
            result = 0;
        }
        return result;
    }

    private static int lerInt() {
        int num;
        System.out.print("Entre com o numero: ");
        do {
            num = s.nextInt();
        } while (num < 0);

        return num;
    }

}
