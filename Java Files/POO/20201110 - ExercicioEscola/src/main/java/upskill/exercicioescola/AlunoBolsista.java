/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioescola;

/**
 *
 * @author user
 */
public class AlunoBolsista extends Aluno implements Pagavel {

    private double bolsaMensal;

    private static final double BOLSA_MENSAL_DEFAULT = 0;

    public AlunoBolsista(String nome, int idCivil, int numeroMecanografico, double bolsaMensal) {
        super(numeroMecanografico, nome, idCivil);
        this.bolsaMensal = bolsaMensal;
    }

    public AlunoBolsista() {
        super();
        this.bolsaMensal = BOLSA_MENSAL_DEFAULT;
    }

    /**
     * @return the bolsaMensal
     */
    public double getBolsaMensal() {
        return bolsaMensal;
    }

    /**
     * @param bolsaMensal the bolsaMensal to set
     */
    public void setBolsaMensal(double bolsaMensal) {
        this.bolsaMensal = bolsaMensal;
    }

    @Override
    public double calcularPagamento() {
        return getBolsaMensal();
    }

}
