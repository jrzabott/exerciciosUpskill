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
public class TrabalhadorContaPropria extends ContribuinteComRT {

    private String profissao;
    
    private final String PROFISSAO_DEFAULT = "Vagabundo";
    
    private static double taxaRT = 0.03;
    private static double taxaOT;
    private static double escalao = 50000.0;

    public TrabalhadorContaPropria(String profissao, double rendimentosRT, String nome, String morada, double rendimentosOutros) {
        super(rendimentosRT, nome, morada, rendimentosOutros);
        this.profissao = profissao;
    }
    public TrabalhadorContaPropria() {
        super();
        this.profissao = PROFISSAO_DEFAULT;
    }

    
    
    /**
     * @return the taxaRT
     */
    public static double getTaxaRT() {
        return taxaRT;
    }

    /**
     * @return the taxaOT
     */
    public static double getTaxaOT() {
        return taxaOT;
    }

    /**
     * @return the escalao
     */
    public static double getEscalao() {
        return escalao;
    }

    /**
     * @param aTaxaRT the taxaRT to set
     */
    public static void setTaxaRT(double aTaxaRT) {
        taxaRT = aTaxaRT;
    }

    /**
     * @param aTaxaOT the taxaOT to set
     */
    public static void setTaxaOT(double aTaxaOT) {
        taxaOT = aTaxaOT;
    }

    /**
     * @param aEscalao the escalao to set
     */
    public static void setEscalao(double aEscalao) {
        escalao = aEscalao;
    }

    @Override
    public double obterTaxaOT() {
        double result;
        if (this.getRendimentosOT() <= escalao) {
            result = 0.02;
        } else {
            result = 0.05;
        }
        return result;
    }

    @Override
    public double obterTaxaRT(){
        return TrabalhadorContaOutrem.getTaxaRT();
    }

    /**
     * @return the profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * @param profissao the profissao to set
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    

}
