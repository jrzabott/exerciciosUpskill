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
public abstract class ContribuinteComRT extends Contribuinte {

    private double rendimentosRT;
    private final double RENDIMENTOS_TRABALHO_DEFAULT = 0.0;

    public ContribuinteComRT(double rendimentosRT, String nome,
            String morada, double rendimentosOutros) {
        super(nome, morada, rendimentosOutros);
        this.rendimentosRT = rendimentosRT;
    }

    public ContribuinteComRT() {
        super();
        this.rendimentosRT = RENDIMENTOS_TRABALHO_DEFAULT;
    }

    @Override
    public double calcularImposto() {
        return (this.getRendimentosRT()
                * this.obterTaxaRT())
                + (this.getRendimentosOT()
                * this.obterTaxaOT());
    }

    /**
     * @return the rendimentosRT
     */
    public double getRendimentosRT() {
        return rendimentosRT;
    }

    /**
     * @param rendimentosRT the rendimentosRT to set
     */
    public void setRendimentosRT(double rendimentosRT) {
        this.rendimentosRT = rendimentosRT;
    }

    public abstract double obterTaxaRT();

    public abstract double obterTaxaOT();

}
