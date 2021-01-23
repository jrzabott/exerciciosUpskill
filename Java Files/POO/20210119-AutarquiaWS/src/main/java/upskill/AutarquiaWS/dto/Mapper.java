/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.dto;

import upskill.AutarquiaWS.model.Data;
import upskill.AutarquiaWS.model.Funcionario;
import upskill.AutarquiaWS.model.Pessoa;
import java.util.ArrayList;
import upskill.AutarquiaWS.exception.TerrenoErroTipoTerrenoException;
import upskill.AutarquiaWS.model.Freguesia;
import upskill.AutarquiaWS.model.Terreno;
import upskill.AutarquiaWS.model.TerrenoCircular;
import upskill.AutarquiaWS.model.TerrenoRetangular;
import upskill.AutarquiaWS.model.TerrenoTriangular;

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

    public static ListaTerrenoDTO listTerreno2TerrenoDTO(ArrayList<Terreno> terrenos) {
        ArrayList<TerrenoDTO> terrenosDTO = new ArrayList<>();
        for (Terreno terreno : terrenos) {
            try {
                TerrenoDTO terrenoDTO = terreno2TerrenoDTO(terreno);
                terrenosDTO.add(terrenoDTO);
            } catch (NullPointerException e) {
            }
        }
        ListaTerrenoDTO listaTerrenoDTO = new ListaTerrenoDTO();
        listaTerrenoDTO.setTerrenos(terrenosDTO);
        return listaTerrenoDTO;
    }

    public static TerrenoDTO terreno2TerrenoDTO(Terreno terreno) {
                TerrenoDTO terrenoDTO = null;
        switch (terreno.getShape()) {
            case CIRCLE:
                terrenoDTO = new TerrenoCircularDTO();
                ((TerrenoCircularDTO) terrenoDTO).setNumber(terreno.getNumber());
                ((TerrenoCircularDTO) terrenoDTO).setRadius(((TerrenoCircular) terreno).getRadius());
                break;
            case RECTANGLE:
                terrenoDTO = new TerrenoRetangularDTO();
                ((TerrenoRetangularDTO) terrenoDTO).setNumber(terreno.getNumber());
                ((TerrenoRetangularDTO) terrenoDTO).setLength(((TerrenoRetangular) terreno).getLength());
                ((TerrenoRetangularDTO) terrenoDTO).setWidth(((TerrenoRetangular) terreno).getWidth());
                break;
            case TRIANGLE:
                terrenoDTO = new TerrenoTriangularDTO();
                ((TerrenoTriangularDTO) terrenoDTO).setNumber(terreno.getNumber());
                ((TerrenoTriangularDTO) terrenoDTO).setA(((TerrenoTriangular) terreno).getA());
                ((TerrenoTriangularDTO) terrenoDTO).setB(((TerrenoTriangular) terreno).getB());
                ((TerrenoTriangularDTO) terrenoDTO).setC(((TerrenoTriangular) terreno).getC());
                break;
            default:
                throw new TerrenoErroTipoTerrenoException(terrenoDTO.getShape().name() + ": Erro no Tipo de Terreno.");
        }
        return terrenoDTO;
    }

    public static Terreno terrenoDTO2Terreno(TerrenoDTO terrenoDTO) {
        Terreno terreno = null;
        switch (terrenoDTO.getShape()) {
            case CIRCLE:
                terreno = new TerrenoCircular();
                ((TerrenoCircular) terreno).setNumber(terrenoDTO.getNumber());
                ((TerrenoCircular) terreno).setRadius(((TerrenoCircularDTO) terrenoDTO).getRadius());
                break;
            case RECTANGLE:
                terreno = new TerrenoRetangular();
                ((TerrenoRetangular) terreno).setNumber(terrenoDTO.getNumber());
                ((TerrenoRetangular) terreno).setLength(((TerrenoRetangularDTO) terrenoDTO).getLength());
                ((TerrenoRetangular) terreno).setWidth(((TerrenoRetangularDTO) terrenoDTO).getWidth());
                break;
            case TRIANGLE:
                terreno = new TerrenoTriangular();
                ((TerrenoTriangular) terreno).setNumber(terrenoDTO.getNumber());
                ((TerrenoTriangular) terreno).setA(((TerrenoTriangularDTO) terrenoDTO).getA());
                ((TerrenoTriangular) terreno).setB(((TerrenoTriangularDTO) terrenoDTO).getB());
                ((TerrenoTriangular) terreno).setC(((TerrenoTriangularDTO) terrenoDTO).getC());
                break;
            default:
                throw new TerrenoErroTipoTerrenoException(terrenoDTO.getShape().name() + ": Erro no Tipo de Terreno.");
        }
        return terreno;
    }

    public static PessoaDTO pessoa2PessoaDTO(Pessoa pessoa) throws NullPointerException {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNif(pessoa.getNif());
        pessoaDTO.setNome(pessoa.getNome());
        DataDTO dataDTO = data2dataDTO(pessoa.getNascimento());
        pessoaDTO.setNascimento(dataDTO);
        return pessoaDTO;
    }

    public static Pessoa pessoaDTO2Pessoa(PessoaDTO pessoaDTO) throws NullPointerException {
        Pessoa pessoa = null;
        Data data = dataDTO2data(pessoaDTO.getNascimento());
        pessoa = new Pessoa(pessoaDTO.getNif(), pessoaDTO.getNome(), data);
        return pessoa;
    }

    public static ListaPessoaDTO listPessoa2PessoaDTO(ArrayList<Pessoa> pessoas) throws NullPointerException {
        ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            try {
                PessoaDTO pessoaDTO = pessoa2PessoaDTO(pessoa);
                pessoasDTO.add(pessoaDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaPessoaDTO listaPessoaDTO = new ListaPessoaDTO();
        listaPessoaDTO.setPessoas(pessoasDTO);
        return listaPessoaDTO;
    }

    public static FuncionarioDTO funcionario2FuncionarioDTO(Funcionario funcionario) throws
            NullPointerException {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNif(funcionario.getNif());
        funcionarioDTO.setNome(funcionario.getNome());
        DataDTO dataDTO = data2dataDTO(funcionario.getNascimento());
        funcionarioDTO.setNascimento(dataDTO);
        funcionarioDTO.setNumeroFuncionario(funcionario.getNumeroFuncionario());
        funcionarioDTO.setCargo(funcionario.getCargo());
        return funcionarioDTO;
    }

    public static Funcionario funcionarioDTO2Funcionario(FuncionarioDTO funcionarioDTO) throws NullPointerException {
        Funcionario funcionario = null;
        Data data = dataDTO2data(funcionarioDTO.getNascimento());
        funcionario = new Funcionario(funcionarioDTO.getNif(),
                funcionarioDTO.getNome(), data,
                funcionarioDTO.getNumeroFuncionario(),
                funcionarioDTO.getCargo());
        return funcionario;
    }

    public static ListaFuncionarioDTO listFuncionario2FuncionarioDTO(ArrayList<Funcionario> funcionarios) throws NullPointerException {
        ArrayList<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            try {
                FuncionarioDTO funcionarioDTO = funcionario2FuncionarioDTO(funcionario);
                funcionariosDTO.add(funcionarioDTO);
            } catch (NullPointerException e) {
//does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaFuncionarioDTO listaFuncionarioDTO = new ListaFuncionarioDTO();
        listaFuncionarioDTO.setFuncionarios(funcionariosDTO);
        return listaFuncionarioDTO;
    }

    public static FreguesiaDTO freguesia2FreguesiaDTO(Freguesia freguesia) {
        FreguesiaDTO freguesiaDTO = new FreguesiaDTO();
        freguesiaDTO.setId(freguesia.getId());
        freguesiaDTO.setNome(freguesia.getNome());
        return freguesiaDTO;
    }

    public static Freguesia freguesiaDTO2Freguesia(FreguesiaDTO freguesiaDTO) {
        // TODO freguesiaDTO2Freguesia
        Freguesia freguesia = new Freguesia();
        freguesia.setId(freguesiaDTO.getId());
        freguesia.setNome(freguesiaDTO.getNome());
        return freguesia;
    }

    public static ListaFreguesiaDTO listFreguesia2FreguesiaDTO(ArrayList<Freguesia> freguesias) {
        ArrayList<FreguesiaDTO> freguesiasDTO = new ArrayList<>();
        for (Freguesia freguesia : freguesias) {
            try {
                FreguesiaDTO freguesiaDTO = freguesia2FreguesiaDTO(freguesia);
                freguesiasDTO.add(freguesiaDTO);
            } catch (NullPointerException e) {
                // Does nothing (blergh!)
            }
        }
        ListaFreguesiaDTO listaFreguesiaDTO = new ListaFreguesiaDTO();
        listaFreguesiaDTO.setFreguesias(freguesiasDTO);
        return listaFreguesiaDTO;
    }
}
