/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.service;

import java.util.ArrayList;
import upskill.AutarquiaWS.dto.ListaPessoaDTO;
import upskill.AutarquiaWS.dto.Mapper;
import upskill.AutarquiaWS.dto.PessoaDTO;
import upskill.AutarquiaWS.exception.ConversaoException;
import upskill.AutarquiaWS.model.Autarquia;
import upskill.AutarquiaWS.model.Pessoa;
import upskill.AutarquiaWS.repo.Dados;

/**
 *
 * @author user
 */
public class PessoasService {
    
    public static ListaPessoaDTO getPessoas() {
        ListaPessoaDTO listaPessoaDTO;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Pessoa> pessoas = autarquia.getAllPessoas();
        listaPessoaDTO = Mapper.listPessoa2PessoaDTO(pessoas);
        return listaPessoaDTO;
    }
    
    public static PessoaDTO getPessoa(long nif) {
        Autarquia autarquia = Dados.carregarDados();
        Pessoa pessoa = autarquia.getPessoa(nif);
        if (pessoa == null) {
            return null;
        }
        PessoaDTO pesssoaDTO = Mapper.pessoa2PessoaDTO(pessoa);
        if (pesssoaDTO != null) {
            return pesssoaDTO;
        }else {
            throw new ConversaoException("PessoaDTO");
        }
    }
    
    public static void addPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addPessoa(pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }
    
    public static void updatePessoa(long nif, PessoaDTO pessoaDTO){
        Pessoa pessoa = Mapper.pessoaDTO2Pessoa(pessoaDTO);
        if (pessoa != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updatePessoa(nif, pessoa);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }
    
    public static void removePessoa(long nif){
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removePessoa(nif);
        Dados.guardarDados(autarquia);
    }
}
