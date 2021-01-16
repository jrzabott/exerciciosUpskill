package org.upskill.listatarefas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tarefa implements Comparable<Tarefa>, Serializable {

    static Prioridade getPrioridadeByString(String prioridade) {
        Prioridade result = null;
        for (Prioridade p : Prioridade.values()) {
            if (p.toString().equals(prioridade)) {
                result = p;
            }
        }
        return result;
    }

    private String descricao;
    private LocalDateTime instante;
    private Prioridade prioridade;

    public Tarefa(String descricao, Prioridade prioridade) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        instante = LocalDateTime.now();
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        if (prioridade.equals(outraTarefa.prioridade)) {
            return instante.compareTo(outraTarefa.instante);
        }

        return prioridade.compareTo(outraTarefa.prioridade);
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
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.prioridade != other.prioridade) {
            return false;
        }
        return true;
    }

    public String getDescricao() {
        return descricao;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida!");
        }
        this.descricao = descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public final void setPrioridade(Prioridade prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException("Prioridade inválida!");
        }
        this.prioridade = prioridade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.instante);
        hash = 37 * hash + Objects.hashCode(this.prioridade);
        return hash;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoInstante
                = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS.SSS");
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s - %s - %s", descricao, prioridade,
                stringDataTempoDeRegisto);
    }

}
