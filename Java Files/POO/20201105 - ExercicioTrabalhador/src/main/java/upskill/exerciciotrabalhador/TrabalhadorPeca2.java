/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciotrabalhador;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class TrabalhadorPeca2 extends Trabalhador {

    private int[] numPecas;
    private static double[] precoPecas = {6.50, 9.50};

    public TrabalhadorPeca2(int[] arrayPecas, String nome) {
        super(nome);
        this.numPecas = new int[precoPecas.length];
        this.numPecas = arrayPecas;
    }

    @Override
    public float calcularVencimento() {
        double total = 0;
        for (int i = 0; i < this.numPecas.length && i < TrabalhadorPeca2.precoPecas.length; i++) {
            total += precoPecas[i] * numPecas[i];
        }
        return (float) total;
    }

    /**
     * @param posicaoPeca
     * @return the numPecas
     */
    public int getNumPecas(int posicaoPeca) {
        if (posicaoPeca >= 0 && posicaoPeca < numPecas.length) {
            return numPecas[posicaoPeca];
        } else {
            return 0;
        }
    }

    /**
     * @param posicaoDaPeca
     * @param aNumPecas
     * @param numPecas the numPecas to set
     */
    public void setNumPecas(int posicaoDaPeca, int aNumPecas) {
        if (posicaoDaPeca >= 0 && posicaoDaPeca < numPecas.length) {
            this.numPecas[posicaoDaPeca] = aNumPecas;
        }
    }

    /**
     * @return the precoPecas
     */
    public static double getPrecoPecas(int posicaoPrecoPeca) {
        if (posicaoPrecoPeca >= 0 && posicaoPrecoPeca < precoPecas.length) {
            return precoPecas[posicaoPrecoPeca];
        } else {
            return 0.0;
        }
    }

    /**
     * @param aPrecoPecas the precoPecas to set
     * @param posicaoPrecoPeca
     */
    public static void setPrecoPecas(double aPrecoPecas, int posicaoPrecoPeca) {
        if (posicaoPrecoPeca >= 0 && posicaoPrecoPeca < precoPecas.length) {
            precoPecas[posicaoPrecoPeca] = aPrecoPecas;
        }
    }

}
