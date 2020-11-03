/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5ex2Assincrono;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha5Ex2Assincrono {

    final private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[50];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lerInt();
        }
        mostrarMaiorEMenorEIndices(arr, arr.length);
    }

    private static int lerInt() {
        int num;
        System.out.print("Entre com o numero: ");
        do {
            num = s.nextInt();
            s.nextLine();
        } while (num < 0);

        return num;
    }

    private static void mostrarMaiorEMenorEIndices(int[] arr, int length) {
        int min, minI, max, maxI;
        max = 0;
        maxI = 0;
        min = arr[0];
        minI = 0;
        for (int i = 0; i < length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxI = i;
            }
            if (min > arr[i]) {
                min = arr[i];
                minI = i;
            }
        }
        if (length < 1) {
            System.out.println("Tamanho de Array Invalido.");
        } else {
            System.out.println("Menor Valor: " + min + " no índice: " + minI);
            System.out.println("Maior Valor: " + max + " no índice: " + maxI);
        }

    }
}
