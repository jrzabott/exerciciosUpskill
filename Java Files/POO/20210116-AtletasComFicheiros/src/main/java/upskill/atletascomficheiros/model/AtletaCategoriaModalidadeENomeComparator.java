package upskill.atletascomficheiros.model;

import java.util.Comparator;

/**
 *
 * @author Daniel Junior Data de criação: 2020-24-11
 * @version 0.1
 */
public class AtletaCategoriaModalidadeENomeComparator implements Comparator<Atleta> {

    /**
     *
     * @param o1 - objeto 1
     * @param o2 - objeto 2
     * @return a diferença numérica entre as String: 1. categoria de atleta, 2.
     * atividade desportiva, 3. nome
     */
    @Override
    public int compare(Atleta o1, Atleta o2) {
        if (o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName()) == 0) {
            if (o1.getTipoAtividade().compareToIgnoreCase(o2.getTipoAtividade()) == 0) {
                return o1.getNome().compareToIgnoreCase(o2.getNome());
            } else {
                return o1.getTipoAtividade().compareToIgnoreCase(o2.getTipoAtividade());
            }
        } else {
            return o1.getClass().getSimpleName().compareToIgnoreCase(o2.getClass().getSimpleName());
        }
    }
}
