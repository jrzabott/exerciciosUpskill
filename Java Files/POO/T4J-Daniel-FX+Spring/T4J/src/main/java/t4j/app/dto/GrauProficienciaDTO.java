package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;

@JsonPropertyOrder({"valor", "designacao"})
@JacksonXmlRootElement(localName = "grau")
public class GrauProficienciaDTO {

    /**
     * Variável de instância - valorGrauProficiencia do grau de proficiência
     */
    @JacksonXmlProperty(localName = "valor")
    private String valor;
    
    /**
     * Variável de instância - designação do grau de proficiência
     */
    @JacksonXmlProperty(localName = "designacao")
    private String designacao;

    /**
     * Construtor vazio de grau de proficiência
     */
    public GrauProficienciaDTO() {
    }

    /**
     * 
     * @return valorGrauProficiencia do grau de proficiência
     */
    public String getValor() {
        return valor;
    }
    
    /**
     * 
     * @return designação do grau de proficiência
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * 
     * @param valor especifica um novo valorGrauProficiencia de grau de proficiência
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * 
     * @param designacao especifica uma nova designação de grau de proficiência
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public String toString() {
        if (this.valor == null || this.designacao == null) {
            return null;
        }
        return String.format("%s. %s", this.valor, this.designacao);
    }
}
