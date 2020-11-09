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


    public CreditosBancariosConsumo(
            String nomeCliente, 
            String profissao, 
            double montanteSolicitado, 
            int prazoFinanciamentoMeses, 
            double valorASerAmortizadoMes) {
        super(
                nomeCliente, 
                profissao, 
                montanteSolicitado, 
                prazoFinanciamentoMeses, 
                valorASerAmortizadoMes);
    }

    public CreditosBancariosConsumo() {
        super();
//        CreditosBancariosConsumo.taxaDeJurosAnual = TAXA_DE_JUROS_ANUAL_DEFAULT;

    }

    @Override
    public String toString() {
        return "CreditosBancariosConsumo{" + "taxaDeJurosAnual=" + getClass().getCanonicalName() + '}' + super.toString();
    }

    public static int getCountCredConsumo() {
        return CredEducacao.getCountCredEducacao() + CredAutomovel.getCountCredAuto();
    }

}
