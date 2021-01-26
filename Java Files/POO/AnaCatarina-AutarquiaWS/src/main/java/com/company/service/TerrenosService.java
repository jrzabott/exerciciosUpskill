/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dto.FreguesiaDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.Mapper;
import com.company.dto.TerrenoDTO;
import com.company.exception.ConversaoException;
import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.NumeroTerrenoDuplicadoException;
import com.company.model.Autarquia;
import com.company.model.Freguesia;
import com.company.model.ListaTerreno;
import com.company.model.Terreno;
import com.company.repo.Dados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anahristoff
 */
public class TerrenosService {
    
    public static ListaTerrenoDTO getTerrenos() { 
        ListaTerrenoDTO listaTerrenoDTO = null;
        ListaTerreno terrenos = null;
        Autarquia autarquia = Dados.carregarDados(); 
        List<Freguesia> freguesia = autarquia.getAllFreguesias();
        
        for (Freguesia f : freguesia) {
            terrenos = f.getAllTerrenos();
        }
        
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos); 
        return listaTerrenoDTO;
    }

    public static TerrenoDTO getTerreno(int numero) { 
        Terreno terreno = null;
        Autarquia autarquia = Dados.carregarDados(); 
        List<Freguesia> freguesia = autarquia.getAllFreguesias();
        
        for (Freguesia f : freguesia) {
            if(f.getTerrenoByNumero(numero).getNumeroTerreno()==numero){
                terreno = f.getTerrenoByNumero(numero);
            }
        }
        
        if (terreno == null) {
            return null; 
        }
        
        TerrenoDTO terrenoDTO = Mapper.terreno2terrenoDTO(terreno); 
        if (terrenoDTO != null) {
            return terrenoDTO; 
        } else {
            throw new ConversaoException("TerrenoDTO"); 
        }
    }

    public static void addTerreno(TerrenoDTO terrenoDTO, FreguesiaDTO freguesiaDTO) { 
        Terreno terreno = Mapper.terrenoDTO2terreno(terrenoDTO);
        Freguesia freguesia = Mapper.freguesiaDTO2freguesia(freguesiaDTO);
        
        if (terreno != null && freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            List<Freguesia> freguesias = autarquia.getAllFreguesias();
            ListaTerreno lista = null;
                
            if(freguesias.contains(freguesia)){
                for (Freguesia f : freguesias) {
                    if(f.getNomeFreguesia().equals(freguesia.getNomeFreguesia())){
                        lista = f.getTerrenos();
                        for (Terreno t : lista.getTerrenos()) {
                            if(!lista.getTerrenos().contains(terreno)){
                                lista.getTerrenos().add(terreno);
                            }else{
                                throw new NumeroTerrenoDuplicadoException("Terreno já existe");
                            }
                        }
                    }
                }
            }else{
                throw new ElementoNaoExistenteException("Freguesia não existe");
            }
                
            Dados.guardarDados(autarquia);
        }else {
            throw new ConversaoException("TerrenoDTO"); 
        }
    }

    public static void updateTerreno(int numero, TerrenoDTO terrenoDTO) { 
        Terreno terreno = Mapper.terrenoDTO2terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados(); 
            List<Freguesia> freguesia = autarquia.getAllFreguesias();
            for (Freguesia f : freguesia) {
                if(f.getTerrenoByNumero(numero).getNumeroTerreno()==terrenoDTO.getNumero()){
                    f.updateTerreno(numero, terreno);
                }
            }
            Dados.guardarDados(autarquia);
        }else {
            throw new ConversaoException("TerrenoDTO"); 
        }
    }

    public static void removeTerreno(int numero) { 
        Autarquia autarquia = Dados.carregarDados();
        List<Freguesia> freguesia = autarquia.getAllFreguesias();
        
        for (Freguesia f : freguesia) {
                if(f.getTerrenoByNumero(numero).getNumeroTerreno()==numero){
                    f.removeTerreno(numero);
                }
            }
        Dados.guardarDados(autarquia);
    }
    
}
