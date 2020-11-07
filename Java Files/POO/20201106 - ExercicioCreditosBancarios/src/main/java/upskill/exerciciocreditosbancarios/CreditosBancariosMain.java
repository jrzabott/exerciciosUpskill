/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciocreditosbancarios;

/**
 *
 * @author user
 */
public class CreditosBancariosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CredHabitacao ch1 = new CredHabitacao("Daniel Junior", "Desempregado", 120000, 20, 500, 1);
        System.out.println(ch1.calcularMontanteJuros());
        System.out.println(ch1.calcularMontanteAReceberPorCadaCredito());

        CredAutomovel ca1 = new CredAutomovel("Daniel Junior", "Desempregado", 20000, 60, 500);
        System.out.println(ca1.calcularMontanteJuros());
        System.out.println(ca1.calcularMontanteAReceberPorCadaCredito());

        CredEducacao ce1 = new CredEducacao("Daniel Junior", "Desempregado", 18000, 60, 500);
        System.out.println(ce1.calcularMontanteJuros());
        System.out.println(ce1.calcularMontanteAReceberPorCadaCredito());
    }
}
