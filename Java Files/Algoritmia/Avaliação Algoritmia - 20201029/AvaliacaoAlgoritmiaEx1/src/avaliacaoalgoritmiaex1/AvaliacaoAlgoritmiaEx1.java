/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacaoalgoritmiaex1;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class AvaliacaoAlgoritmiaEx1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); //PREPARAR O SCANNER PARA LER A ENTRADA DO TECLADO

        int num, copiaNum; // VARIAVEL QUE IRÁ RECEBER A TESTAR SE É MUNCHHAUSEN
        do {
            System.out.print("Numero: ");
            num = ler.nextInt(); // LER O NUMERO DO TECLADO PARA A VARIÁVEL num
        } while (num < 0); // SÓ AVANÇA SE O NUMERO É POSITIVO E INTEIRO
        copiaNum = num; // SALVO O VALOR PARA TESTAR AO FINAL, E.G. (3435)

        int dig, munchhausen = 0; // VARIAVEIS DE "APOIO"
        while (num > 0) {
            dig = num % 10; // DIG = AO ULTIMO ALGORISMO DO NUMERO, E.G.: (5)
            num = num / 10; // NUM = AOS OUTROS ALGORISMO, E.G.: (343)
            munchhausen += (Math.pow(dig, dig)); // OPERACAO MATEMÁTICA QUE CARACTERIZA OS NUMEROS DE MUNCHHAUSEN.
        }
        if (munchhausen == copiaNum) { //TESTA SE É MUNCHHAUSEN OU NÃO
            System.out.println("É Munchhausen.");
        } else {
            System.out.println("Não é Munchhausen.");
        }
    }

}
