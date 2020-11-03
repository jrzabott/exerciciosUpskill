/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5ex4Assincrono;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha5Ex4Assincrono {

    final private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros = new int[5];
        int[] estrelas = new int[2];

        numeros = gerarChaves(numeros.length, 1, 50);
        estrelas = gerarChaves(2, 1, 12);

        visualizarChave(numeros, "Numeros");
        visualizarChave(estrelas, "Estrelas");
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

    private static int[] gerarChaves(int length, int min, int max) {
        int[] chave = new int[length];
        for (int i = 0; i < length; i++) {
            chave[i] = (int)(Math.random() * ((double)max - (double)min + 1.0) + (double)min);
        }
        return chave;
    }

    private static void visualizarChave(int[] arr, String legenda) {
        System.out.print(legenda +": [");
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].");
            }
        }
    }
    
    static int partition(int[] array, int begin, int end) {
    int pivot = end;

    int counter = begin;
    for (int i = begin; i < end; i++) {
        if (array[i] < array[pivot]) {
            int temp = array[counter];
            array[counter] = array[i];
            array[i] = temp;
            counter++;
        }
    }
    int temp = array[pivot];
    array[pivot] = array[counter];
    array[counter] = temp;

    return counter;
}

public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot-1);
    quickSort(array, pivot+1, end);
}
}
