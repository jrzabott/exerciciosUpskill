/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeQuickSort;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class testeQuickSort {

    final private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {1000, 50, 12, 23, 70};

        int part;
//        part = partition(arr, 0, arr.length - 1);
//        System.out.println(part + ": " + arr[part]);
//        System.out.println("");
//        System.out.println("");
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]: " + arr[i]);

        }

    }

    private static int partition(int[] arr, int beginOfArr, int endOfArr) {
        int countNewPivotPos = beginOfArr;
        int pivotElement = endOfArr; // vamos usar como pivot o fim da array;

        // Percorrer Array do começo ao fim
        for (int i = beginOfArr; i < endOfArr; i++) {
            if (arr[i] < arr[pivotElement]) {
                int tmp = arr[countNewPivotPos];
                // se o valor que estamos a ler é menor que o pivot selecionado, 
                // trocar este valor de posição para o começo da array (antes de onde ficará o pivot).
                // segmentamos assim a array em 2 metades (menos que o pivor e os maiores)
                arr[countNewPivotPos] = arr[i];
                arr[i] = tmp;
                countNewPivotPos++; // como existe numero menor que o pivot, contar quantos elemento ficarão à esquerda do pivor
                //para trocar o pivot de posiçao ao fim do for.
            }

        }
        // apos percorrer todo o array, vou trocar o pivot de posiçao com o primeiro numero maior que ele.
        // todos os numeros anteriores a esta posição são COM CTZ menores que o pivot
        int tmp = arr[pivotElement];
        arr[pivotElement] = arr[countNewPivotPos];
        arr[countNewPivotPos] = tmp;

        return countNewPivotPos;

    }

    public static void quickSort(int[] arr, int beginArr, int endArr) {
        if (endArr <= beginArr) {
            return;
        }
        int pivotElem = partition(arr, beginArr, endArr);
        quickSort(arr, beginArr, pivotElem - 1);
        quickSort(arr, pivotElem + 1, endArr);
    }
}
