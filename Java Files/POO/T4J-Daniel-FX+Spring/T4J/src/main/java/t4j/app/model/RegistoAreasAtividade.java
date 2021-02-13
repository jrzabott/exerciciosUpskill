package t4j.app.model;

import java.io.Serializable;
import t4j.app.exception.ElementoDuplicadoException;
import java.util.ArrayList;
import java.util.Objects;
import t4j.app.exception.ElementoNaoExistenteException;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class RegistoAreasAtividade implements Serializable {

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo área de atividade
     */
    private ArrayList<AreaAtividade> areasAtividade;

    /**
     * Construtor completo de lista de áreas de atividade
     *
     * @param areasAtividade contentor do tipo ArrayList que guarda todas as instâncias do tipo área de atividade
     */
    public RegistoAreasAtividade(ArrayList<AreaAtividade> areasAtividade) {
        this.areasAtividade = new ArrayList<>(areasAtividade);
    }

    /**
     * Construtor vazio de lista de áreas de atividade
     */
    public RegistoAreasAtividade() {
        this.areasAtividade = new ArrayList<>();
    }

    /**
     * Construtor cópia de lista de áreas de atividade
     *
     * @param outroRegistoAreasAtividade instância do tipo lista de áreas de atividade a ser copiada
     */
    public RegistoAreasAtividade(RegistoAreasAtividade outroRegistoAreasAtividade) {
        this.areasAtividade = new ArrayList<>(outroRegistoAreasAtividade.areasAtividade);
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo área de atividade
     */
    public ArrayList<AreaAtividade> getAreasAtividade() {
        return areasAtividade;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registo de áreas de atividade:\n");
        for (int i = 0; i < areasAtividade.size(); i++) {
            areasAtividade.get(i).toString();
            sb.append(areasAtividade.get(i).toString());
        }
        return sb.toString();
    }

    /**
     *
     * @param codigoAreaAtividade código de área de atividade
     * @return a área de atividade ao qual pertence o código de área de atividade introduzido por parâmetro
     */
    public AreaAtividade getAreaAtividadeByCodigoAreaAtividade(String codigoAreaAtividade) {
        for (AreaAtividade area : areasAtividade) {
            if (area.getCodigoAreaAtividade().equalsIgnoreCase(codigoAreaAtividade)) {
                return area;
            }
        }
        return null;
    }

    /**
     *
     * @param areaAtividade instância do tipo área de atividade a ser adicionada ao contentor areasAtividade
     * @return 
     */
    public boolean addAreaAtividade(AreaAtividade areaAtividade) {
        boolean eValida;
        eValida = validaAreaAtividade(areaAtividade) != null;
        return (eValida) ? areasAtividade.add(areaAtividade) : false;
    }

    /**
     *
     * @param codigoAreaAtividade código de área de atividade
     * @throws ElementoNaoExistenteException
     */
    public void removeAreaAtividade(String codigoAreaAtividade) throws ElementoNaoExistenteException {
        AreaAtividade areaAtividade = null;
        for (int i = 0; i < this.areasAtividade.size(); i++) {
            areaAtividade = this.areasAtividade.get(i);
            if (areaAtividade.getCodigoAreaAtividade().equals(codigoAreaAtividade)) {
                this.areasAtividade.remove(i);
                return;
            } else {
                throw new ElementoNaoExistenteException(codigoAreaAtividade + ": Não existe esta área de atividade!!");
            }
        }
    }

    /**
     *
     * @param codigoAreaAtividade código de área de atividade
     * @param aa instância do tipo área de atividade a ser atualizada no contentor areasAtividade
     * @throws ElementoNaoExistenteException
     */
    public void updateAreaAtividade(String codigoAreaAtividade, AreaAtividade aa) throws ElementoNaoExistenteException {
        AreaAtividade areaAtividade = null;
        boolean updated = false;
        for (int i = 0; i < this.areasAtividade.size(); i++) {
            areaAtividade = this.areasAtividade.get(i);
            if (areaAtividade.getCodigoAreaAtividade().equals(codigoAreaAtividade)) {
                this.areasAtividade.set(i, aa);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(codigoAreaAtividade + ": Não existe esta área de atividade!!");
        }
    }

    /**
     *
     * @param outroObjeto instância de lista de áreas de atividade a ser comparada
     * @return reescrita do método equals e retorna um booleano
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        RegistoAreasAtividade outroRegistoAreaAtividade = (RegistoAreasAtividade) outroObjeto;
        return areasAtividade.equals(outroRegistoAreaAtividade.areasAtividade);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.areasAtividade);
        return hash;
    }

    /**
     *
     * @param areaAtividade instância do tipo área de atividade a ser validada
     * @return retorna a instância do tipo área de atividade para adição ao contentor depois de validada
     * @throws ElementoDuplicadoException
     */
    private AreaAtividade validaAreaAtividade(AreaAtividade areaAtividade) throws ElementoDuplicadoException {
        if (getAreaAtividadeByCodigoAreaAtividade(areaAtividade.getCodigoAreaAtividade()) == null) {
            return areaAtividade;
        } else {
            throw new ElementoDuplicadoException("Já existe uma área de atividade com esse código!");
        }
    }
}
