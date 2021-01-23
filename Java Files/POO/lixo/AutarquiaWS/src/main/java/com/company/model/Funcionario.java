/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.exception.NumeroFuncionarioInvalidoException;
import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {

    private int numeroFuncionario;
    private String cargo;

    public Funcionario(long nif, String nome, Data nascimento) {
        super(nif, nome, nascimento);
    }

    public Funcionario(long nif, String nome, Data nascimento, int numeroFuncionario, String cargo) {
        super(nif, nome, nascimento);
        setNumeroFuncionario(numeroFuncionario);
        this.cargo = cargo;
    }

    public Funcionario(Funcionario funcionario) {
        super(funcionario.getNif(), funcionario.getNome(), funcionario.getNascimento());
        setNumeroFuncionario(funcionario.getNumeroFuncionario());
        this.cargo = funcionario.getCargo();
    }

    public int getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setNumeroFuncionario(int numeroFuncionario) throws NumeroFuncionarioInvalidoException {
        if (numeroFuncionario > 0) {
            this.numeroFuncionario = numeroFuncionario;
        } else {
            throw new NumeroFuncionarioInvalidoException(numeroFuncionario + ": N´umero inv´alido");
        }
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
