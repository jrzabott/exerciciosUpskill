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

    private double periodoDeCarencia;
    private double taxaDeJurosAnual;

    private final double TAXA_DE_JUROS_ANUAL_DEFAULT = 0.0;
    private final double PERIODO_DE_CARENCIA_DEFAULT = 24.0;

    private static int countCredEducacao = 0;

//    public CredEducacao(String nomeCliente, String profissao, double montanteSolicitado, int prazoFinanciamentoMeses, double valorASerAmortizadoMes, double taxaDeJurosAnual, double periodoDeCarencia) {
//        super(nomeCliente, profissao, montanteSolicitado, prazoFinanciamentoMeses, valorASerAmortizadoMes, taxaDeJurosAnual);
//        this.periodoDeCarencia = periodoDeCarencia;
//        countCredEducacao++;
//    }
    public CredEducacao(String nomeCliente, String profissao, double montanteSolicitado, int prazoFinanciamentoMeses, double valorASerAmortizadoMes,  double taxaDeJurosAnual, double periodoDeCarencia) {
        super(nomeCliente, profissao, montanteSolicitado, prazoFinanciamentoMeses, valorASerAmortizadoMes);
        this.taxaDeJurosAnual = taxaDeJurosAnual;
        this.periodoDeCarencia = periodoDeCarencia;
        countCredEducacao++;
    }

    public CredEducacao() {
        super();
        this.periodoDeCarencia = PERIODO_DE_CARENCIA_DEFAULT;
        countCredEducacao++;
    }

    private double calcularMontanteJurosMes(double capitalDevido) {
        double txJurosMes = getTaxaDeJurosAnual()
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
     * @return the taxaDeJurosAnual
     */
    public double getTaxaDeJurosAnual() {
        return taxaDeJurosAnual;
    }

    /**
     * @param taxaDeJurosAnual the taxaDeJurosAnual to set
     */
    public void setTaxaDeJurosAnual(double taxaDeJurosAnual) {
        this.taxaDeJurosAnual = taxaDeJurosAnual;
    }
    /**
     * @param periodoDeCarencia the periodoDeCarencia to set
     */
    public void setPeriodoDeCarencia(double periodoDeCarencia) {
        this.periodoDeCarencia = periodoDeCarencia;
    }

    /**
     * @return the countCredEducacao
     */
    public static int getCountCredEducacao() {
        return countCredEducacao;
    }

    /**
     * @param aCountCredEducacao the countCredEducacao to set
     */
    public static void setCountCredEducacao(int aCountCredEducacao) {
        countCredEducacao = aCountCredEducacao;
    }

}
