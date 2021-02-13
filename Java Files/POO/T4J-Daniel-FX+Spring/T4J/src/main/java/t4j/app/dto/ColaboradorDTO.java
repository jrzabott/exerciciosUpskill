package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome", "funcao", "telefone", "email"})
@JacksonXmlRootElement(localName = "colaborador")
public class ColaboradorDTO {

    /**
     * Variável de instância - nome do colaborador
     */
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    /**
     * Variável de instância - função do colaborador
     */
    @JacksonXmlProperty(localName = "funcao")
    private String funcao;

    /**
     * Variável de instância - telefone do colaborador
     */
    @JacksonXmlProperty(localName = "telefone")
    private String telefone;

    /**
     * Variável de instância - email do colaborador
     */
    @JacksonXmlProperty(localName = "email")
    private String email;

    /**
     * Construtor vazio do colaborador
     */
    public ColaboradorDTO() {
    }

    /**
     *
     * @return nome do colaborador
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return função do colaborador
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     *
     * @return telefone do colaborador
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return email do colaborador
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param nome especifica um novo nome nome do colaborador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param funcao especifica uma nova função do colaborador
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     *
     * @param telefone especifica um novo telefone do colaborador
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @param email especifica um novo email do colaborador
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
