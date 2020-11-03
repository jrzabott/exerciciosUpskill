/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6ex1assicrono;

/**
 *
 * @author user
 */
public class Fich6Ex1Assicrono {

    public static void main(String[] args) {
        int[][] vet = {
            {1, 2, 3, 4},
            {-4, -1, -2, -3},
            {100, 400, 300, 200},
            {0, 0, 0, 0},
            {4, 3, 2, 1}
        };
        int numRow, numCol;
        numRow = 5;
        numCol = 4;

        imprimirMaiorNumeroLinha(vet, numRow, numCol);
    }

    private static void imprimirMaiorNumeroLinha(int[][] vet, int numRow, int numCol) {
        int maiorElemLinha;
        for (int row = 0; row < vet.length; row++) {
            maiorElemLinha = buscarMaiorElementoLinha(vet[row]);
            System.out.println("Maior Elem da Linha " + row + ": " + maiorElemLinha);
        }

    }

    private static int buscarMaiorElementoLinha(int[] arr) {
        //  {1, 2, 3, 4}
        int maiorElem = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maiorElem) {
                maiorElem = arr[i];
            }
        }
        return maiorElem;
    }

}
