/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioaniversario;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Pessoa {

    String nome;
    Data aniversario;

    public Pessoa(String nome, Data aniversario) {
        this.nome = nome;
        this.aniversario = aniversario;
    }

    public Pessoa() {
    }

    public void setNome(String nome) {
        // TODO Validar Nome
        this.nome = nome;
    }

    public void setAniversario(Data d) {
        this.aniversario = d;
    }

    public String getNome() {
        return nome;
    }

    public Data getAniversario() {
        return aniversario;
    }

}
