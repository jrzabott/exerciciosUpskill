/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5ex3Assincrono;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha5Ex3Assincrono {

    final private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int len = 100;
        int[] arr;
        arr = new int[len];
        int num;

        num = lerInt();

        int usedArraySize = usedArraySize(arr, len, num);
        visualizarConteudoVetor(arr, usedArraySize);
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

    private static int usedArraySize(int[] arr, int len, int num) {
        int numLen = contarAlgorismos(num); //quantidade de algorismos do nº
        int num1 = num, dig; //copia do numero original;
        int countUsedArrPos = 0; //qtd de posições usadas na array.
        for (int i = numLen - 1; i >= 0; i--) {
            dig = num1 % 10;
            num1 /= 10;
            arr[i] = dig;
            countUsedArrPos++;
        }
        return countUsedArrPos;
    }

    private static void visualizarConteudoVetor(int[] arr, int usedArraySize) {
        System.out.print("Vetor: [");
        for (int i = 0; i < usedArraySize; i++) {
            System.out.print(arr[i]);
            if (i != usedArraySize - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].");
            }
        }
    }

    private static int contarAlgorismos(int num) {
        int num1 = num;
        int count = 0;
        while (num1 > 0) {
            num1 = num1 / 10;
            count++;
        }
        return count;
    }

}
