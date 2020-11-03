/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacaoalgoritmiaex2;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class AvaliacaoAlgoritmiaEx2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr; 
        Scanner ler = new Scanner(System.in); 
        int len;
        do {
            System.out.println("Entre com o tamanho do vetor (max.20): ");
            len = ler.nextInt();
        } while (!(len > 0 && len <= 20)); // CONFORME PROPOSTA DO EX, O NUMERO DEVE SER MAIOR QUE 0 E MENOR QUE 20
        
        arr = new int[len]; //ARR AGORA É INICIALIZADA COM O TAMANHO INFORMADO PELO UTILIZADOR
        for (int i = 0; i < len; i++) {
            System.out.print("Numero (" + i + "): ");
            arr[i] = ler.nextInt(); // ARMAZENAR OS len NUMEROS DESEJADOS PELO UTILIZADOR
        }
        
        int num = diferencaMaiorMenorVet(arr, arr.length); // CHAMA A FUNCAO SOLICITADA PARA ALINEA A)
        System.out.println(num);
    }

    private static int diferencaMaiorMenorVet(int[] arr, int n) {
        int max, min;
        if (n < 1) { // CASO UMA ARRAY COM COMPRIMENTO MENOR QUE 1 CHEGUE AQUI, APRESENTA ERRO, RETORNA -1 E SAI DA FUNÇÃO
            System.out.println("Comprimento de Vetor Inválido.");
            return -1;
        }
        max = arr[0]; //COMO NÃO É POSSÍVEL SABER SE A ARRAY CONTERÁ NUMEROS NEGATIVOS, O PRIMEIRO NUMERO DA ARRAY SERVIRÁ PARA COMPARAÇÃO.
        min = arr[0]; //COMO ACIMA.
        for (int i = 0; i < n; i++) {
            if (min > arr[i]) { //COMPARAR E SALVAR O VALOR MÍNIMO
                min = arr[i];
            }
            if (max < arr[i]) { // COMPARAR E SALVAR O VALOR MÁXIMO
                max = arr[i];
            }
        }
        return (max - min); // RETONAR A DISTÂNCIA (QUE NADA MAIS É QUE A DIFERENÇA) ENTRE O MÁXIMO E MŃIMO
        // [-2, 0, 3]
        // -2 --- -1 --- 0 --- 1 --- 2 --- 3
// DIST =   0......1.....2.....3.....4.....5 OU SEJA, (3 - (-2))  = 5
    }
    
}
