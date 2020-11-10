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
public class Aluno extends Pessoa{
    
    private int numeroMecanografico;

    private static final int NUMERO_MECANOGRAFICO_DEFAULT = 0;

    public Aluno(int numeroMecanografico, String nome, int idCivil) {
        super(nome, idCivil);
        this.numeroMecanografico = numeroMecanografico;
    }

    public Aluno() {
        super();
        this.numeroMecanografico = NUMERO_MECANOGRAFICO_DEFAULT;
    }

    
    
    /**
     * @return the numeroMecanografico
     */
    public int getNumeroMecanografico() {
        return numeroMecanografico;
    }

    /**
     * @param numeroMecanografico the numeroMecanografico to set
     */
    public void setNumeroMecanografico(int numeroMecanografico) {
        this.numeroMecanografico = numeroMecanografico;
    }

    @Override
    public String toString() {
        return "Aluno{" + "numeroMecanografico=" + numeroMecanografico + '}' + super.toString();
    }
    
    
}
