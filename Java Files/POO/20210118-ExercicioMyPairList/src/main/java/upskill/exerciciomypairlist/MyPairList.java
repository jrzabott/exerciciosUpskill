/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciomypairlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.lang.Comparable;
import java.util.Set;

/**
 *
 * @author user
 */
public class MyPairList<T extends Comparable<T> & Serializable, U extends Comparable<U> & Serializable> implements Serializable {

    List<Pair<T, U>> lista;

    public MyPairList() {
        this.lista = new ArrayList<Pair<T, U>>();
    }

    public List<Pair<T, U>> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair myPair : lista) {
            sb.append(myPair);
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean addPair(T obj1, U obj2) {
        Pair mp = new Pair(obj1, obj2);
        return lista.add(mp);
    }

    private void ordenarLista() {
        Collections.sort(lista);
    }

    private void removerDuplicados() {
        Set<Pair<T, U>> tempHashSet = new HashSet<Pair<T, U>>(lista);
        lista = new ArrayList<Pair<T, U>>(tempHashSet);
    }

    public void ordenarListaELimparDuplicados() {
        ordenarLista();
        removerDuplicados();
    }

    public List<Pair<T, U>> listaDosObjetosMaioresQue(Pair pair) {
        List<Pair<T, U>> tempList = new ArrayList<>(lista);
        for (Pair<T, U> pair1 : lista) {
            if (pair1.compareTo(pair) < 0) {
                tempList.remove(pair1);
            }
        }
        return tempList;
    }

    public List<U> listaDosObjetosComPrimeiroElementoIgualA(T firstToBeFound) {
        List<U> result = new ArrayList<U>();
        for (Pair<T, U> pair : lista) {
            if (pair.getFirst().equals(firstToBeFound)) {
                result.add(pair.getSecond());
            }
        }
        return result;
    }
}
