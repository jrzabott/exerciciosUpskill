/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioimpostos;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contribuinte other = (Contribuinte) obj;
        if (Double.doubleToLongBits(this.rendimentosOT) != Double.doubleToLongBits(other.rendimentosOT)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        return true;
    }
    
    

    public abstract double calcularImposto();

}
