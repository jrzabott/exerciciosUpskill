package org.upskill.listatarefas.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.upskill.listatarefas.controller.AplicacaoController;

public class ListaTarefas {

    private List<Tarefa> listaTarefas;



    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

    //implementar todas as funcionalidades necessárias
    public ListaTarefas() {
        listaTarefas = new ArrayList<Tarefa>();
    }
    //implementar todas as funcionalidades necessárias
    public ListaTarefas(ListaTarefas outraLista) {
        this.listaTarefas = outraLista.getListaTarefas();
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public boolean isEmpty() {
        return listaTarefas.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tarefa tarefa : listaTarefas) {
            sb.append(tarefa.toString());
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

    public String orderByPrioridade() {
//        Comparator<Tarefa> orderByPrioridade = Comparator.comparing(Tarefa::getPrioridade);
//        Collections.sort(listaTarefas, orderByPrioridade);
        Collections.sort(listaTarefas);
        return this.toString();
    }
    public String orderByHora() {
        Comparator<Tarefa> orderByHora = Comparator.comparing(Tarefa::getInstante);
        Collections.sort(listaTarefas, orderByHora);
        return this.toString();
    }
}
