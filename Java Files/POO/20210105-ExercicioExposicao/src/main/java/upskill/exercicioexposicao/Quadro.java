/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioexposicao;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Quadro implements Comparable<Object>{
    private String designacao;
    private String autor;
    private int anoCriacao;

    public Quadro(String designacao, String autor, int anoCriacao) {
        this.designacao = designacao;
        this.autor = autor;
        this.anoCriacao = anoCriacao;
    }

    public Quadro() {
        this.anoCriacao = 0;
        this.autor = "N/A";
        this.designacao = "N/A";
    }
    
    
    @Override
    public int compareTo(Object t) {
        return this.getAutor().compareTo(
                ((Quadro)t).getAutor()
        );
    }

    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @param designacao the designacao to set
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the anoCriacao
     */
    public int getAnoCriacao() {
        return anoCriacao;
    }

    /**
     * @param anoCriacao the anoCriacao to set
     */
    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.designacao);
        hash = 89 * hash + Objects.hashCode(this.autor);
        hash = 89 * hash + this.anoCriacao;
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
        final Quadro other = (Quadro) obj;
        if (this.anoCriacao != other.anoCriacao) {
            return false;
        }
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quadro{designacao=").append(designacao);
        sb.append(", autor=").append(autor);
        sb.append(", anoCriacao=").append(anoCriacao);
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }
    
    
}
