/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciofilme;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Realizador {
    private String nome;
    private CountriesEnum nacionalidade;
    private Data dataNascimento;
    
    private static final String NOME_DEFAULT = "N/A";
    private static final CountriesEnum NACIONALIDADE_DEFAULT = CountriesEnum.UNITED_STATES_OF_AMERICA;
    private static final Data DATA_DEFAULT = new Data();
    

    public Realizador(String nome, CountriesEnum nacionalidade, Data dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }

    public Realizador() {
        this.dataNascimento = DATA_DEFAULT;
        this.nacionalidade = NACIONALIDADE_DEFAULT;
        this.nome = NOME_DEFAULT;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CountriesEnum getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(CountriesEnum nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.nacionalidade);
        hash = 61 * hash + Objects.hashCode(this.dataNascimento);
        return hash;
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
        final Realizador other = (Realizador) obj;
        if (!Objects.equals(this.nome, other.getNome())) {
            return false;
        }
        if (this.nacionalidade != other.getNacionalidade()) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.getDataNascimento())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome);
        sb.append(", Nacionalidade: ").append(nacionalidade);
        sb.append(", Nascido em: ").append(dataNascimento);
        sb.append(".\n");
        return sb.toString();
    }
    
    
    
}
