/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha7ex3sincrono;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Ficha7Ex3Sincrono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fichDados = new Scanner(new File("Dados.txt"));
        Scanner s = new Scanner(System.in);
        Formatter fichNovo = new Formatter(new File("Novo.txt"));

        System.out.println("Valor: ");
        int valor = s.nextInt();
        boolean primeiraVez = true;

        while (fichDados.hasNextLine()) {
            String linha = fichDados.nextLine();
            String[] vetLinha = linha.split(" ");
            String novaLinha = "";
            for (int i = 0; i < vetLinha.length; i++) {
                if (vetLinha[i].length() <= valor ) {
                    novaLinha = novaLinha + vetLinha[i] + " ";
                }
               
            }
 System.out.println(novaLinha);
//            novaLinha = novaLinha.trim();
//            if (primeiraVez) {
//                fichNovo.format("%s", novaLinha);
//                primeiraVez = false;
//            } else {
//                fichNovo.format("%n%s", novaLinha);
//            }
        }
        fichNovo.close();
        fichDados.close();

    }

}
