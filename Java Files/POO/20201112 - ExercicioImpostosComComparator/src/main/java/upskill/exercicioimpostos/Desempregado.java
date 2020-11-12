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
public class Desempregado extends Contribuinte {

    private int mesesDeParagem;
    private static double taxaOR = 0.02;

    private final int MESES_DE_PARAGEM_DEFAULT = 0;

    public Desempregado(String nome, String morada, double rendimentosOutros, int mesesDeParagem) {
        super(nome, morada, rendimentosOutros);
        this.mesesDeParagem = mesesDeParagem;
    }

    public Desempregado() {
        super();
        this.mesesDeParagem = MESES_DE_PARAGEM_DEFAULT;
    }

    @Override
    public double calcularImposto() {
        return this.getRendimentosOT() * this.obterTaxaOR();
    }

    private double obterTaxaOR() {
        return Desempregado.getTaxaOR();
    }

    /**
     * @return the mesesDeParagem
     */
    public int getMesesDeParagem() {
        return mesesDeParagem;
    }

    /**
     * @return the taxaOR
     */
    public static double getTaxaOR() {
        return taxaOR;
    }

    /**
     * @param mesesDeParagem the mesesDeParagem to set
     */
    public void setMesesDeParagem(int mesesDeParagem) {
        this.mesesDeParagem = mesesDeParagem;
    }

    /**
     * @param aTaxaOR the taxaOR to set
     */
    public static void setTaxaOR(double aTaxaOR) {
        taxaOR = aTaxaOR;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.mesesDeParagem;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Desempregado other = (Desempregado) obj;
        if (this.mesesDeParagem != other.mesesDeParagem) {
            return false;
        }
        return true;
    }
    
    

}
