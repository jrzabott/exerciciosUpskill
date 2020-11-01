/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.automovel;

import static java.lang.System.out;

/**
 *
 * @author user
 */
public class MainAutomovel {

    public static void main(String[] args) {
        final int CILINDRADA_A_COMPARAR = 2000;

        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1400);
        out.println("==========================");
        out.println(a1.toString());
        out.println("==========================");
        out.println("Matricula do Automovel a1: " + a1.getMatricula());
        out.println("==========================");
        out.println("Número de Automóveis Instanciados: " + Automovel.getTotalAutomoveis());
        out.println("==========================");
        out.println("Criando a2 com marca Audi e Matricula 22-22-BB...");

        Automovel a2 = new Automovel("22-22-BB", "Audi");

        out.println("==========================");
        out.println(a2.toString());
        out.println("==========================");
        out.println("Modificando cilindrada de a2 para 1800cc.");

        a2.setCilindrada(1800);

        out.println("==========================");
        out.println(a2.toString());
        out.println("==========================");
        out.println("Número de Automóveis Instanciados: " + Automovel.getTotalAutomoveis());
        out.println("==========================");
        out.println("Diferença de cilindradas entre a1 e a2: " + Math.abs(a2.getCilindrada() - a1.getCilindrada()));
        out.println("==========================");
        out.println("Maior Cilindrada pertence ao automóvel: " + 
                (a1.getCilindrada() == a2.getCilindrada() 
                        ? "a1 e a2 possuem a mesma cilindrada com " + a1.getCilindrada()
                        : (a1.getCilindrada() > a2.getCilindrada())
                            ? "a1 com " + a1.getCilindrada() + " cc." 
                            : "a2 com " + a2.getCilindrada() + " cc."
        ));
        out.println("==========================");
        out.println("Cilindrada de a1 > 2000cc ? " + (a1.getCilindrada() > CILINDRADA_A_COMPARAR));
        out.println("==========================");

    }

}
