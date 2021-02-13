package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class ErroUsersAPIDTO {

    /**
     * Variável de instância - mensagem de erro
     */
    @JsonProperty(value = "error")
    String error;
    
    /**
     * Variável de instância - código do erro
     */
    int errorCode;

    /**
     * Construtor vazio
     */
    public ErroUsersAPIDTO() {
    }

    /**
     * 
     * @return mensagem de erro
     */
    public String getErro() {
        return error;
    }
    
    /**
     * 
     * @return código do erro
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * 
     * @param erro especifica uma nova mensagem de erro
     */
    public void setErro(String erro) {
        this.error = erro;
    }

    /**
     * 
     * @param errorCode especifica um novo código de erro
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 
     * @return retorna uma string com a descrição da mensagem de erro
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(error);
        return sb.toString();
    }
}
