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
public abstract class CreditosBancariosConsumo extends CreditosBancarios {

    private static double taxaDeJurosAnual;

    private static final double TAXA_DE_JUROS_ANUAL_DEFAULT = 0.0;

    public CreditosBancariosConsumo(String nomeCliente, String profissao, double montanteSolicitado, int prazoFinanciamentoMeses, double valorASerAmortizadoMes, double taxaDeJurosAnual) {
        super(nomeCliente, profissao, montanteSolicitado, prazoFinanciamentoMeses, valorASerAmortizadoMes);
        this.taxaDeJurosAnual = taxaDeJurosAnual;
    }

    public CreditosBancariosConsumo() {
        super();
        this.taxaDeJurosAnual = TAXA_DE_JUROS_ANUAL_DEFAULT;

    }

    public static double getTaxaDeJurosAnual() {
        return taxaDeJurosAnual;
    }

    public static void setTaxaDeJurosAnual(double taxaDeJurosAnual) {
        CreditosBancariosConsumo.taxaDeJurosAnual = taxaDeJurosAnual;
    }

    @Override
    public String toString() {
        return "CreditosBancariosConsumo{" + "taxaDeJurosAnual=" + getClass().getCanonicalName() + '}' + super.toString();
    }

}
