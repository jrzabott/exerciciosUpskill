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
import upskill.AutarquiaWS.exception.ElementoNaoExistenteException;
import upskill.AutarquiaWS.model.Autarquia;
import upskill.AutarquiaWS.model.Freguesia;
import upskill.AutarquiaWS.model.Terreno;
import upskill.AutarquiaWS.repo.Dados;

/**
 *
 * @author user
 */
public class TerrenosService {

    public static void removeTerreno(long freguesiaId, long terrenoId) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(freguesiaId);
        if (freguesia != null) {
            freguesia.removeTerreno(terrenoId);
        }
        Dados.guardarDados(autarquia);
    }

    public static TerrenoDTO getTerreno(long freguesiaId, long terrenoId) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(freguesiaId);
        if (freguesia == null) {
            return null;
        }
        Terreno terreno = freguesia.getTerreno(terrenoId);
        if (terreno == null) {
            return null;
        }
        TerrenoDTO terrenoDTO = Mapper.terreno2TerrenoDTO(terreno);
        if (terrenoDTO != null) {
            return terrenoDTO;
        } else {
            throw new ConversaoException("TerrenoDTO");
        }

    }

    public static ListaTerrenoDTO getTerrenos(long freguesiaId) {
        ListaTerrenoDTO listaTerrenoDTO;
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(freguesiaId);
        ArrayList<Terreno> terrenos = freguesia.getTerrenos();
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

    public static void addTerreno(long freguesiaId, TerrenoDTO terrenoDTO) {
        Terreno terreno = Mapper.terrenoDTO2Terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            Freguesia freguesia = autarquia.getFreguesia(freguesiaId);
            if (freguesia != null) {
                freguesia.addTerreno(terreno);
                Dados.guardarDados(autarquia);
            } else {
                throw new ElementoNaoExistenteException(freguesiaId + ": Freguesia inexistente.");
            }
        } else {
            throw new ConversaoException("TerrenoDTO");
        }
    }

    public static void updateTerreno(long freguesiaId, long terrenoId, TerrenoDTO terrenoDTO) {
        Terreno terreno = Mapper.terrenoDTO2Terreno(terrenoDTO);
        if (terreno != null) {
            Autarquia autarquia=Dados.carregarDados();
            Freguesia freguesia=autarquia.getFreguesia(freguesiaId);
            if (freguesia == null) {
                throw new ElementoNaoExistenteException("Freguesia inexistente.");
            }
            freguesia.updateTerreno(terrenoId, terreno);
            Dados.guardarDados(autarquia);
        } else{
            throw new ConversaoException("TerrenoDTO");
        }
    }

}
