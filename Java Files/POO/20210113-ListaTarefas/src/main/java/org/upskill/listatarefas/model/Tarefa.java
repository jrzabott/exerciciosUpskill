package org.upskill.listatarefas.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa implements Comparable<Tarefa> {
    private String descricao;
    private LocalDateTime instante;
    private Prioridade prioridade;

    public Tarefa(String descricao, Prioridade prioridade) {
        setDescricao(descricao);
        setPrioridade(prioridade);
        instante = LocalDateTime.now();
    }

    Tarefa(String descricao, String prioridade) {
        setDescricao(descricao);
        setPrioridade(getPrioridadeByValue(prioridade));
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida!");
        }
        this.descricao = descricao;
    }

    public final void setPrioridade(Prioridade prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException("Prioridade inválida!");
        }
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoInstante = 
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM:SS.SSS");
        String stringDataTempoDeRegisto = instante.format(formatoInstante);
        return String.format("%s - %s - %s", descricao, prioridade, 
                stringDataTempoDeRegisto);
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        if(prioridade.equals(outraTarefa.prioridade)) {
            return instante.compareTo(outraTarefa.instante);
        }
        
        return prioridade.compareTo(outraTarefa.prioridade);
    }
    
    private static Prioridade getPrioridadeByValue(String v) {
        Prioridade result = null;
        for (Prioridade p : Prioridade.values()) {
            if (p.toString().equals(v)) {
                result = p;
            }
        }
        return result;
    }

}
