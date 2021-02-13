package t4j.app.model;

import java.io.Serializable;
import java.util.Objects;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class AreaAtividade implements Serializable {

    /**
     * Variável de instância - código da área de atividade
     */
    private String codigoAreaAtividade;

    /**
     * Variável de instância - descrição breve da área de atividade
     */
    private String descricaoBreve;

    /**
     * Variável de instância - descrição detalhada da área de atividade
     */
    private String descricaoDetalhada;

    /**
     * Construtor completo de área de atividade
     *
     * @param codigoAreaAtividade código da área de atividade
     * @param descricaoBreve descrição breve da área de atividade
     * @param descricaoDetalhada descrição detalhada da área de atividade
     */
    public AreaAtividade(String codigoAreaAtividade, String descricaoBreve, String descricaoDetalhada) {
        setCodigoAreaAtividade(codigoAreaAtividade);
        setDescricaoBreve(descricaoBreve);
        setDescricaoDetalhada(descricaoDetalhada);
    }

    /**
     * Construtor vazio de área de atividade
     */
    public AreaAtividade() {
    }

    /**
     * Construtor cópia de área de atividade
     *
     * @param outraAreaAtividade instância de área de atividade a ser copiada
     */
    public AreaAtividade(AreaAtividade outraAreaAtividade) {
        setCodigoAreaAtividade(outraAreaAtividade.codigoAreaAtividade);
        setDescricaoBreve(outraAreaAtividade.descricaoBreve);
        setDescricaoDetalhada(outraAreaAtividade.descricaoDetalhada);
    }

    /**
     *
     * @return código da área de atividade
     */
    public String getCodigoAreaAtividade() {
        return codigoAreaAtividade;
    }

    /**
     *
     * @return descrição breve da área de atividade
     */
    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    /**
     *
     * @return descrição detalhada da área de atividade
     */
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    /**
     *
     * @param codigoAreaAtividade especifica um novo código da área de atividade
     */
    public void setCodigoAreaAtividade(String codigoAreaAtividade) throws ElementoInvalidoException {
        codigoAreaAtividade = codigoAreaAtividade.trim();
        if (Validacao.validaCodigoAreaAtividade(codigoAreaAtividade)) {
            this.codigoAreaAtividade = codigoAreaAtividade;
        } else {
            throw new ElementoInvalidoException("Código inválido.");
        }
    }

    /**
     *
     * @param descricaoBreve especifica uma nova descrição breve da área de atividade
     */
    public void setDescricaoBreve(String descricaoBreve) throws ElementoInvalidoException {
        descricaoBreve = descricaoBreve.trim();
        if (Validacao.validaDescricaoBreveAreaAtividade(descricaoBreve)) {
            this.descricaoBreve = descricaoBreve;
        } else {
            throw new ElementoInvalidoException("Descrição breve inválida.");
        }
    }

    /**
     *
     * @param descricaoDetalhada especifica uma nova descrição detalhada da área de atividade
     */
    public void setDescricaoDetalhada(String descricaoDetalhada) throws ElementoInvalidoException {
        descricaoDetalhada = descricaoDetalhada.trim();
        if (Validacao.validaDescricaoDetalhadaAreaAtividade(descricaoDetalhada)) {
            this.descricaoDetalhada = descricaoDetalhada;
        } else {
            throw new ElementoInvalidoException("Descrição detalhada inválida.");
        }
    }

    /**
     *
     * @return retorna uma String com a descrição da área de atividade (código, descrição breve, descrição detalhada)
     */
    @Override
    public String toString() {
        return String.format("Área de atividade:\n código = %s\n descrição breve = %s\n descrição detalhada = %s", getCodigoAreaAtividade(), getDescricaoBreve(), getDescricaoDetalhada());
    }

    /**
     *
     * @param outroObjeto instância de área de atividade a ser comparada
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
        AreaAtividade outraArea = (AreaAtividade) outroObjeto;
        return codigoAreaAtividade.equalsIgnoreCase(outraArea.codigoAreaAtividade)
                && descricaoBreve.equalsIgnoreCase(outraArea.descricaoBreve)
                && descricaoDetalhada.equalsIgnoreCase(outraArea.descricaoDetalhada);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigoAreaAtividade);
        hash = 23 * hash + Objects.hashCode(this.descricaoBreve);
        hash = 23 * hash + Objects.hashCode(this.descricaoDetalhada);
        return hash;
    }
}
