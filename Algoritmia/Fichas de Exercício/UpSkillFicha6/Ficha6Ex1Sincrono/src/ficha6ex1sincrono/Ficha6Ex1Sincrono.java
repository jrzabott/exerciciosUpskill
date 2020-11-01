/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6ex1sincrono;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha6Ex1Sincrono {

    private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        int[][] matrix = {
//            {1, 1, 1, 1},
//            {2, 2, 2, 6},
//            {3, 3, 7, 7},
//            {4, 9, 9, 9}
//        };
//        
        int[][] matrix;
        System.out.println("Entre com o numero de Linhas e Colunas");
        int numRows = lerNumInt("Linhas");
        int numCols = lerNumInt("Colunas");
        matrix = new int[numRows][numCols];

        imprimirLinhasComMaisPares(numRows, numCols, matrix);
    }

    private static void imprimirLinhasComMaisPares(int numRows, int numCols, 
            int[][] matrix) {
        // LER ELEMENTOS DA MATRIZ
        for (int[] thisRow : matrix) {
            for (int i = 0; i < thisRow.length; i++) {
                thisRow[i] = lerNumInt();
            }
        }
        int contaPares = 0;
        int maiorQtdPares = 0;
        // IDENTIFICA QUAL A MAIOR QUANTIDADE DE PARES EM UMA LINHA.
        for (int[] row : matrix) {
            contaPares = contaPares(row);
            if (maiorQtdPares < contaPares) {
                maiorQtdPares = contaPares;
            }
        }
        int tmpCount = 0; //conta o índice da linha que tem "mais pares".
        // MARCAR A ESCREVER A LINHA QUE TEM NO Nº DE PARES = AO MAIOR Nº DE PARES.
        for (int[] row : matrix) {
            if (contaPares(row) == maiorQtdPares) {
                escreverLinha(tmpCount, row);
            }
            tmpCount++;
        }
    }

// *****************************************************************************
//
//                        FUNÇÕES AUXILIARES
//
// *****************************************************************************
    private static void escreverLinha(int tmpCount, int[] row) {
        System.out.print("Linha(" + tmpCount + "): ");
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] + ", ");
        }
        System.out.println("");
    }

    private static int[] carregarVetor(int[] arr, int qtNum) {
        for (int i = 0; i < qtNum; i++) {
            arr[i] = lerNumInt();
        }
        return arr;
    }

    private static void printVetor(int[] arr) {
        System.out.print("arr: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("].\n");
            }
        }
    }

    private static int lerNumInt(String msg) {
        int num;
        do {
            System.out.print(msg + ": ");
            num = s.nextInt();
        } while (num < 0);
        System.out.println("");
        return num;
    }

    private static int lerNumInt() {
        int num;
        do {
            System.out.print("Entre com o nº int e positivo: ");
            num = s.nextInt();
        } while (num < 0);
        return num;
    }

    private static int contaPares(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
