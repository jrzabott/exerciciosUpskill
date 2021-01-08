/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioaniversario;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        try (Formatter ficheiro = Utils.lerFicheiro()) {
        try (Formatter ficheiro = Utils.lerFicheiro("test.txt")) {
            Pessoa p = new Pessoa();
            String nome;

            nome = Utils.obterNome();

            while (!nome.isEmpty()) {
                p.setNome(nome);

                Data data = Utils.obterData();
                p.setAniversario(data);

                ficheiro.format("%s; %s%n", p.getNome(), p.getAniversario().toString());
                ficheiro.flush();
                nome = Utils.obterNome();
            }
        }
    }

}
