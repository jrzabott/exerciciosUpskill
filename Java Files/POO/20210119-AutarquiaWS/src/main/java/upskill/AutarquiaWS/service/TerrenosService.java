/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.service;

import java.util.ArrayList;
import upskill.AutarquiaWS.dto.ListaTerrenoDTO;
import upskill.AutarquiaWS.dto.Mapper;
import upskill.AutarquiaWS.dto.TerrenoDTO;
import upskill.AutarquiaWS.exception.ConversaoException;
import upskill.AutarquiaWS.model.Autarquia;
import upskill.AutarquiaWS.model.Freguesia;
import upskill.AutarquiaWS.model.Terreno;
import upskill.AutarquiaWS.repo.Dados;

/**
 *
 * @author user
 */
public class TerrenosService {

    public static void addTerreno(long freguesiaId, TerrenoDTO terrenoDTO) {
        Terreno terreno = Mapper.terrenoDTO2Terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            Freguesia freguesia = autarquia.getFreguesia(freguesiaId);
            if (freguesia != null) {
                freguesia.addTerreno(terreno);
                Dados.guardarDados(autarquia);
            } else {
                throw new ConversaoException("FreguesiaDTO - Freguesia Possivelmente não existe");
            }
        } else {
            throw new ConversaoException("TerrenoDTO");
        }
    }

//    public static ListaTerrenoDTO getTerrenos(){
//        ListaTerrenoDTO listaTerrenoDTO;
//        Autarquia autarquia = Dados.carregarDados();
//        
//        // for all "freguesias" I'm adding all "terrenos"
//        // so we have a huge list with all terrenos.
//        // "Terreno" has a filed with the corresponding "freguesia"
//        ArrayList<Terreno> terrenos;
//        for (Freguesia freguesia : autarquia.getFreguesias()) {
//            terrenos.addAll(freguesia.getTerrenos());
//        }
//        
//        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
//        return listaTerrenoDTO;
//    }
    public static ListaTerrenoDTO getTerrenos(long freguesiaId) {
        ListaTerrenoDTO listaTerrenoDTO;
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(freguesiaId);
        ArrayList<Terreno> terrenos = freguesia.getTerrenos();
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

}
