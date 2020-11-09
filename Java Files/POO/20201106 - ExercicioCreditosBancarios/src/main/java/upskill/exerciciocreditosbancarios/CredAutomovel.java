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
    private double taxaDeJurosAnual;

    private final double TAXA_DE_JUROS_ANUAL_DEFAULT = 0.0;
    private final double TAXA_DE_DESC_CRED_MEN_QUE_24_MESES_DEFAULT = 1.0;

    private static double mesesParaAplicarDesconto = 24.0;
    private static int countCredAuto = 0;

    public CredAutomovel(
            String nomeCliente,
            String profissao,
            double montanteSolicitado,
            int prazoFinanciamentoMeses,
            double valorASerAmortizadoMes,
            double taxaDeJurosAnual,
            double taxaDeDescCredMenQue24Meses
    ) {
        super(
                nomeCliente,
                profissao,
                montanteSolicitado,
                prazoFinanciamentoMeses,
                valorASerAmortizadoMes
        );
        this.taxaDeDescCredMenQue24Meses = taxaDeDescCredMenQue24Meses;
        this.taxaDeJurosAnual = taxaDeJurosAnual;
        countCredAuto++;
    }

    public CredAutomovel() {
        super();
        this.taxaDeDescCredMenQue24Meses = TAXA_DE_DESC_CRED_MEN_QUE_24_MESES_DEFAULT;
        this.taxaDeJurosAnual = TAXA_DE_JUROS_ANUAL_DEFAULT;
        countCredAuto++;
    }

    @Override
    public String toString() {
        return "CredAutomovel{" + "taxaDeDescCredMenQue24Meses=" + taxaDeDescCredMenQue24Meses + '}' + super.toString();
    }

    private double calcularMontanteJurosMes(double capitalDevido) {
        double txJurosMes = getTaxaDeJurosAnual()
                / CreditosBancarios.FACTOR_PERCENTAGEM
                / CreditosBancarios.MESES_POR_ANO;
        double prestacaoMensal;

// THIS TEST IS TO KEEP IF THE INTEREST SHOULD BE APPLIED ONTO THE MONTHLY PAYMENTS.        
        if (getPrazoFinanciamentoMeses() <= getMesesParaAplicarDesconto()) {
            prestacaoMensal = ((capitalDevido * txJurosMes) + getValorASerAmortizadoMes()) * (1 - getTaxaDeDescCredMenQue24Meses() / FACTOR_PERCENTAGEM);
        } else {
            prestacaoMensal = (capitalDevido * txJurosMes) + getValorASerAmortizadoMes();
        }

        return prestacaoMensal - getValorASerAmortizadoMes();
    }

    @Override
    public double calcularMontanteJuros() {
        double montanteDevido = getMontanteSolicitado();
        double somaJuros = 0.0;
        double montanteMensalAmortizado = getValorASerAmortizadoMes();

//        System.out.println(somaJuros + " | " + montanteDevido);
        while (montanteDevido > 0.0) {
// IF THE DISCOUNT IS ABOVE THE INTEREST, OTHERWISE KEEP TEST ABOVE
//            if (getPrazoFinanciamentoMeses() <= mesesParaAplicarDesconto) {
//                somaJuros += (calcularMontanteJurosMes(montanteDevido) - (calcularMontanteJurosMes(montanteDevido) * 0.01));
//            } else {
//                somaJuros += calcularMontanteJurosMes(montanteDevido);
//            }
            somaJuros += calcularMontanteJurosMes(montanteDevido);
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
     * @return the mesesParaAplicarDesconto
     */
    public static double getMesesParaAplicarDesconto() {
        return mesesParaAplicarDesconto;
    }

    /**
     * @return the countCredAuto
     */
    public static int getCountCredAuto() {
        return countCredAuto;
    }

    /**
     * @param aCountCredAuto the countCredAuto to set
     */
    public static void setCountCredAuto(int aCountCredAuto) {
        countCredAuto = aCountCredAuto;
    }

    /**
     * @param taxaDeDescCredMenQue24Meses the taxaDeDescCredMenQue24Meses to set
     */
    public void setTaxaDeDescCredMenQue24Meses(double taxaDeDescCredMenQue24Meses) {
        this.taxaDeDescCredMenQue24Meses = taxaDeDescCredMenQue24Meses;
    }

    /**
     * @param aMesesParaAplicarDesconto the mesesParaAplicarDesconto to set
     */
    public static void setMesesParaAplicarDesconto(double aMesesParaAplicarDesconto) {
        mesesParaAplicarDesconto = aMesesParaAplicarDesconto;
    }

}
