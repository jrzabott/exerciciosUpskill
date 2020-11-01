/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6ex2sincrono;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha6Ex2Sincrono {

    private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        int[][] matrix = {
//            {1, 2, 5, 3},
//            {1, 2, 5, 3},
//            {1, 2, 5, 3},
//            {1, 2, 5, 3},
//            {1, 2, 5, 3}
//        };
//        
        int[][] matrix;
        System.out.println("Entre com o numero de Linhas e Colunas");
        int numRows = lerNumIntMenorQue("Linhas", 20);
        int numCols = lerNumIntMenorQue("Colunas", 30);
        matrix = new int[numRows][numCols];
        
        for (int row = 0; row < numRows; row++) {
            carregarVetor(matrix[row], matrix[row].length, row);
        }

        imprimirColunasMaiorMedia(matrix.length, matrix[0].length, matrix);
    }

// *****************************************************************************
//
//                        FUNÇÕES AUXILIARES
//
// *****************************************************************************
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

    private static void escreverLinha(int tmpCount, int[] row) {
        System.out.print("Linha(" + tmpCount + "): ");
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] + ", ");
        }
        System.out.println("");
    }

    private static int[] carregarVetor(int[] arr, int numCols, int row) {
        for (int col = 0; col < numCols; col++) {
            arr[col] = lerNumMatrix(row, col);
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

    private static int lerNumIntMenorQue(String msg, int maiorQue) {
        int num;
        do {
            System.out.print(msg + ": ");
            num = s.nextInt();
        } while (num < 1 || num > maiorQue);
        System.out.println("");
        return num;
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
    private static int lerNumMatrix(int row, int col) {
        int num;
            System.out.print(row + ","+col+": ");
            num = s.nextInt();
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

    private static void imprimirColunasMaiorMedia(int numRows, int numCols,
            int[][] matrix) {
        int soma = 0;
        double media;
        double maiorMedia = maiorMedia(matrix);
        for (int col = 0; col < numCols; col++) {
            if (mediaColuna(matrix, col) == maiorMedia) {
                escreveColuna(matrix, col);
            }

        }
    }

    private static double mediaColuna(int[][] matrix, int col) {
        double media, soma = 0;
        for (int row = 0; row < matrix.length; row++) {
            soma += matrix[row][col];
        }
        media = (double) soma / matrix[0].length;
        return media;
    }

    private static double maiorMedia(int[][] matrix) {
        double maiorMedia;
        double media;
        double soma = 0;
        maiorMedia = mediaColuna(matrix, 0);
        for (int col = 0; col < matrix[0].length; col++) {
            for (int[] row : matrix) {
                soma += row[col];
            }
            media = soma / matrix.length;
            if (media > maiorMedia) {
                maiorMedia = media;
            }
            soma = 0;
        }
        return maiorMedia;
//        for (int col = 0; col < numCols; col++) {
//            for (int row = 0; row < numRows; row++) {
//                soma += matrix[row][col];
//            }
//            media = (double) soma / numRows;
//            if (maiorMedia < media) {
//                maiorMedia = media;
//            }
//            soma = 0;
//        }
//        return maiorMedia;
    }

    private static void escreveColuna(int[][] matrix, int col) {
        for (int row = 0; row < matrix[col].length; row++) {
            System.out.println(matrix[row][col]);
        }
    }

}
