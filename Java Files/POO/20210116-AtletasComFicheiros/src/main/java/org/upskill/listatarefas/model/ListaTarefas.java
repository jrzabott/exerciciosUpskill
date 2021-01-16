package org.upskill.listatarefas.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefas implements Serializable {

    private List<Tarefa> listaTarefas;

    // implementar todas as funcionalidades necessárias
    // TODO Adicionar Tarefa
    // TODO Eliminar Todas as Tarefas
    // TODO Eliminar última Tarefa
    public ListaTarefas() {
        this.listaTarefas = new ArrayList<Tarefa>();
    }

    public boolean adicionarTarefa(String descricao, String prioridade) {
        Prioridade p = getPrioridadeByString(prioridade);
        return adicionarTarefa(descricao, p);
    }

    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        Tarefa t = new Tarefa(descricao, prioridade);
        return (listaTarefas.contains(t)
                ? false
                : listaTarefas.add(t));
    }

    public Prioridade getPrioridadeByString(String prioridade) {
        return Tarefa.getPrioridadeByString(prioridade);
    }

    public String[] getPrioridades() {
        Prioridade[] p = Prioridade.values();
        String[] s = new String[p.length];
        for (int i = 0; i < p.length; i++) {
            s[i] = p[i].toString();
        }
        return s;
    }

    public boolean isEmpty() {
        return listaTarefas.isEmpty();
    }

    public int readFromFile() {
        FileListaTarefas fileListaTarefas = new FileListaTarefas();
        ListaTarefas importedList = fileListaTarefas.readFromFile();
        if (importedList == null) {
            return 0;
        }
        return adicionarTarefasImportadas(importedList);
    }

    public int readFromFile(File myFile) {
        FileListaTarefas fileListaTarefas = new FileListaTarefas();
        ListaTarefas importedList = fileListaTarefas.readFromFile(myFile);
        if (importedList == null) {
            return 0;
        }
        return adicionarTarefasImportadas(importedList);
    }

    public void removeAllTasks() {
        listaTarefas.clear();
    }

    public String[] removeTask(String descricao, String prioridade) {
        Tarefa t = new Tarefa(descricao, getPrioridadeByString(prioridade));
        String[] result;
        if (listaTarefas.remove(t)) {
            result = new String[2];
            result[0] = t.getDescricao();
            result[1] = t.getPrioridade().toString();
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tarefa tarefa : listaTarefas) {
            sb.append(tarefa).append("\n");
        }
        return sb.toString();
    }

    public String[] toStringArray() {
        String result[] = new String[listaTarefas.size()];
        int index = 0;
        for (Tarefa tarefa : listaTarefas) {
            result[index++] = tarefa.toString();
        }
        return result;
    }

    private int adicionarTarefasImportadas(ListaTarefas importedList) {
        int counter = 0;
        if (importedList.isEmpty()) {
            return counter;
        }
        for (Tarefa t : importedList.listaTarefas) {
            if (this.adicionarTarefa(t.getDescricao(), t.getPrioridade())) {
                counter++;
            }
        }
        return counter;
    }

    private List<Tarefa> getListaTarefasAsArrayList() {
        return this.listaTarefas;
    }

    public enum ORDENACAO {
        INSERCAO, PRIORIDADE
    }

}
