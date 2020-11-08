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
public class CredHabitacao extends CreditosBancarios {

    private double spread;

    private final double SPREAD_DEFAULT = 0;

    private static double taxaEuribor12meses = 0.1;
    private static int countCredHabitacao = 0;

    public CredHabitacao(
            String nomeCliente,
            String profissao,
            double montanteSolicitado,
            int prazoFinanciamentoMeses,
            double valorASerAmortizadoMes,
            double spread
    ) {
        super(
                nomeCliente,
                profissao,
                montanteSolicitado,
                prazoFinanciamentoMeses,
                valorASerAmortizadoMes
        );
        this.spread = spread;
        countCredHabitacao++;
    }

    public CredHabitacao() {
        super();
        this.spread = SPREAD_DEFAULT;
        countCredHabitacao++;
    }

    /**
     * @return the spread
     */
    public double getSpread() {
        return spread;
    }

    /**
     * @param spread the spread to set
     */
    public void setSpread(double spread) {
        this.spread = spread;
    }

    private double calcularJurosDoMes(double capitalEmDivida) {
        double taxaJurosMes = ((getTaxaEuribor12meses() + getSpread())
                / CreditosBancarios.FACTOR_PERCENTAGEM
                / CreditosBancarios.MESES_POR_ANO);
        double montanteJurosMes = capitalEmDivida * taxaJurosMes;
        return montanteJurosMes;
    }

    @Override
    public double calcularMontanteJuros() {
        double capitalCredito = getMontanteSolicitado();
        double somaJuros = 0.0;
        double montanteMensalAmortizado = getValorASerAmortizadoMes();
        while (capitalCredito > 0.0) {
            somaJuros += calcularJurosDoMes(capitalCredito);
            capitalCredito -= montanteMensalAmortizado;
        }
        return somaJuros;
    }

    @Override
    public double calcularMontanteAReceberPorCadaCredito() {
        return calcularMontanteJuros() + getMontanteSolicitado();
    }

    /**
     * @return the taxaEuribor12meses
     */
    public static double getTaxaEuribor12meses() {
        return taxaEuribor12meses;
    }
    /**
     * @return the countCredHabitacao
     */
    public static int getCountCredHabitacao() {
        return countCredHabitacao;
    }

    /**
     * @param aCountCredHabitacao the countCredHabitacao to set
     */
    public static void setCountCredHabitacao(int aCountCredHabitacao) {
        countCredHabitacao = aCountCredHabitacao;
    }
    /**
     * @param aTaxaEuribor12meses the taxaEuribor12meses to set
     */
    public static void setTaxaEuribor12meses(double aTaxaEuribor12meses) {
        taxaEuribor12meses = aTaxaEuribor12meses;
    }



}
