package t4j.app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "erro")
public class ErroDTO {

    /**
     * Variável de instância - mensagem de erro
     */
    @JacksonXmlProperty(localName = "mensagem")
    private String mensagemErro;

    /**
     * 
     * @param e mensagem de erro
     */
    public ErroDTO(Exception e) {
        mensagemErro = e.getMessage();
// e.printStackTrace();
    }

    /**
     * Construtor vazio
     */
    public ErroDTO() {
    }

    /**
     * 
     * @return mensagem de erro
     */
    public String getMensagemErro() {
        return mensagemErro;
    }

    /**
     * 
     * @param mensagemErro mensagem de erro
     */
    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }
}
