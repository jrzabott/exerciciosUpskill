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
public class CredAutomovel extends CreditosBancariosConsumo {

    private double taxaDeDescCredMenQue24Meses = 1.0;

    private static double taxaJurosAnual = 6.0;
    private static double mesesParaAplicarDesconto = 24.0;

    public CredAutomovel(
            String nomeCliente,
            String profissao,
            double montanteSolicitado,
            int prazoFinanciamentoMeses,
            double valorASerAmortizadoMes
    ) {
        super(
                nomeCliente,
                profissao,
                montanteSolicitado,
                prazoFinanciamentoMeses,
                valorASerAmortizadoMes
        );
    }

    public CredAutomovel() {
        super();
    }

    @Override
    public String toString() {
        return "CredAutomovel{" + "taxaDeDescCredMenQue24Meses=" + taxaDeDescCredMenQue24Meses + '}' + super.toString();
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
        while (montanteDevido > 0.0) {
            if (getPrazoFinanciamentoMeses() <= mesesParaAplicarDesconto) {
                somaJuros += (calcularMontanteJurosMes(montanteDevido) - (calcularMontanteJurosMes(montanteDevido) * 0.01));
            } else {
                somaJuros += calcularMontanteJurosMes(montanteDevido);
            }
            montanteDevido -= montanteMensalAmortizado;
//            System.out.println(somaJuros + " | " + montanteDevido);
        }
        return somaJuros;
    }

    @Override
    public double calcularMontanteAReceberPorCadaCredito() {
        return calcularMontanteJuros() + getMontanteSolicitado();
    }

    /**
     * @return the taxaDeDescCredMenQue24Meses
     */
    public double getTaxaDeDescCredMenQue24Meses() {
        return taxaDeDescCredMenQue24Meses;
    }

    /**
     * @return the mesesParaAplicarDesconto
     */
    public static double getMesesParaAplicarDesconto() {
        return mesesParaAplicarDesconto;
    }

    /**
     * @param taxaDeDescCredMenQue24Meses the taxaDeDescCredMenQue24Meses to set
     */
    public void setTaxaDeDescCredMenQue24Meses(double taxaDeDescCredMenQue24Meses) {
        this.taxaDeDescCredMenQue24Meses = taxaDeDescCredMenQue24Meses;
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

    /**
     * @param aMesesParaAplicarDesconto the mesesParaAplicarDesconto to set
     */
    public static void setMesesParaAplicarDesconto(double aMesesParaAplicarDesconto) {
        mesesParaAplicarDesconto = aMesesParaAplicarDesconto;
    }

}
