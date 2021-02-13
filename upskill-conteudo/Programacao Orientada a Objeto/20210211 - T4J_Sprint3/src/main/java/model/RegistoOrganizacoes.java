/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.IAlgoritmoGeradorPasswords;
import model.Colaborador;
import model.Endereco;
import model.Email;
import model.Plataforma;
import model.Organizacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nunocastro
 */
public class RegistoOrganizacoes {

    private List<Organizacao> ListaOrganizacoes = new ArrayList<Organizacao>();
    private Plataforma plataforma;
    Colaborador colab;
    public RegistoOrganizacoes(Plataforma plataforma){
        this.plataforma = plataforma;
    };
    
    public Organizacao novaOrganizacao(String nome, String nif, String endLocal, String endPostal, String localidade, String telefone, String site, String emailO, String nomeG, String funcao, String telefoneG, String emailG) {
        Endereco end = Organizacao.novoEndereco(endLocal, endPostal, localidade);
        colab = Organizacao.novoColaborador(nomeG, funcao, telefoneG, emailG);
        //
        return new Organizacao(nome, nif, end, telefone, site, emailO, colab);
    }

    public boolean validaOrganizacao(Organizacao org) {
        return true;
    }

    public void registaOrganizacao(Organizacao org) throws Exception {
        if (validaOrganizacao(org)) {
            
            //Gerar password
            IAlgoritmoGeradorPasswords agp = plataforma.getAlgoritmoGeradorPwd();
            String pwd = agp.geraPassword();
                    
            //Criar utilizador
            plataforma.getUsersAPI().registerUserWithRoles(colab.getEmailG(), colab.getEmailG(), pwd, "gestor,colaborador");

            //Adicionar a organização
            //addOrganizacao(org);

            //Persitir.
            IPersistable odb = new OrganizacaoDB(org);
            //IPersistable odb = new OrganizacaoFiles(org);
            odb.save();
          
//            OrganizacaoPersistable opdb = new OrganizacaoPersistable(1, org);
//            IPersistable ipdb = opdb.getPersistenceObject();
//            ipdb.save();

            //Enviar email com credenciais de acesso.
            Email email = new Email();
            email.setTo(colab.getEmailG());
            email.setSubject("Envio de credenciais para acesso à plataforma");
            email.setText("username " + colab.getEmailG() + " ... password " + pwd);
            email.send();
        } else {
            throw new Exception();
        }
    }

    private void addOrganizacao(Organizacao org) {
        ListaOrganizacoes.add(org);
    }
}
