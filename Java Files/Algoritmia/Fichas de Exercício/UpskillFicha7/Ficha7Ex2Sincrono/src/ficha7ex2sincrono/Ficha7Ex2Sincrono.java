/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7ex2sincrono;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha7Ex2Sincrono {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        final int TAMANHO = 30;
        String[] nomes = new String[TAMANHO];
        int[] notas = new int[TAMANHO];

        String nome;
        int nota;
        Scanner s = new Scanner(System.in);

        int nElem = 0;
        System.out.println("Nome?"); // LER NOME E NOTAS.
        nome = s.nextLine();
        double soma = 0;
        while (!"fim".equalsIgnoreCase(nome) && nElem <= TAMANHO) {
            nomes[nElem] = nome; //LER NOME E NOTAS
            System.out.print("Nota? ");
            notas[nElem] = s.nextByte();
            s.nextLine(); // LIMPAR BUFFER
            soma += notas[nElem];

            nElem++;

            System.out.println("Nome?");
            nome = s.nextLine();
        }

        double media = soma / nElem;
        Formatter fichMelhores = new Formatter(new File("melhores.txt"));

        fichMelhores.format("Média: %.2f", media);
        for (int x = 0; x < nElem; x++) {
            fichMelhores.format("%n%s:%d", nomes[x], notas[x]);
        }
        fichMelhores.close();
    }

}
