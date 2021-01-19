/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.model;

import upskill.AutarquiaWS.exception.NifInvalidoException;
import upskill.AutarquiaWS.exception.NomePessoaInvalidoException;
import java.io.Serializable;

public class Pessoa implements Serializable {

    private long nif;
    private String nome;
    private Data nascimento;

    public Pessoa() {
    }

    public Pessoa(long nif, String nome, Data nascimento) {
        setNif(nif);
        setNome(nome);
        this.nascimento = new Data(nascimento);
    }

    public Pessoa(Pessoa pessoa) {
        setNif(pessoa.nif);
        setNome(pessoa.nome);
        this.nascimento = new Data(pessoa.nascimento);
    }

    public long getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public Data getNascimento() {
        Data data = new Data(nascimento);
        return data;
    }

    public void setNif(long nif) throws NifInvalidoException {
        if (nif >= 100000000 && nif <= 999999999) {
            this.nif = nif;
        } else {
            throw new NifInvalidoException(nif + ": NIF inválido");
        }
    }

    public void setNome(String nome) throws NomePessoaInvalidoException {
        if (eNomeValido(nome)) {
            this.nome = nome;
        } else {
            throw new NomePessoaInvalidoException(nome + ": Nome inválido");
        }
    }

    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }

    private boolean eNomeValido(String nome) {
        if (nome == null) {
            return false;
        }
        if (nome.length() < 3) {
            return false;
        }
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) >= '0' && nome.charAt(i) <= '9')
return false;
        }
        return true;

    }
}
