package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"morada", "codigoPostal", "localidade"})
@JacksonXmlRootElement(localName = "enderecoPostal")
public class EnderecoPostalDTO {

    /**
     * Variável de instância - morada
     */
    @JacksonXmlProperty(localName = "morada")
    private String morada;

    /**
     * Variável de instância - código postal
     */
    @JacksonXmlProperty(localName = "codigoPostal")
    private String codigoPostal;

    /**
     * Variável de instância - localidade
     */
    @JacksonXmlProperty(localName = "localidade")
    private String localidade;

    /**
     * Construtor vazio de endereço postal
     */
    public EnderecoPostalDTO() {
    }

    /**
     *
     * @return morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @return código postal
     */
    public String getCodPostal() {
        return codigoPostal;
    }

    /**
     *
     * @return localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     *
     * @param morada especifica uma nova morada do endereço postal
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     *
     * @param codigoPostal especifica um novo código postal do endereço postal
     */
    public void setCodPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     *
     * @param localidade especifica uma nova localidade do endereço postal
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
