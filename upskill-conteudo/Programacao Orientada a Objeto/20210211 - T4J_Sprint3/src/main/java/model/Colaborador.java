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
public class Colaborador {
    private String nomeG;
    private String funcao;
    private String telefoneG;
    private String emailG;

    public Colaborador(String nomeG, String funcao, String telefoneG, String emailG) {
        this.nomeG = nomeG;
        this.funcao = funcao;
        this.telefoneG = telefoneG;
        this.emailG = emailG;
    }

    public String getNomeG() {
        return nomeG;
    }

    public void setNomeG(String nomeG) {
        this.nomeG = nomeG;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTelefoneG() {
        return telefoneG;
    }

    public void setTelefoneG(String telefoneG) {
        this.telefoneG = telefoneG;
    }

    public String getEmailG() {
        return emailG;
    }

    public void setEmailG(String emailG) {
        this.emailG = emailG;
    }
    
    
}
