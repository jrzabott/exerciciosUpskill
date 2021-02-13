package t4j.app.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

public class Tarefa implements Serializable {

    /**
     * Variável de instância - referência da tarefa
     */
    private String referencia;

    /**
     * Variável de instância - designação da tarefa
     */
    private String designacao;

    /**
     * Variável de instância - descrição informal da tarefa
     */
    private String descricaoInformal;

    /**
     * Variável de instância - descrição técnica da tarefa
     */
    private String descricaoTecnica;

    /**
     * Variável de instância - duração estimada para conclusão da tarefa
     */
    private String duracaoEstimada;

    /**
     * Variável de instância - custo estimado da implememtação da tarefa
     */
    private String custoEstimado;

    /**
     * Variável de instância - categoria em qual a tarefa se enquadra
     */
    private CategoriaTarefa categoria;

    /**
     * Construtor completo de tarefa
     *
     * @param referencia referência da tarefa
     * @param designacao designação da tarefa
     * @param descricaoInformal descrição informal da tarefa
     * @param descricaoTecnica descrição técnica da tarefa
     * @param duracaoEstimada duração estimada para conclusão da tarefa
     * @param custoEstimado custo estimado da implememtação da tarefa
     * @param categoria categoria em qual a tarefa se enquadra
     */
    public Tarefa(String referencia, String designacao, String descricaoInformal, String descricaoTecnica, String duracaoEstimada, String custoEstimado, CategoriaTarefa categoria) {
        setReferencia(referencia);
        setDesignacao(designacao);
        setDescricaoInformal(descricaoInformal);
        setDescricaoTecnica(descricaoTecnica);
        setDuracaoEstimada(duracaoEstimada);
        this.custoEstimado = custoEstimado;
        this.categoria = new CategoriaTarefa(categoria);
    }

    /**
     * Construtor vazio de tarefa
     */
    public Tarefa() {
        categoria = new CategoriaTarefa();
    }

    /**
     * Construtor cópia de tarefa
     *
     * @param outraTarefa instância de tarefa a ser copiada
     */
    public Tarefa(Tarefa outraTarefa) {
        setReferencia(outraTarefa.referencia);
        setDesignacao(outraTarefa.designacao);
        setDescricaoInformal(outraTarefa.descricaoInformal);
        setDescricaoTecnica(outraTarefa.descricaoTecnica);
        setDuracaoEstimada(outraTarefa.duracaoEstimada);
        this.custoEstimado = custoEstimado;
        this.categoria = new CategoriaTarefa(outraTarefa.categoria);
    }

    /**
     *
     * @return referência da tarefa
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     *
     * @return designação da tarefa
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     *
     * @return descrição informal da tarefa
     */
    public String getDescricaoInformal() {
        return descricaoInformal;
    }

    /**
     *
     * @return descrição técnica da tarefa
     */
    public String getDescricaoTecnica() {
        return descricaoTecnica;
    }

    /**
     *
     * @return duração estimada para conclusão da tarefa
     */
    public String getDuracaoEstimada() {
        return duracaoEstimada;
    }

    /**
     *
     * @return custo estimado da implememtação da tarefa
     */
    public String getCustoEstimado() {
        return custoEstimado;
    }

    /**
     *
     * @return categoria em qual a tarefa se enquadra
     */
    public CategoriaTarefa getCategoria() {
        return categoria;
    }

    /**
     *
     * @param referencia especifica uma nova referência de tarefa
     */
    public void setReferencia(String referencia) throws ElementoInvalidoException {
        referencia = referencia.trim();
        if (Validacao.validaReferenciaTarefa(referencia)) {
            this.referencia = referencia;
        } else {
            throw new ElementoInvalidoException("Referência inválida.");
        }
    }

    /**
     *
     * @param designacao especifica uma nova designação de tarefa
     */
    public void setDesignacao(String designacao) throws ElementoInvalidoException {
        designacao = designacao.trim();
        if (Validacao.validaDesignacaoTarefa(designacao)) {
            this.designacao = designacao;
        } else {
            throw new ElementoInvalidoException("Designação inválida.");
        }
    }

    /**
     *
     * @param descricaoInformal especifica uma nova descrição informal de tarefa
     */
    public void setDescricaoInformal(String descricaoInformal) throws ElementoInvalidoException {
        descricaoInformal = descricaoInformal.trim();
        if (Validacao.validaDescricaoInformalTarefa(descricaoInformal)) {
            this.descricaoInformal = descricaoInformal;
        } else {
            throw new ElementoInvalidoException("Descrição informal inválida.");
        }
    }

    /**
     *
     * @param descricaoTecnica especifica uma nova descrição técnica de tarefa
     */
    public void setDescricaoTecnica(String descricaoTecnica) throws ElementoInvalidoException {
        descricaoTecnica = descricaoTecnica.trim();
        if (Validacao.validaDescricaoTecnicaTarefa(descricaoTecnica)) {
            this.descricaoTecnica = descricaoTecnica;
        } else {
            throw new ElementoInvalidoException("Descrição técnica inválida.");
        }
    }

    /**
     *
     * @param duracaoEstimada especifica uma nova duração estimada de tarefa
     */
    public void setDuracaoEstimada(String duracaoEstimada) throws ElementoInvalidoException {
        duracaoEstimada = duracaoEstimada.trim();
        if (Validacao.validaDuracaoEstimadaTarefa(duracaoEstimada)) {
            this.duracaoEstimada = duracaoEstimada;
        } else {
            throw new ElementoInvalidoException("Duração inválida.");
        }
    }

    /**
     *
     * @param custoEstimado especifica um novo custo estimado de tarefa
     */
    // check and round number before set
    public void setCustoEstimado(String custoEstimado) throws ElementoInvalidoException {
        custoEstimado = custoEstimado.trim();
        if (Validacao.validaCustoEstimadoTarefa(custoEstimado)) {
            this.custoEstimado = custoEstimado;
        } else {
            throw new ElementoInvalidoException("Custo inválido.");
        }
    }

    /**
     *
     * @param categoria especifica uma nova categoria em qual a tarefa se enquadra
     */
    public void setCategoria(CategoriaTarefa categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @return retorna uma String com a descrição da tarefa (referência, designação, descrição informal, descrição técnica, duração estimada, custo estimado, categoria)
     */
    @Override
    public String toString() {
        return String.format("Tarefa:\n referência = %s\n designação = %s\n descrição informal = %s\n descrição técnica = %s\n duração estimada = %s\n custo estimado = %s\n categoria = %s", getReferencia(), getDesignacao(), getDescricaoInformal(), getDescricaoTecnica(), getDuracaoEstimada(), getCustoEstimado(), getCategoria().toString());
    }

    /**
     *
     * @param outroObjeto instância de tarefa a ser comparada
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
        Tarefa outraTarefa = (Tarefa) outroObjeto;
        return referencia.equalsIgnoreCase(outraTarefa.referencia)
                && designacao.equalsIgnoreCase(outraTarefa.designacao)
                && descricaoInformal.equalsIgnoreCase(outraTarefa.descricaoInformal)
                && descricaoTecnica.equalsIgnoreCase(outraTarefa.descricaoTecnica)
                && duracaoEstimada.equalsIgnoreCase(outraTarefa.duracaoEstimada)
                && custoEstimado.equalsIgnoreCase(outraTarefa.custoEstimado)
                && categoria.equals(outraTarefa.categoria);
    }

    /**
     *
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.referencia);
        hash = 97 * hash + Objects.hashCode(this.designacao);
        hash = 97 * hash + Objects.hashCode(this.descricaoInformal);
        hash = 97 * hash + Objects.hashCode(this.descricaoTecnica);
        hash = 97 * hash + Objects.hashCode(this.duracaoEstimada);
        hash = 97 * hash + Objects.hashCode(this.custoEstimado);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        return hash;
    }
}
