/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.FreguesiaDTO;
import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.Mapper;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Freguesia;
import com.company.repo.Dados;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class FreguesiasService {
    
        public static ListaFreguesiaDTO getFreguesias() {
        ListaFreguesiaDTO listaFreguesiaDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Freguesia> freguesias = autarquia.getAllFreguesias();
        listaFreguesiaDTO = Mapper.listFreguesia2FreguesiaDTO(freguesias);
        return listaFreguesiaDTO;
    
}
    public static FreguesiaDTO getFreguesia(int id) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(id);
        if (freguesia == null) {
            return null;
        }
        FreguesiaDTO freguesiaDTO = Mapper.freguesia2FreguesiaDTO(freguesia);
        if (freguesiaDTO != null) {
            return freguesiaDTO;
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static void addFreguesia(FreguesiaDTO freguesiaDTO) {
        Freguesia freguesia = Mapper.freguesiaDTO2Freguesia(freguesiaDTO);
        if (freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addFreguesia(freguesia);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static void updateFreguesia(int id, FreguesiaDTO freguesiaDTO) {
        Freguesia freguesia = Mapper.freguesiaDTO2Freguesia(freguesiaDTO);
        if (freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateFreguesia(id, freguesia);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("PessoaDTO");
        }
    }

    public static void removeFreguesia(int id) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removeFreguesia(id);
        Dados.guardarDados(autarquia);
    }
}
