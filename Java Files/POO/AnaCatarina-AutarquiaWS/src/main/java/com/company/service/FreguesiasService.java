
package com.company.service;

import com.company.dto.FreguesiaDTO;
import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.ListaTerrenoDTO;
import com.company.dto.Mapper;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Freguesia;
import com.company.model.ListaTerreno;
import com.company.repo.Dados;
import java.util.List;


public class FreguesiasService {
    
    public static ListaFreguesiaDTO getFreguesias() { 
        ListaFreguesiaDTO listaFreguesiaDTO = null;
        Autarquia autarquia = Dados.carregarDados(); 
        List<Freguesia> freguesia = autarquia.getAllFreguesias();
        
        listaFreguesiaDTO = Mapper.listFreguesia2FreguesiaDTO(freguesia); 
        return listaFreguesiaDTO;
    }

    public static FreguesiaDTO getFreguesia(String nome) { 
        FreguesiaDTO freguesiaDTO = null;
        Autarquia autarquia = Dados.carregarDados(); 
        List<Freguesia> freguesias = autarquia.getAllFreguesias();
        
        for (Freguesia f : freguesias) {
            if(f.getNomeFreguesia().compareTo(nome)==0){
                freguesiaDTO = Mapper.freguesia2freguesiaDTO(f);
            }
        }
        if (freguesias == null) {
            return null; 
        }
        
        if (freguesiaDTO != null) {
            return freguesiaDTO; 
        } else {
            throw new ConversaoException("FreguesiaDTO"); 
        }
    }

    public static void addFreguesia(FreguesiaDTO freguesiaDTO) { 
        Freguesia freguesia = Mapper.freguesiaDTO2freguesia(freguesiaDTO); 
        if (freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            List<Freguesia> freguesias = autarquia.getAllFreguesias();
            
            if(!freguesias.contains(freguesia)){
                freguesias.add(freguesia);
            }
            
            Dados.guardarDados(autarquia);
        }else {
            throw new ConversaoException("TerrenoDTO"); 
        }
    }

    public static void updateFreguesia(String nome, FreguesiaDTO freguesiaDTO) { 
        ListaTerreno listaTerreno = Mapper.listTerrenoDTO2Terreno(freguesiaDTO.getTerreno());
        if (listaTerreno != null) {
            Autarquia autarquia = Dados.carregarDados(); 
            List<Freguesia> freguesia = autarquia.getAllFreguesias();
            for (Freguesia f : freguesia) {
                if(f.getNomeFreguesia().equalsIgnoreCase(nome)){
                    f.setNomeFreguesia(nome);
                    f.setListaTerrenos(listaTerreno);
                }
            }
            Dados.guardarDados(autarquia);
        }else {
            throw new ConversaoException("PessoaDTO"); 
        }
    }

    public static void removeFreguesia(String nome) { 
        Autarquia autarquia = Dados.carregarDados();
        List<Freguesia> freguesia = autarquia.getAllFreguesias();
        
        for (Freguesia f : freguesia) {
                if(f.getNomeFreguesia().equalsIgnoreCase(nome)){
                    freguesia.remove(f);
                }
            }
        Dados.guardarDados(autarquia);
    }
    
}
