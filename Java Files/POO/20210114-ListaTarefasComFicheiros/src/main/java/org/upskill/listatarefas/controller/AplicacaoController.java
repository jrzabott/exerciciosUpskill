package org.upskill.listatarefas.controller;

import java.io.File;
import java.io.IOException;
import org.upskill.listatarefas.model.FileListaTarefas;
import org.upskill.listatarefas.model.ListaTarefas;

public class AplicacaoController {

    private FileListaTarefas fileListaTarefas;
    private ListaTarefas lista;

    //inicia atributos
    public AplicacaoController() {
        lista = new ListaTarefas();
        fileListaTarefas = new FileListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, String prioridade) {
        return lista.adicionarTarefa(descricao, prioridade);
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return lista.toString();
    }

    public String[] getListaTarefasAsArray() {
        return lista.toStringArray();
    }
//    public String getListaTarefas() {
//        return lista.toString();
//    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //retorna um array com todos os valores de Prioridade
    public String[] getPrioridades() {
        return lista.getPrioridades();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return lista.isEmpty();
    }

    public int readFromFile() {
        int count = lista.readFromFile();
        return count;
    }

    public int readFromFile(File myFile) {
        int count = lista.readFromFile(myFile);
        return count;
    }

    public void removeAllTasks() {
        lista.removeAllTasks();
    }

    public String[] removeTask(String descricao, String prioridade) {
        return lista.removeTask(descricao, prioridade);
    }

    public boolean saveAsTextFile(File myFile) {
        return fileListaTarefas.saveAsTextFile(myFile, lista);
    }

    public boolean saveToFile() {
        File myFile = null;
        return (fileListaTarefas.saveToFile(lista, myFile));
    }

    public void saveToFileSilently() throws IOException {
        File myFile = null;
        fileListaTarefas.saveToFileSilently(lista, myFile);
    }

    public boolean saveToFile(File myFile) {
        return fileListaTarefas.saveToFile(lista, myFile);
    }

}
