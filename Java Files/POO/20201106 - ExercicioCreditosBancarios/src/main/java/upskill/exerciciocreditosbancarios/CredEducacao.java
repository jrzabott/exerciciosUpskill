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
public class CredEducacao extends CreditosBancariosConsumo {

    private double periodoDeCarencia = 24.0;

    private static double taxaJurosAnual = 2.0;

    public CredEducacao(String nomeCliente, String profissao, double montanteSolicitado, int prazoFinanciamentoMeses, double valorASerAmortizadoMes) {
        super(nomeCliente, profissao, montanteSolicitado, prazoFinanciamentoMeses, valorASerAmortizadoMes);
    }

    public CredEducacao() {
        super();
    }

    private double calcularMontanteJurosMes(double capitalDevido) {
        double txJurosMes = getTaxaJurosAnual()
                / CreditosBancarios.FACTOR_PERCENTAGEM
                / CreditosBancarios.MESES_POR_ANO;
        return capitalDevido * txJurosMes;
    }

    @Override
    public double calcularMontanteJuros() {
        double montanteDevido = getMontanteSolicitado();
        double somaJuros = 0.0;
        double montanteMensalAmortizado = getValorASerAmortizadoMes();

//        System.out.println(somaJuros + " | " + montanteDevido);
        int counter = 0;
        while (montanteDevido > 0.0) {
            somaJuros += calcularMontanteJurosMes(montanteDevido);
            if (counter >= periodoDeCarencia) {
                montanteDevido -= montanteMensalAmortizado;
            }
            counter++;
//            System.out.println(somaJuros + " | " + montanteDevido + " | " + counter);
        }
        return somaJuros;
    }

    @Override
    public double calcularMontanteAReceberPorCadaCredito() {
        return calcularMontanteJuros() + getMontanteSolicitado();

    }

    /**
     * @return the periodoDeCarencia
     */
    public double getPeriodoDeCarencia() {
        return periodoDeCarencia;
    }

    /**
     * @param periodoDeCarencia the periodoDeCarencia to set
     */
    public void setPeriodoDeCarencia(double periodoDeCarencia) {
        this.periodoDeCarencia = periodoDeCarencia;
    }

    /**
     * @return the taxaJurosAnual
     */
    public static double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    /**
     * @param aTaxaJurosAnual the taxaJurosAnual to set
     */
    public static void setTaxaJurosAnual(double aTaxaJurosAnual) {
        taxaJurosAnual = aTaxaJurosAnual;
    }

}
