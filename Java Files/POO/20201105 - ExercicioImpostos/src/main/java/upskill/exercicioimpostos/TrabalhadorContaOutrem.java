/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioimpostos;

/**
 *
 * @author user
 */
public class TrabalhadorContaOutrem extends ContribuinteComRT {

    private String nomeEmpresa;
    private final String NOME_EMPRESA_DEFAULT = "Where Judas Lost "
            + "His Boots Inc.";

    private static double taxaRT;
    private static double taxaOT = 0.02;
    private static double escalao = 30000.0;

    public TrabalhadorContaOutrem(String nomeEmpresa,
            double rendimentosRT, String nome,
            String morada, double rendimentosOutros) {
        super(rendimentosRT, nome, morada, rendimentosOutros);
        this.nomeEmpresa = nomeEmpresa;
    }

    public TrabalhadorContaOutrem() {
        super();
        this.nomeEmpresa = NOME_EMPRESA_DEFAULT;
    }

    @Override
    public double obterTaxaRT() {
        double result;
        if (this.getRendimentosRT() <= getEscalao()) {
            result = 0.01;
        } else {
            result = 0.02;
        }
        return result;
    }

    @Override
    public double obterTaxaOT() {
        return TrabalhadorContaOutrem.getTaxaOT();
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public static double getTaxaRT() {
        return taxaRT;
    }

    public static void setTaxaRT(double taxaRT1) {
        TrabalhadorContaOutrem.taxaRT = taxaRT1;
    }

    public static double getTaxaOT() {
        return taxaOT;
    }

    public static void setTaxaOT(double taxaOT) {
        TrabalhadorContaOutrem.taxaOT = taxaOT;
    }

    public static double getEscalao() {
        return escalao;
    }

    public static void setEscalao(double escalao) {
        TrabalhadorContaOutrem.escalao = escalao;
    }

}
