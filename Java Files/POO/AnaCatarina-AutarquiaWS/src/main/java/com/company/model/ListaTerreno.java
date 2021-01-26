package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaTerreno implements Serializable {

    private List<Terreno> listaTerrenos;

    public ListaTerreno() {
        this.listaTerrenos = new ArrayList<>();
    }

    public ListaTerreno(ListaTerreno lista) {
//        this.listaTerrenos = new ArrayList<>(lista.getTerrenos());
            this.listaTerrenos = new ArrayList<Terreno>();
            for (Terreno t : lista.listaTerrenos) {
                this.listaTerrenos.add(t);
            }

    }

    public List<Terreno> getTerrenos() {
        return listaTerrenos;
    }

    public void setTerrenos(List<Terreno> terreno) {
        this.listaTerrenos = new ArrayList<Terreno>();
        for (Terreno terreno1 : terreno) {
            this.listaTerrenos.add(terreno1);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Terreno listaTerreno : listaTerrenos) {
            s.append(listaTerreno);
            s.append("\n");
        }
        return s.toString().trim();
    }

}
