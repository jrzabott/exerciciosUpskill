/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

/**
 *
 * @author user
 */
public class Cumprimentar {

    private String name;
    private int idade;

    final private String DEFAULT_NAME = "No Name? What!? lol!";
    final private int DEFAULT_IDADE = 0;

    private static int totalPessoas = 0;

    public Cumprimentar() {
        this.name = DEFAULT_NAME;
        totalPessoas++;
    }

    public Cumprimentar(String nome) {
        this.name = nome;
        totalPessoas++;
    }

    public Cumprimentar(String nome, int idade) {
        this.name = nome;
        this.idade = idade;
        totalPessoas++;
    }

    public String getName() {
        return this.name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String toString() {
//        return "O nome desta pessoa é " + this.name;
        return String.format("%s tem %d anos.", this.name, this.idade);
    }
}
