/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.service;

import java.util.ArrayList;
import upskill.AutarquiaWS.dto.FuncionarioDTO;
import upskill.AutarquiaWS.dto.ListaFuncionarioDTO;
import upskill.AutarquiaWS.dto.Mapper;
import upskill.AutarquiaWS.exception.ConversaoException;
import upskill.AutarquiaWS.model.Autarquia;
import upskill.AutarquiaWS.model.Funcionario;
import upskill.AutarquiaWS.repo.Dados;

/**
 *
 * @author user
 */
public class FuncionariosService {

    public static ListaFuncionarioDTO getFuncionarios() {
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Funcionario> funcionarios = autarquia.getFuncionarios();
        ListaFuncionarioDTO listaFuncionarioDTO = Mapper.listFuncionario2FuncionarioDTO(funcionarios);
        return listaFuncionarioDTO;
    }

    public static FuncionarioDTO getFuncionario(int nr) {
        Autarquia autarquia = Dados.carregarDados();
        Funcionario funcionario = autarquia.getFuncionario(nr);
        if (funcionario == null) {
            return null;
        }
        FuncionarioDTO funcionarioDTO = Mapper.funcionario2FuncionarioDTO(funcionario);
        if (funcionarioDTO != null) {
            return funcionarioDTO;
        } else {
            throw new ConversaoException("FuncionarioDTO");
        }
    }

    public static void addFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = Mapper.funcionarioDTO2Funcionario(funcionarioDTO);
        if (funcionario != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addFuncionario(funcionario);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("FuncionarioDTO");
        }
    }
    
    public static void updateFuncionario(int nr, FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = Mapper.funcionarioDTO2Funcionario(funcionarioDTO);
        if (funcionario != null) {
            Autarquia autarquia=Dados.carregarDados();
            autarquia.updateFuncionario(nr, funcionario);
            Dados.guardarDados(autarquia);
        } else{
            throw new ConversaoException("FuncionarioDTO");
        }
    }
    
    public static void removeFuncionario(int nr){
        Autarquia autarquia=Dados.carregarDados();
        autarquia.removeFuncionario(nr);
        Dados.guardarDados(autarquia);
    }
}
