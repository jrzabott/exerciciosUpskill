
package com.company.model;

import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.NumeroTerrenoDuplicadoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Freguesia implements Serializable  {
    
    private String nomeFreguesia;
    private ListaTerreno terrenos;
    
    private final String NOME_POR_OMISSAO = "sem nome";
    
    public Freguesia(String nome, ListaTerreno terreno){
        this.nomeFreguesia = nome;
        this.terrenos = terreno;
    }
    
    public Freguesia(){
        this.nomeFreguesia = NOME_POR_OMISSAO;
        this.terrenos = new ListaTerreno();
    }
    
    public Freguesia(Freguesia freguesia){
        this.nomeFreguesia = freguesia.getNomeFreguesia();
        this.terrenos = freguesia.getTerrenos();
    }
    
    public String getNomeFreguesia(){
        return nomeFreguesia;
    }

    public ListaTerreno getTerrenos() { 
        return terrenos;
    }
    
    public void setNomeFreguesia(String nome){
        this.nomeFreguesia = nome;
    }
    
    public void setListaTerrenos(ListaTerreno lista){
        this.terrenos = lista;
    }
    
    public String toString(){
        return String.format("Freguesia %s: %nTerrenos:%n%s", nomeFreguesia, terrenos.toString());
    }
    
    public ListaTerreno getAllTerrenos() {
        ListaTerreno lista = new ListaTerreno(); 
        for (Terreno terreno : terrenos.getTerrenos()) {
            lista.setTerrenos(terrenos.getTerrenos());
            Terreno copiaTerreno = new Terreno(terreno);
            lista.getTerrenos().add(copiaTerreno); 
        }
        return lista; 
    }
    
    public void addTerreno(Terreno terreno) throws NumeroTerrenoDuplicadoException { 
        Terreno t = getTerrenoByNumero(terreno.getNumeroTerreno());
        if (t == null) {
            this.terrenos.getTerrenos().add(terreno); 
        } else {
            throw new NumeroTerrenoDuplicadoException(t.getNumeroTerreno() + ": Número já existe"); 
        }
    }

    public Terreno getTerrenoByNumero(int numeroTerreno) {
        ListaTerreno lista = null;
        for (Terreno terreno : terrenos.getTerrenos() ) {
            lista.setTerrenos(terrenos.getTerrenos());
            if (terreno.getNumeroTerreno() == numeroTerreno) {
                Terreno copia = new Terreno(terreno);
                return copia; 
            }
        }
        return null; 
    }
    
    public void removeTerreno(int numero) throws ElementoNaoExistenteException { 
        ListaTerreno lista = null;
        for (Terreno terreno : terrenos.getTerrenos()) {
            lista.setTerrenos(terrenos.getTerrenos());
            if (terreno.getNumeroTerreno() == numero) {
                this.terrenos.getTerrenos().remove(terreno);
                return;
            }
        }
        throw new ElementoNaoExistenteException(numero + ": Não existe esse terreno"); 
    }
    
    public void updateTerreno(int numero, Terreno t) throws ElementoNaoExistenteException { 
        ListaTerreno lista = null;
        boolean updated = false;
        for (Terreno terreno : terrenos.getTerrenos()) {
            lista.setTerrenos(terrenos.getTerrenos()); 
            if (terreno.getNumeroTerreno() == numero) {
                terreno = t;
                updated = true; 
            }
        }
        if(updated == false){
            throw new ElementoNaoExistenteException(numero + ": Não existe esse terreno"); 
        }
    }
    
}
