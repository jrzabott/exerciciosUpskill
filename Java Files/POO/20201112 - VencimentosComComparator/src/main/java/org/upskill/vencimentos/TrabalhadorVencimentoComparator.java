package org.upskill.vencimentos;

import java.util.Comparator;

/**
 * Esta classe permite a construção de uma hierarquia de classes para
 * representarem diferentes tipos de trabalhadores. Especifica membros comuns a
 * todas as classes da hierarquia.
 *
 * @author ISEP-DEI-PPROG
 */
public class TrabalhadorVencimentoComparator implements Comparator<Trabalhador> {

    @Override
    public int compare(Trabalhador o1, Trabalhador o2) {
        return ((o1.calcularVencimento() == o2.calcularVencimento())
                ? 0
                : (o1.calcularVencimento() < o2.calcularVencimento())
                    ? -1
                    : 1
        );
    }
    
   
}
