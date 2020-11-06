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
public abstract class Contribuinte {

    private String nome;
    private String morada;
    private double rendimentosOT;

    private final String NOME_DEFAULT = "John Doe";
    private final String MORADA_DEFAULT = "Estrada do Sol, "
            + "54321... Pufff";
    private final double RENDIMENTOS_OUTROS_DEFAULT = 0.0;

    public Contribuinte(String nome, String morada, 
            double rendimentosOutros) {
        this.nome = nome;
        this.morada = morada;
        this.rendimentosOT = rendimentosOutros;
    }

    public Contribuinte() {
        this.nome = NOME_DEFAULT;
        this.morada = MORADA_DEFAULT;
        this.rendimentosOT = RENDIMENTOS_OUTROS_DEFAULT;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public double getRendimentosOT() {
        return rendimentosOT;
    }

    public void setRendimentosOT(double rendimentosOT) {
        this.rendimentosOT = rendimentosOT;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Contribuinte{"
                + "nome=" + nome
                + ", morada=" + morada
                + ", rendimentosOutros=" + rendimentosOT + '}';
    }

    public abstract double calcularImposto();

}
