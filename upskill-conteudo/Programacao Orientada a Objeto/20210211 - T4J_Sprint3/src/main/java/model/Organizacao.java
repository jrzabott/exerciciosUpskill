/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nunocastro
 */
public class Organizacao {
    private String nome;
    private String nif;
    private String telefone;
    private String site;
    private String email;
    private Endereco endereco;
    private Colaborador gestor;
    
    public Organizacao (String nome, String nif, Endereco end, String telefone, String site, String email, Colaborador colab) {
        this.nome = nome;
        this.nif = nif;
        this.email = email;
        this.telefone = telefone;
        this.site = site;
        this.gestor = colab;
        this.endereco = end;
    }
    
    public static Endereco novoEndereco(String endLocal, String endPostal, String localidade) {
        return new Endereco(endLocal, endPostal, localidade);
    }
    
    public static Colaborador novoColaborador(String nomeG, String funcao, String telefoneG, String emailG) {
        return new Colaborador(nomeG, funcao, telefoneG, emailG);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Endereco getEndereco() {
        return this.endereco;
    }
}
