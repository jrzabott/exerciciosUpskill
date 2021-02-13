/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Plataforma;
import model.Organizacao;
import model.RegistoOrganizacoes;

/**
 *
 * @author nunocastro
 */
public class RegistarOrganizacaoController {
    
    private Plataforma plataforma;
    private RegistoOrganizacoes ro;
    private Organizacao org;
    
    public RegistarOrganizacaoController(){
        this.plataforma = Plataforma.getInstance();
    }
    
    public void novaOrganizacao(String nome, String nif, String endLocal, String endPostal, String localidade, String telefone, String site, String email, String nomeG, String funcao, String telefoneG, String emailG) throws Exception {
        ro = plataforma.getRegistoOrganizacoes();
        org = ro.novaOrganizacao(nome, nif, endLocal, endPostal, localidade, telefone, site, email, nomeG, funcao, telefoneG, emailG);
        if (ro.validaOrganizacao(org)) {
        } else {
            throw new Exception();
        }
    }
    
    public void registaOrganizacao() throws Exception {
        ro.registaOrganizacao(org);
    }
}
