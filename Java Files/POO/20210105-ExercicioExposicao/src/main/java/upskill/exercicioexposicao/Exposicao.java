/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioexposicao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Exposicao implements Comparable<Object> {

    private String designacao;
    private int anoRealizacao;
    private List<Quadro> quadros;

    public Exposicao(String designacao, int anoRealizacao) {
        this.designacao = designacao;
        this.anoRealizacao = anoRealizacao;
        this.quadros = new ArrayList<Quadro>();
    }

    public Exposicao() {
        this.designacao = "N/A";
        this.anoRealizacao = 1;
        this.quadros = new ArrayList<Quadro>();
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
     * @return the anoRealizacao
     */
    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    /**
     * @param anoRealizacao the anoRealizacao to set
     */
    public void setAnoRealizacao(int anoRealizacao) {
        this.anoRealizacao = anoRealizacao;
    }

    /**
     * @return the quadros
     */
    public List<Quadro> getQuadros() {
        return quadros;
    }

    /**
     * @param quadros the quadros to set
     */
    public void setQuadros(List<Quadro> quadros) {
        this.quadros.clear();
        this.quadros.addAll(quadros);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.designacao);
        hash = 73 * hash + Objects.hashCode(this.anoRealizacao);
        hash = 73 * hash + Objects.hashCode(this.quadros);
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
        final Exposicao other = (Exposicao) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        if (!Objects.equals(this.anoRealizacao, other.anoRealizacao)) {
            return false;
        }
        if (!Objects.equals(this.quadros, other.quadros)) {
            return false;
        }
        return true;
    }

    public boolean addQuadro(Quadro q) {
        return (this.quadros.contains(q)) ? false : this.quadros.add(q);
    }

    public boolean removeQuadro(Quadro q) {
        return this.quadros.remove(q);
    }

    @Override
    public int compareTo(Object t) {
        return (this.getAnoRealizacao() == ((Exposicao) t).getAnoRealizacao()
                ? 0
                : (this.getAnoRealizacao() > ((Exposicao) t).getAnoRealizacao())
                ? 1
                : -1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exposicao{designacao=").append(designacao);
        sb.append(", anoRealizacao=").append(anoRealizacao);
        sb.append(", quadros=\n").append(quadros);
        sb.append('}');
        sb.append("\n");

        return sb.toString();
    }

}
