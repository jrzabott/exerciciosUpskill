package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"referencia", "designacao", "descricaoInformal", "descricaoTecnica", "duracaoEstimada", "custoEstimado", "categoria"})
@JacksonXmlRootElement(localName = "tarefa")
public class TarefaDTO {

    /**
     * Variável de instância - referência da tarefa
     */
    @JacksonXmlProperty(localName = "referencia")
    private String referencia;

    /**
     * Variável de instância - designação da tarefa
     */
    @JacksonXmlProperty(localName = "designacao")
    private String designacao;

    /**
     * Variável de instância - descrição informal da tarefa
     */
    @JacksonXmlProperty(localName = "descricaoInformal")
    private String descricaoInformal;

    /**
     * Variável de instância - descrição técnica da tarefa
     */
    @JacksonXmlProperty(localName = "descricaoTecnica")
    private String descricaoTecnica;

    /**
     * Variável de instância - duração estimada para conclusão da tarefa
     */
    @JacksonXmlProperty(localName = "duracaoEstimada")
    private String duracaoEstimada;

    /**
     * Variável de instância - custo estimado da implememtação da tarefa
     */
    @JacksonXmlProperty(localName = "custoEstimado")
    private String custoEstimado;

    /**
     * Variável de instância - categoria em qual a tarefa se enquadra
     */
    @JacksonXmlProperty(localName = "categoria")
    private CategoriaTarefaDTO categoria;

    /**
     * Construtor vazio de tarefa
     */
    public TarefaDTO() {
        this.categoria = new CategoriaTarefaDTO();
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
    public CategoriaTarefaDTO getCategoria() {
        return categoria;
    }

    /**
     *
     * @param referencia especifica uma nova referência de tarefa
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     *
     * @param designacao especifica uma nova designação de tarefa
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     *
     * @param descricaoInformal especifica uma nova descrição informal de tarefa
     */
    public void setDescricaoInformal(String descricaoInformal) {
        this.descricaoInformal = descricaoInformal;
    }

    /**
     *
     * @param descricaoTecnica especifica uma nova descrição técnica de tarefa
     */
    public void setDescricaoTecnica(String descricaoTecnica) {
        this.descricaoTecnica = descricaoTecnica;
    }

    /**
     *
     * @param duracaoEstimada especifica uma nova duração estimada de tarefa
     */
    public void setDuracaoEstimada(String duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }

    /**
     *
     * @param custoEstimado especifica um novo custo estimado de tarefa
     */
    public void setCustoEstimado(String custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    /**
     *
     * @param categoria especifica uma nova categoria em qual a tarefa se enquadra
     */
    public void setCategoria(CategoriaTarefaDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarefaDTO:\nreferencia: ").append(referencia);
        sb.append("\ndesignacao: ").append(designacao);
        sb.append("\ndescricaoInformal: ").append(descricaoInformal);
        sb.append("\ndescricaoTecnica: ").append(descricaoTecnica);
        sb.append("\nduracaoEstimada: ").append(duracaoEstimada);
        sb.append("\ncustoEstimado: ").append(custoEstimado);
        sb.append("\ncategoria: ").append(categoria.toString());
        sb.append("\n\n");
        return sb.toString();
    }
    
    
}
