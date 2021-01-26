/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.NomeFreguesiaInvalidoException;
import com.company.exception.NumeroFreguesiaInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Home
 */
public class Freguesia implements Serializable  {
    private String nomeFreguesia;
    private int id;
    
    private static final String FREGUESIA_DEFAULT = "Nenhuma";
    private static final int ID_DEFAULT = 0;
    
    
 public Freguesia(int id, String freguesia) {
        this.id = id;
        this.nomeFreguesia = freguesia;
    }
 public Freguesia() {
        this.id = ID_DEFAULT;
        this.nomeFreguesia = FREGUESIA_DEFAULT;
    }

    Freguesia(Freguesia freguesia) {
        this.id = freguesia.getId();
        this.nomeFreguesia = freguesia.getNomeFreguesia();
    }

    public String getNomeFreguesia() {
        return nomeFreguesia;
    }

    public void setNomeFreguesia(String nomeFreguesia) throws NomeFreguesiaInvalidoException{
        if (eFreguesiaValida(nomeFreguesia)){
             this.nomeFreguesia = nomeFreguesia;
        } else {
            throw new NomeFreguesiaInvalidoException(nomeFreguesia + ": Nome de freguesia Inválido!");
        }
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws NumeroFreguesiaInvalidoException {
        if (id > 0 ){
        this.id = id;
    } else {
    throw new NumeroFreguesiaInvalidoException(id + ": ID Inválido!");
}

}

    @Override
    public String toString() {
        return "Freguesia{" + "nomeFreguesia=" + nomeFreguesia + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nomeFreguesia);
        hash = 29 * hash + this.id;
        return hash;
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
        final Freguesia other = (Freguesia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomeFreguesia, other.nomeFreguesia)) {
            return false;
        }
        return true;
    }
    

        private boolean eFreguesiaValida(String nomeFreguesia) {
        if (nomeFreguesia == null) {
            return false;
        }
        if (nomeFreguesia.length() < 3) {
            return false;
        }
        for (int i = 0; i < nomeFreguesia.length(); i++) {
            if(nomeFreguesia.charAt(i) >= '0' && nomeFreguesia.charAt(i) <= '9')
            return false;
        }
        return true;
    }
}

