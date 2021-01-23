package com.company.model;

import com.company.exception.NomeFreguesiaInvalido;
import java.io.Serializable;

public class Freguesia implements Serializable {

    private String nome;

    public Freguesia() {
    }

    public Freguesia(String nome) {
        setNome(nome);
    }

    public Freguesia(Freguesia ofreguesia) {
        setNome(ofreguesia.nome);
    }

    public void setNome(String nome) throws NomeFreguesiaInvalido {
        if (fNomeValido(nome)) {
            this.nome = nome;
        } else {
            throw new NomeFreguesiaInvalido(nome + " Invalido");
        }
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Freguesia{" + "nome=" + nome + '}';
    }

    private boolean fNomeValido(String nome) {
        if (nome == null) {
            return false;
        }
        if (nome.length() < 3) {
            return false;
        }
        if (nome.length() != nome.replaceAll("\\s+", "").length()) {
            return false;
        }
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) >= '0' && nome.charAt(i) <= '9') {
                return false;
            }
        }
        return true;
    }

}
