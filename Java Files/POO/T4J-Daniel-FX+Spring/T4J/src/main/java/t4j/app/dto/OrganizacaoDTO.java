package t4j.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

@JsonPropertyOrder({
    "nomeOrganizacao", "nifOrganizacao", "websiteOrganizacao",
    "telefoneOrganizacao", "emailOrganizacao", "enderecoPostal",
    "gestor", "colaboradores"
})
@JacksonXmlRootElement(localName = "organizacao")
public class OrganizacaoDTO {

    /**
     * Variável de instância - nome da organização
     */
    @JacksonXmlProperty(localName = "nomeOrganizacao")
    private String nomeOrganizacao;

    /**
     * Variável de instância - nif da organização
     */
    @JacksonXmlProperty(localName = "nifOrganizacao")
    private String nifOrganizacao;

    /**
     * Variável de instância - website da organização
     */
    @JacksonXmlProperty(localName = "websiteOrganizacao")
    private String websiteOrganizacao;

    /**
     * Variável de instância - telefone da organização
     */
    @JacksonXmlProperty(localName = "telefoneOrganizacao")
    private String telefoneOrganizacao;

    /**
     * Variável de instância - email da organização
     */
    @JacksonXmlProperty(localName = "emailOrganizacao")
    private String emailOrganizacao;

    /**
     * Variável de instância - endereço da organização
     */
    @JacksonXmlProperty(localName = "enderecoPostal")
    private EnderecoPostalDTO enderecoPostalDTO;

    /**
     * Variável de instância - gestor da organização
     */
    @JacksonXmlProperty(localName = "gestor")
    private ColaboradorDTO gestorDTO;

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    @JacksonXmlProperty(localName = "colaboradores")
    private ArrayList<ColaboradorDTO> colaboradores;

    /**
     * Construtor vazio de organização
     */
    public OrganizacaoDTO() {
        this.enderecoPostalDTO = new EnderecoPostalDTO();
        this.gestorDTO = new ColaboradorDTO();
        this.colaboradores = new ArrayList<>();
    }

    /**
     *
     * @return nome da organização
     */
    public String getNomeOrganizacao() {
        return nomeOrganizacao;
    }

    /**
     *
     * @return website da organização
     */
    public String getWebsiteOrganizacao() {
        return websiteOrganizacao;
    }

    /**
     *
     * @return nif da organização
     */
    public String getNifOrganizacao() {
        return nifOrganizacao;
    }

    /**
     *
     * @return telefone da organização
     */
    public String getTelefoneOrganizacao() {
        return telefoneOrganizacao;
    }

    /**
     *
     * @return email da organização
     */
    public String getEmailOrganizacao() {
        return emailOrganizacao;
    }

    /**
     *
     * @return endereço da organização
     */
    public EnderecoPostalDTO getEnderecoPostalDTO() {
        return enderecoPostalDTO;
    }

    /**
     *
     * @return gestor da organização
     */
    public ColaboradorDTO getGestorDTO() {
        return gestorDTO;
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    public ArrayList<ColaboradorDTO> getColaboradores() {
        return colaboradores;
    }

    /**
     *
     * @param nomeOrganizacao especifica um novo nome da organização
     */
    public void setNomeOrganizacao(String nomeOrganizacao) {
        this.nomeOrganizacao = nomeOrganizacao;
    }

    /**
     *
     * @param websiteOrganizacao especifica um novo website da organização
     */
    public void setWebsiteOrganizacao(String websiteOrganizacao) {
        this.websiteOrganizacao = websiteOrganizacao;
    }

    /**
     *
     * @param nifOrganizacao especifica um novo nif da organização
     */
    public void setNifOrganizacao(String nifOrganizacao) {
        this.nifOrganizacao = nifOrganizacao;
    }

    /**
     *
     * @param telefoneOrganizacao especifica um novo telefone da organização
     */
    public void setTelefoneOrganizacao(String telefoneOrganizacao) {
        this.telefoneOrganizacao = telefoneOrganizacao;
    }

    /**
     *
     * @param emailOrganizacao especifica um novo email da organização
     */
    public void setEmailOrganizacao(String emailOrganizacao) {
        this.emailOrganizacao = emailOrganizacao;
    }

    /**
     *
     * @param enderecoPostalDTO especifica um novo enderço da organização
     */
    public void setEnderecoPostalDTO(EnderecoPostalDTO enderecoPostalDTO) {
        this.enderecoPostalDTO = enderecoPostalDTO;
    }

    /**
     *
     * @param gestorDTO especifica um novo gestor da organização
     */
    public void setGestorDTO(ColaboradorDTO gestorDTO) {
        this.gestorDTO = gestorDTO;
    }

    /**
     *
     * @param colaboradores especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    public void setColaboradores(ArrayList<ColaboradorDTO> colaboradores) {
        this.colaboradores = colaboradores;
    }

    /**
     *
     * @return retorna uma String com a descrição da organização (nome, nif, website, telefone, email, endereço, gestor, lista de colaboradores)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nomeOrganizacao: ").append(nomeOrganizacao);
        sb.append(", websiteOrganizacao: ").append(websiteOrganizacao);
        sb.append(", nifOrganizacao: ").append(nifOrganizacao);
        sb.append(", telefoneOrganizacao: ").append(telefoneOrganizacao);
        sb.append(", emailOrganizacao: ").append(emailOrganizacao);
        sb.append(", enderecoPostalDTO: ").append(enderecoPostalDTO);
        sb.append(", gestorDTO: ").append(gestorDTO);
        sb.append(", colaboradores: ").append(colaboradores);
        sb.append("\n");
        return sb.toString();
    }

    /**
     *
     * @return retorna uma String com a descrição da organização (nome, nif, website, telefone, email)
     */
    public String toShortString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nif: ").append(nifOrganizacao);
        sb.append(", Nome: ").append(nomeOrganizacao);
        sb.append(", Website: ").append(websiteOrganizacao);
        sb.append(", Telefone: ").append(telefoneOrganizacao);
        sb.append(", Email: ").append(emailOrganizacao);
        return sb.toString();
    }
}
