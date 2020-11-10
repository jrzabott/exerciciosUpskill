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
public abstract class Pessoa {

    private String nome;
    private int idCivil;

    private static final String NOME_DEFAULT = "XXX";
    private static final int ID_CIVIL_DEFAULT = 0;

    public Pessoa(String nome, int idCivil) {
        this.nome = nome;
        this.idCivil = idCivil;
    }

    public Pessoa() {
        this.nome = NOME_DEFAULT;
        this.idCivil = ID_CIVIL_DEFAULT;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the idCivil
     */
    public int getIdCivil() {
        return idCivil;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param idCivil the idCivil to set
     */
    public void setIdCivil(int idCivil) {
        this.idCivil = idCivil;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idCivil=" + idCivil + '}';
    }
    
    
}
