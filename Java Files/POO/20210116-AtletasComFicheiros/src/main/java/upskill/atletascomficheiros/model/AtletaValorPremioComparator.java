package upskill.atletascomficheiros.model;

import java.util.Comparator;

/**
 *
 * @author Daniel Junior Data de criação: 2020-25-11
 * @version 0.1
 */
public class AtletaValorPremioComparator implements Comparator<Atleta> {

    /**
     *
     * @param o1 - objeto 1
     * @param o2 - objeto 2
     * @return (int) 0 se os prémios forem iguais, (int) -1 se o 1º for menor
     * que o 2º, e (int) 1 se o 1º for maior que o 2º
     */
    @Override
    public int compare(Atleta o1, Atleta o2) {
        return (o1.getPremio() == o2.getPremio())
                ? 0
                : (o1.getPremio() < o2.getPremio())
                ? -1
                : 1;
    }

}
