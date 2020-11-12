package org.upskill.vencimentos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainVencimentos {

    public static void main(String[] args) {
        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira", 
                                                          500.0f, 1500.0f, 6f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);

        List<Trabalhador> trabs = new ArrayList<>();
        trabs.add(tc);
        trabs.add(tp);
        trabs.add(th);

        System.out.println("### Trabalhadores ###");
        listar(trabs);
        
        System.out.println("=====================================================");
        System.out.println("TRABALHADORES EM ORDEM CRESCENTE - VENCIMENTOS");
        System.out.println("-----------------------------------------------------");
        TrabalhadorVencimentoComparator trabComp = new TrabalhadorVencimentoComparator();
        Collections.sort(trabs, trabComp);
        listar(trabs);
        
        System.out.println("=====================================================");
        System.out.println("TRABALHADORES EM ORDEM DECRESCENTE - VENCIMENTOS");
        System.out.println("-----------------------------------------------------");
        Collections.sort(trabs, Collections.reverseOrder(trabComp));
        listar(trabs);
        
        System.out.println("=====================================================");
        System.out.println("TRABALHADORES EM ORDEM CRESCENTE - NOMES");
        System.out.println("-----------------------------------------------------");
        TrabalhadorNomeComparator trabCompNome = new TrabalhadorNomeComparator();
        Collections.sort(trabs, trabComp);
        listar(trabs);
        
        System.out.println("=====================================================");
        System.out.println("TRABALHADORES EM ORDEM DECRESCENTE - NOMES");
        System.out.println("-----------------------------------------------------");
        Collections.sort(trabs, Collections.reverseOrder(trabCompNome));
        listar(trabs);
    }

    private static void listar(List<Trabalhador> trabs) {
        for (Trabalhador trab : trabs) {
            if (trab != null) {
                System.out.printf("%s, vencimento = %.2f€%n", trab.getNome(), 
                                    trab.calcularVencimento());
            }
        }
    }
}