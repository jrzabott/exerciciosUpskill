/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotrabalhador;

/**
 *
 * @author user
 */
public class TrabalhadorTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] pecas = {4, 10};

        TrabalhadorPeca2 tpc2 = new TrabalhadorPeca2(pecas, "Janjão");
        TrabalhadorHora2 tch2 = new TrabalhadorHora2(160, 10, "Horácio Minutos");
        TrabalhadorComissao2 tcm2 = new TrabalhadorComissao2(635, 1700, 3.7, "Comissário Gordon");

        System.out.println(tpc2.calcularVencimento());
        System.out.println(tch2.calcularVencimento());
        System.out.println(tcm2.calcularVencimento());

    }

}
