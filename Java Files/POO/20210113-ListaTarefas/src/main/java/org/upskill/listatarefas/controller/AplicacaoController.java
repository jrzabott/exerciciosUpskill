package org.upskill.listatarefas.controller;

import org.upskill.listatarefas.model.ListaTarefas;
import org.upskill.listatarefas.model.Prioridade;

public class AplicacaoController {

    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, String prioridade) throws IllegalArgumentException {
        if (descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descricao não pode vazia.");
        }

        if (prioridade.isEmpty()) {
            throw new IllegalArgumentException("Deve selecionar uma prioridade.");
        }

        return lista.adicionarTarefa(descricao, prioridade);
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        lista.getListaTarefas().clear();
    }

    // TODO elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return lista.eliminarUltimaTarefa();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.isEmpty();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return lista.toString();
    }

    //TODO retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }

   
}
