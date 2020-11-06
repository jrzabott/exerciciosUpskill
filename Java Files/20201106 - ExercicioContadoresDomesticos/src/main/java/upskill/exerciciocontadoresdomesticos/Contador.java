/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciocontadoresdomesticos;

/**
 *
 * @author user
 */
public abstract class Contador {
    private String nome;
    
    private String NOME_DEFAULT = "John Smith";
    
    public abstract double calcularConsumo();
    public abstract double getCustoUnit();
    public abstract String obterID();

    public Contador(String nome, String ID) {
        this.nome = nome;
    }

    public Contador() {
        this.nome = NOME_DEFAULT;
    }
    
    
}
