package org.upskill.listatarefas.model;

import java.util.ArrayList;
import java.util.List;
import org.upskill.listatarefas.controller.AplicacaoController;

public class ListaTarefas {

    public boolean isEmpty() {
        return listaTarefas.isEmpty();
    }

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    private List<Tarefa> listaTarefas;

    //implementar todas as funcionalidades necessárias
    public ListaTarefas() {
        listaTarefas = new ArrayList<Tarefa>();
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tarefa tarefa : listaTarefas) {
            sb.append(tarefa);
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean adicionarTarefa(String descricao, String prioridade) {
        Tarefa t = new Tarefa(descricao, prioridade);
        return (listaTarefas.contains(t)
                ? false
                : listaTarefas.add(t));
    }

    public boolean eliminarUltimaTarefa() {
        return listaTarefas.remove(listaTarefas.get(listaTarefas.size() - 1));
    }

}
