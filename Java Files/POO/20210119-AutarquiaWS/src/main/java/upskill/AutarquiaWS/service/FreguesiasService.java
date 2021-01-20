/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.service;

import java.util.ArrayList;
import upskill.AutarquiaWS.dto.FreguesiaDTO;
import upskill.AutarquiaWS.dto.ListaFreguesiaDTO;
import upskill.AutarquiaWS.dto.Mapper;
import upskill.AutarquiaWS.exception.ConversaoException;
import upskill.AutarquiaWS.model.Autarquia;
import upskill.AutarquiaWS.model.Freguesia;
import upskill.AutarquiaWS.repo.Dados;

/**
 *
 * @author user
 */
public class FreguesiasService {

    public static ListaFreguesiaDTO getFreguesias() {
        ListaFreguesiaDTO listaFreguesiaDTO;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Freguesia> freguesias  = autarquia.getFreguesias();
        listaFreguesiaDTO = Mapper.listFreguesia2FreguesiaDTO(freguesias);
        return listaFreguesiaDTO;
    }
    
    public static FreguesiaDTO getFreguesia(long id){
        Autarquia autarquia=Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(id);
        if (freguesia == null) {
            return null;
        }
        FreguesiaDTO freguesiaDTO = Mapper.freguesia2FreguesiaDTO(freguesia);
        if (freguesiaDTO != null) {
            return freguesiaDTO;
        } else {
            throw new ConversaoException("FreguesiaDTO");
        }
    }
    
    public static void addFreguesia(FreguesiaDTO freguesiaDTO){
        Freguesia freguesia = Mapper.freguesiaDTO2Freguesia(freguesiaDTO);
            if (freguesia != null) {
                Autarquia autarquia = Dados.carregarDados();
                autarquia.addFreguesia(freguesia);
                Dados.guardarDados(autarquia);
            } else {
                throw new ConversaoException("FreguesiaDTO");
            }
    }
    
    public static void updateFreguesia(long id, FreguesiaDTO freguesiaDTO) {
        Freguesia freguesia=Mapper.freguesiaDTO2Freguesia(freguesiaDTO);
        if (freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateFreguesia(id, freguesia);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("FreguesiaDTO");
        }
    }
    
    public static void removeFreguesia(long id){
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removeFreguesia(id);
        Dados.guardarDados(autarquia);
    }
}
