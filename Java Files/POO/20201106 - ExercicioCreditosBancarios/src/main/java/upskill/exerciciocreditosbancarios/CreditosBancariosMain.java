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
        /*
           a) Criação do seguinte conjunto de instâncias:
               - 2 créditos à habitação;
               - 2 créditos automóvel;
               - 2 créditos à educação;
        */

        CredHabitacao ch1 = new CredHabitacao("Daniel Junior", "Desempregado", 120000, 20, 500, 1);
        System.out.println(ch1.calcularMontanteJuros());
        System.out.println(ch1.calcularMontanteAReceberPorCadaCredito());

        CredHabitacao ch2 = new CredHabitacao("Junior Daniel", "Desempregado", 240000, 40, 6000, 1);
        System.out.println(ch2.calcularMontanteJuros());
        System.out.println(ch2.calcularMontanteAReceberPorCadaCredito());

        CredAutomovel ca1 = new CredAutomovel("Daniel Afranio", "Desempregado", 30000, 60, 500, 6, 1);
        System.out.println(ca1.calcularMontanteJuros());
        System.out.println(ca1.calcularMontanteAReceberPorCadaCredito());

        CredAutomovel ca2 = new CredAutomovel("Junior", "Desempregado", 20000, 20, 1000, 6, 1);
        System.out.println(ca2.calcularMontanteJuros());
        System.out.println(ca2.calcularMontanteAReceberPorCadaCredito());

        CredEducacao ce1 = new CredEducacao("Daniel Junior", "Desempregado", 18000, 60, 500, 2, 24);
        System.out.println(ce1.calcularMontanteJuros());
        System.out.println(ce1.calcularMontanteAReceberPorCadaCredito());

        CredEducacao ce2 = new CredEducacao("Junior", "Desempregado", 36000, 60, 600, 2, 24);
        System.out.println(ce2.calcularMontanteJuros());
        System.out.println(ce2.calcularMontanteAReceberPorCadaCredito());
        

        /*
            b) Criação de um contentor do tipo array e armazenamento no mesmo das instâncias criadas;
        */ 
        CreditosBancarios[] cb = new CreditosBancarios[10];
        cb[0] = ch1;
        cb[1] = ch2;
        cb[2] = ca1;
        cb[3] = ca2;
        cb[4] = ce1;
        cb[5] = ce2;

        /*
            c)  Criação de listagens separadas, sobre o contentor, para:
                obter o nome do cliente e o valor que a instituição bancária irá receber até ao final
                de cada contrato de crédito ao consumo realizado;
                obter o nome do cliente e o valor dos juros (para além do montante do empréstimo)
                que o cliente terá de pagar até ao final de cada contrato de crédito bancário
                realizado;
        
        */
        
    }
