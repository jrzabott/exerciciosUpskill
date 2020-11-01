/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha6ex2assincrono;

/**
 *
 * @author user
 */
public class Ficha6Ex2Assincrono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] arr = {
            {1, 2, 3, 4},
            {-4, -1, -2, -3},
            {100, 400, 300, 200},
            {0, 0, 0, 0},
//            {4, 3, 2, 1}
        };
        double soma =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
//                if (i == j) {
//                if (i + j == 3)
                    System.out.print(i + "," + j + "=" + arr[i][j] + "\t");
                    soma += arr[i][j];
//                }
            }
            System.out.println("");
        }
//        int numElem = arr.length;
//        System.out.println("media da diag principal = " + (soma / numElem));
    }
    

}

//    1   2   3   4
//1   10  20  30  40  = (10 + 2 + 4 +1) / 4 = 17 / 4 = 4.25
//2   1   2   3   4
//3   2   3   4   8
//4   1   1   1   1
