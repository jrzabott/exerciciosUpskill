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
                valorASerAmortizadoMes,
                taxaDeJurosAnual
        );
        this.taxaDeDescCredMenQue24Meses = taxaDeDescCredMenQue24Meses;
        countCredAuto++;
    }

    public CredAutomovel() {
        super();
        this.taxaDeDescCredMenQue24Meses = TAXA_DE_DESC_CRED_MEN_QUE_24_MESES_DEFAULT;
        countCredAuto++;
    }

    @Override
    public String toString() {
        return "CredAutomovel{" + "taxaDeDescCredMenQue24Meses=" + taxaDeDescCredMenQue24Meses + '}' + super.toString();
    }

    private double calcularMontanteJurosMes(double capitalDevido) {
        double txJurosMes = CreditosBancariosConsumo.getTaxaDeJurosAnual()
                / CreditosBancarios.FACTOR_PERCENTAGEM
                / CreditosBancarios.MESES_POR_ANO;
        double prestacaoMensal;

// THIS TEST IS TO KEEP IF THE INTEREST SHOULD BE APPLIED ONTO THE MONTHLY PAYMENTS.        
        if (getPrazoFinanciamentoMeses() <= getMesesParaAplicarDesconto()) {
            prestacaoMensal = ((capitalDevido * txJurosMes) + getValorASerAmortizadoMes()) * (1 - getTaxaDeDescCredMenQue24Meses() / FACTOR_PERCENTAGEM);
            System.out.println("Com Desconto de 1%:" + prestacaoMensal);
        } else {
            prestacaoMensal = (capitalDevido * txJurosMes) + getValorASerAmortizadoMes();
            System.out.println("Sem Desconto:" + prestacaoMensal);
        }

        return prestacaoMensal - getValorASerAmortizadoMes();
//        return capitalDevido * txJurosMes;
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
