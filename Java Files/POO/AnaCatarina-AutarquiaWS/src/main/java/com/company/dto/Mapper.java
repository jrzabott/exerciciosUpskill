
package com.company.dto;

import com.company.model.Data;
import com.company.model.Freguesia;
import com.company.model.Funcionario; 
import com.company.model.Pessoa;
import com.company.model.Terreno;
import com.company.model.ListaTerreno;
import java.util.ArrayList; 
import java.util.List;

public class Mapper {

    public static DataDTO data2dataDTO(Data data) throws NullPointerException { 
        DataDTO dataDTO = new DataDTO();
        dataDTO.setDia(data.getDia());
        dataDTO.setMes(data.getMes());
        dataDTO.setAno(data.getAno());
        return dataDTO; 
    }

    public static Data dataDTO2data(DataDTO dataDTO) throws NullPointerException { 
        Data data = null;
        data = new Data(dataDTO.getDia(), dataDTO.getMes(), dataDTO.getAno());
        return data; 
    }
    
    public static Terreno terrenoDTO2terreno(TerrenoDTO terrenoDTO) throws NullPointerException{
        Terreno terreno = null;
        terreno = new Terreno(terrenoDTO.getNumero(), terrenoDTO.getFormato(), terrenoDTO.getArea());
        return terreno;
    }
    
    public static TerrenoDTO terreno2terrenoDTO(Terreno terreno) throws NullPointerException{
        TerrenoDTO terrenoDTO = new TerrenoDTO();
        terrenoDTO.setArea(terreno.getAreaTerreno());
        terrenoDTO.setFormato(terreno.getFormatoTerreno());
        terrenoDTO.setNumero(terreno.getNumeroTerreno());
        return terrenoDTO;
    }
    
    public static ListaTerrenoDTO listTerreno2TerrenoDTO(ListaTerreno terrenos) throws NullPointerException{
        ListaTerrenoDTO listaTerrenosDTO = new ListaTerrenoDTO(); 
        
        for (Terreno terreno : terrenos.getTerrenos()) {
            try {
                TerrenoDTO terrenoDTO = terreno2terrenoDTO(terreno); 
                listaTerrenosDTO.getTerrenos().add(terrenoDTO);
            }catch (NullPointerException e) {
            //does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaTerrenoDTO listaTerrenoDTO = new ListaTerrenoDTO(); 
        listaTerrenoDTO.setTerrenos(listaTerrenosDTO.getTerrenos());
        return listaTerrenoDTO;
    }
    
    public static ListaTerreno listTerrenoDTO2Terreno(ListaTerrenoDTO terrenosDTO) throws NullPointerException{
        ListaTerreno listaTerrenos = new ListaTerreno(); 
        for (TerrenoDTO terrenoDTO : terrenosDTO.getTerrenos()) {
            try {
                Terreno terreno = terrenoDTO2terreno(terrenoDTO); 
                listaTerrenos.getTerrenos().add(terreno);
            }catch (NullPointerException e) {
            //does nothing. Actually, nothing is added to arraylist
            }
        }
            ListaTerreno listaTerreno = new ListaTerreno(); 
            listaTerreno.setTerrenos(listaTerrenos.getTerrenos());
            return listaTerreno;
    }
    
    public static Freguesia freguesiaDTO2freguesia(FreguesiaDTO freguesiaDTO) throws NullPointerException{
        Freguesia freguesia = null;
        freguesia = new Freguesia(freguesiaDTO.getNome(), listTerrenoDTO2Terreno(freguesiaDTO.getTerreno()));
        return freguesia;
    }
    
    public static FreguesiaDTO freguesia2freguesiaDTO(Freguesia freguesia) throws NullPointerException{
        FreguesiaDTO freguesiaDTO = new FreguesiaDTO();
        freguesiaDTO.setNome(freguesia.getNomeFreguesia());
        freguesiaDTO.setTerreno(listTerreno2TerrenoDTO(freguesia.getTerrenos()));
        return freguesiaDTO;
    }
    
    public static ListaFreguesiaDTO listFreguesia2FreguesiaDTO(List<Freguesia> freguesias) throws NullPointerException{
        ArrayList<FreguesiaDTO> freguesiasDTO = new ArrayList<>();
        for (Freguesia freguesia : freguesias) {
            try {
                FreguesiaDTO freguesiaDTO = freguesia2freguesiaDTO(freguesia); 
                freguesiasDTO.add(freguesiaDTO);
            }catch (NullPointerException e) {
            //does nothing. Actually, nothing is added to arraylist
            }
        }
            ListaFreguesiaDTO listaFreguesiaDTO = new ListaFreguesiaDTO(); 
            listaFreguesiaDTO.setFreguesias(freguesiasDTO);
            return listaFreguesiaDTO;
    }
    

    public static PessoaDTO pessoa2PessoaDTO(Pessoa pessoa) throws NullPointerException { 
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNif(pessoa.getNif());
        pessoaDTO.setNome(pessoa.getNome());
        DataDTO dataDTO = data2dataDTO(pessoa.getNascimento()); 
        pessoaDTO.setNascimento(dataDTO);
//        ListaTerrenoDTO terrenoDTO = new ListaTerrenoDTO(listTerreno2TerrenoDTO(pessoa.getTerrenos()));
        ListaTerrenoDTO terrenoDTO = new ListaTerrenoDTO();
        terrenoDTO.setTerrenos(
                listTerreno2TerrenoDTO(pessoa.getTerrenos())
                        .getTerrenos()
        );
        pessoaDTO.setTerrenos(terrenoDTO);
        return pessoaDTO;
    }

    public static Pessoa pessoaDTO2Pessoa(PessoaDTO pessoaDTO) throws NullPointerException { 
        Pessoa pessoa = null;
        Data data = dataDTO2data(pessoaDTO.getNascimento());
        ListaTerreno terrenos = listTerrenoDTO2Terreno(pessoaDTO.getTerrenos());
        pessoa = new Pessoa(pessoaDTO.getNif(), pessoaDTO.getNome(), data, terrenos);
        return pessoa;
    }
 
    public static ListaPessoaDTO listPessoa2PessoaDTO(List<Pessoa> pessoas) throws NullPointerException {
        ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>(); 
        for (Pessoa pessoa : pessoas) {
            try {
                PessoaDTO pessoaDTO = pessoa2PessoaDTO(pessoa); 
                pessoasDTO.add(pessoaDTO);
            }catch (NullPointerException e) {
            //does nothing. Actually, nothing is added to arraylist
            }
        }
            ListaPessoaDTO listaPessoaDTO = new ListaPessoaDTO(); 
            listaPessoaDTO.setPessoas(pessoasDTO);
            return listaPessoaDTO;
    }

    public static FuncionarioDTO funcionario2FuncionarioDTO(Funcionario funcionario) throws NullPointerException {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(); 
        funcionarioDTO.setNif(funcionario.getNif()); 
        funcionarioDTO.setNome(funcionario.getNome());
        DataDTO dataDTO = data2dataDTO(funcionario.getNascimento()); 
        funcionarioDTO.setNascimento(dataDTO); 
//        ListaTerrenoDTO terrenoDTO = new ListaTerrenoDTO(listTerreno2TerrenoDTO(funcionario.getTerrenos()));
        ListaTerrenoDTO terrenoDTO = new ListaTerrenoDTO();
        terrenoDTO.setTerrenos((List<TerrenoDTO>) listTerreno2TerrenoDTO(funcionario.getTerrenos()));
        funcionarioDTO.setTerrenos(terrenoDTO);
        funcionarioDTO.setNumeroFuncionario(funcionario.getNumeroFuncionario()); 
        funcionarioDTO.setCargo(funcionario.getCargo());
        return funcionarioDTO; 
    }

    public static Funcionario funcionarioDTO2Funcionario(FuncionarioDTO funcionarioDTO) throws NullPointerException {
        Funcionario funcionario = null;
        Data data = dataDTO2data(funcionarioDTO.getNascimento());
        ListaTerreno terrenos = listTerrenoDTO2Terreno(funcionarioDTO.getTerrenos());
        funcionario = new Funcionario(funcionarioDTO.getNif(), funcionarioDTO.getNome(), data, terrenos, funcionarioDTO.getNumeroFuncionario(), funcionarioDTO.getCargo());
        return funcionario; 
    }

    public static ListaFuncionarioDTO listFuncionario2FuncionarioDTO(ArrayList<Funcionario> funcionarios) throws NullPointerException {
        ArrayList<FuncionarioDTO> funcionariosDTO = new ArrayList<>(); 
        for (Funcionario funcionario : funcionarios) {
            try {
                FuncionarioDTO funcionarioDTO = funcionario2FuncionarioDTO(funcionario); 
                funcionariosDTO.add(funcionarioDTO);
            }catch (NullPointerException e) {
            //does nothing. Actually, nothing is added to arraylist
            } 
        }
        ListaFuncionarioDTO listaFuncionarioDTO = new ListaFuncionarioDTO(); 
        listaFuncionarioDTO.setFuncionarios(funcionariosDTO);
        return listaFuncionarioDTO;
    }    
}

