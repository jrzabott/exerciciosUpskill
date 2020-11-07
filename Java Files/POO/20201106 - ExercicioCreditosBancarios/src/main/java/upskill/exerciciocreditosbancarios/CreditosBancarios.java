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
public abstract class CreditosBancarios {

    private String nomeCliente;
    private String profissao;
    private double montanteSolicitado;
    private int prazoFinanciamentoMeses;
    private double valorASerAmortizadoMes;

    private final String NOME_CLIENTE_DEFAULT = "XXX";
    private final String PROFISSAO_DEFAULT = "YYY";
    private final double MONTANTE_SOLICITADO_DEFAULT = 0.0;
    private final int PRAZO_FINANCIAMENTO_MESES_DEFAULT = 0;
    private final double VALOR_A_SER_AMORIZADO_MES_DEFAULT = 0.0;

    private static int countCreditosBancarios = 0;

    public static final double FACTOR_PERCENTAGEM = 100.0;
    public static final double MESES_POR_ANO = 12.0;

    /**
     *
     * @param nomeCliente
     * @param profissao
     * @param montanteSolicitado
     * @param prazoFinanciamentoMeses
     * @param valorASerAmortizadoMes
     */
    public CreditosBancarios(String nomeCliente, String profissao,
            double montanteSolicitado, int prazoFinanciamentoMeses,
            double valorASerAmortizadoMes) {
        this.nomeCliente = nomeCliente;
        this.profissao = profissao;
        this.montanteSolicitado = montanteSolicitado;
        this.prazoFinanciamentoMeses = prazoFinanciamentoMeses;
        this.valorASerAmortizadoMes = valorASerAmortizadoMes;

        CreditosBancarios.countCreditosBancarios++;
    }

    /**
     * Empty Constructor
     */
    public CreditosBancarios() {
        this.nomeCliente = NOME_CLIENTE_DEFAULT;
        this.profissao = PROFISSAO_DEFAULT;
        this.montanteSolicitado = MONTANTE_SOLICITADO_DEFAULT;
        this.prazoFinanciamentoMeses = PRAZO_FINANCIAMENTO_MESES_DEFAULT;
        this.valorASerAmortizadoMes = VALOR_A_SER_AMORIZADO_MES_DEFAULT;

        CreditosBancarios.countCreditosBancarios++;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @return the montanteSolicitado
     */
    public double getMontanteSolicitado() {
        return montanteSolicitado;
    }

    /**
     * @return the prazoFinanciamentoMeses
     */
    public int getPrazoFinanciamentoMeses() {
        return prazoFinanciamentoMeses;
    }

    /**
     * @return the valorASerAmortizadoMes
     */
    public double getValorASerAmortizadoMes() {
        return valorASerAmortizadoMes;
    }

    /**
     * @param valorASerAmortizadoMes the valorASerAmortizadoMes to set
     */
    public void setValorASerAmortizadoMes(double valorASerAmortizadoMes) {
        this.valorASerAmortizadoMes = valorASerAmortizadoMes;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * @param montanteSolicitado the montanteSolicitado to set
     */
    public void setMontanteSolicitado(double montanteSolicitado) {
        this.montanteSolicitado = montanteSolicitado;
    }

    /**
     * @param prazoFinanciamentoMeses the prazoFinanciamentoMeses to set
     */
    public void setPrazoFinanciamentoMeses(int prazoFinanciamentoMeses) {
        this.prazoFinanciamentoMeses = prazoFinanciamentoMeses;
    }

    /**
     * @return the countCreditosBancarios
     */
    public static int getCountCreditosBancarios() {
        return countCreditosBancarios;
    }

    @Override
    public String toString() {
        return "CreditosBancarios{" + "nomeCliente=" + nomeCliente + ", profissao=" + profissao + ", montanteSolicitado=" + montanteSolicitado + ", prazoFinanciamentoMeses=" + prazoFinanciamentoMeses + '}';
    }

    /**
     *
     * @return
     */
    public abstract double calcularMontanteJuros();

    /**
     *
     * @return
     */
    public abstract double calcularMontanteAReceberPorCadaCredito();

}
