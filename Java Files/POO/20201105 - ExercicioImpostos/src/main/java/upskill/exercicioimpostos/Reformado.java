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
public class Reformado extends ContribuinteComRT {

    private static double taxaRT = 0.01;
    private static double taxaOR = 0.03;

    public Reformado(double rendimentosRT, String nome, 
            String morada, double rendimentosOutros) {
        super(rendimentosRT, nome, morada, rendimentosOutros);
    }

    public Reformado() {
        super();
    }

    @Override
    public double obterTaxaRT() {
        return Reformado.getTaxaRT();
    }

    @Override
    public double obterTaxaOT() {
        return Reformado.getTaxaOR();
    }

    /**
     * @param taxaRT the taxaRT to set
     */
    public static void setTaxaRT(double taxaRT) {
        Reformado.taxaRT = taxaRT;
    }

    /**
     * @param taxaOR the taxaOR to set
     */
    public static void setTaxaOR(double taxaOR) {
        Reformado.taxaOR = taxaOR;
    }

    /**
     * @return the taxaRT
     */
    public static double getTaxaRT() {
        return taxaRT;
    }

    /**
     * @return the taxaOR
     */
    public static double getTaxaOR() {
        return taxaOR;
    }

}
