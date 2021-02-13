package t4j.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.commons.validator.UrlValidator;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;
import t4j.app.utils.Validacao;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Organizacao implements Serializable {

    /**
     * Variável de instância - nome da organização
     */
    private String nome;

    /**
     * Variável de instância - nif da organização
     */
    private String nif;

    /**
     * Variável de instância - website da organização
     */
    private String website;

    /**
     * Variável de instância - telefone da organização
     */
    private String telefone;

    /**
     * Variável de instância - email da organização
     */
    private String email;

    /**
     * Variável de instância - endereço da organização
     */
    private EnderecoPostal endereco;

    /**
     * Variável de instância - gestor da organização
     */
    private Colaborador gestor;

    /**
     * Variável de instância - registo de tarefas
     */
    private RegistoTarefas listaTarefas;

    /**
     * Variável de instância - contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    private ArrayList<Colaborador> colaboradores;

    /**
     * Construtor completo de organização
     *
     * @param nome nome da organização
     * @param nif nif da organização
     * @param website website da organização
     * @param telefone telefone da organização
     * @param email email da organização
     * @param endereco endereço da organização
     * @param gestor gestor da organização
     */
    public Organizacao(String nome, String nif, String website, String telefone, String email, EnderecoPostal endereco, Colaborador gestor) {
        this.endereco = endereco;
        this.gestor = gestor;
        this.colaboradores = new ArrayList<Colaborador>();
        this.listaTarefas = new RegistoTarefas();
        setNome(nome);
        setNif(nif);
        setWebsite(website);
        setTelefone(telefone);
        setEmail(email);
    }

    /**
     * Construtor cópia de organização
     *
     * @param organizacao
     */
    public Organizacao(Organizacao organizacao) {
        setNome(organizacao.nome);
        setNif(organizacao.nif);
        setWebsite(organizacao.website);
        setTelefone(organizacao.telefone);
        setEmail(organizacao.email);
        this.endereco = new EnderecoPostal(organizacao.endereco);
        this.gestor = new Colaborador(organizacao.gestor);
        this.colaboradores = new ArrayList<Colaborador>(organizacao.getColaboradores());
        this.listaTarefas = new RegistoTarefas(organizacao.listaTarefas);
    }

    /**
     * Construtor vazio de organização
     */
    public Organizacao() {
        colaboradores = new ArrayList<>();
        endereco = new EnderecoPostal();
        gestor = new Colaborador();
        listaTarefas = new RegistoTarefas();
    }

    /**
     *
     * @return contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    public ArrayList<Colaborador> getColaboradores() {
        return new ArrayList<Colaborador>(this.colaboradores);
    }

    /**
     *
     * @return email da organização
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return endereço da organização
     */
    public EnderecoPostal getEndereco() {
        return endereco;
    }

    /**
     *
     * @return gestor da organização
     */
    public Colaborador getGestor() {
        return gestor;
    }

    /**
     *
     * @return registo de tarefas
     */
    public RegistoTarefas getListaTarefas() {
        return listaTarefas;
    }

    /**
     *
     * @return nif da organização
     */
    public String getNif() {
        return nif;
    }

    /**
     *
     * @return nome da organização
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return telefone da organização
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @return website da organização
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param colaboradores especifica um novo contentor do tipo ArrayList que guarda todas as instâncias do tipo colaborador
     */
    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = new ArrayList<Colaborador>(colaboradores);
    }

    /**
     *
     * @param emailOrganizacao especifica um novo email da organização
     */
    public void setEmail(String emailOrganizacao) throws ElementoInvalidoException {
        emailOrganizacao = emailOrganizacao.trim();
        if (Validacao.validaEmail(emailOrganizacao)) {
            this.email = emailOrganizacao;
        } else {
            throw new ElementoInvalidoException("Email de organização inválido.");
        }
    }

    /**
     *
     * @param nome especifica um novo nome da organização
     * @throws ElementoInvalidoException
     */
    public void setNome(String nome) throws ElementoInvalidoException {
        nome = nome.trim();
        if (Validacao.validaNomeOrganizacao(nome)) {
            this.nome = nome;
        } else {
            throw new ElementoInvalidoException("Nome de organização inválido.");
        }
    }

    /**
     *
     * @param endereco especifica um novo enderço da organização
     */
    public void setEndereco(EnderecoPostal endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @param gestor especifica um novo gestor da organização
     */
    public void setGestor(Colaborador gestor) {
        this.gestor = gestor;
    }

    /**
     *
     * @param listaTarefas especifica uma nova lista de tarefas
     */
    public void setListaTarefas(RegistoTarefas listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    /**
     *
     * @param nif especifica um novo nif da organização
     */
    public void setNif(String nif) throws ElementoInvalidoException {
        nif = nif.trim();
        if (Validacao.validaNif(nif)) {
            this.nif = nif;
        } else {
            throw new ElementoInvalidoException("NIF inválido. Introduza NIF com 9 dígitos.");
        }
    }

    /**
     *
     * @param website especifica um novo website da organização
     * @throws ElementoInvalidoException
     */
    public void setWebsite(String website) throws ElementoInvalidoException {
        website = website.trim();
        String http = "http://";
        if (!website.startsWith("http", 0)) {
            website = http += website;
        }
        if (Validacao.validaWebsiteOrganizacao(website)) {
            this.website = website;
        } else {
            throw new ElementoInvalidoException("Website inválido.");
        }
    }

    /**
     *
     * @param telefone especifica um novo telefone da organização
     */
    public void setTelefone(String telefone) throws ElementoInvalidoException {
        telefone = telefone.trim();
        if (Validacao.validaTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new ElementoInvalidoException("Telefone de organização inválido.");
        }
    }

    /**
     * 
     * @return retorna uma String com a descrição da organização (nome, nif, website, telefone, email, endereço, gestor, lista de colaboradores e lista de tarefas)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organizacao{nome=").append(nome);
        sb.append(", nif=").append(nif);
        sb.append(", website=").append(website);
        sb.append(", telefone=").append(telefone);
        sb.append(", email=").append(email);
        sb.append(", endereco=").append(endereco);
        sb.append(", gestor=").append(gestor);
        sb.append(", colaboradores=").append(colaboradores);
        sb.append(", listaTarefas=").append(listaTarefas);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 
     * @param outroObjeto instância de organização a ser comparada
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
        Organizacao outraOrganizacao = (Organizacao) outroObjeto;
        return nome.equalsIgnoreCase(outraOrganizacao.nome)
                && nif.equalsIgnoreCase(outraOrganizacao.nif)
                && website.equalsIgnoreCase(outraOrganizacao.website)
                && telefone.equalsIgnoreCase(outraOrganizacao.telefone)
                && email.equalsIgnoreCase(outraOrganizacao.email)
                && endereco.equals(outraOrganizacao.endereco)
                && gestor.equals(outraOrganizacao.gestor)
                && colaboradores.equals(outraOrganizacao.colaboradores)
                && listaTarefas.equals(outraOrganizacao.listaTarefas);
    }

    /**
     * 
     * @return Override do hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.nif);
        hash = 79 * hash + Objects.hashCode(this.website);
        hash = 79 * hash + Objects.hashCode(this.telefone);
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.gestor);
        hash = 79 * hash + Objects.hashCode(this.colaboradores);
        hash = 79 * hash + Objects.hashCode(this.listaTarefas);
        return hash;
    }

    /**
     * 
     * @param colaborador instância do tipo colaborador a ser adicionada à lista de colaboradores
     * @return adiciona um novo colaborador à lista de colaboradores e retorn true se foi adicionado e false se não foi adicionado
     */
    public boolean addColaborador(Colaborador colaborador) {
        if (this.colaboradores.contains(colaborador)) {
            throw new ElementoDuplicadoException("Colaborador já existe na organização.");
        }
        return this.colaboradores.add(colaborador);
    }
}
