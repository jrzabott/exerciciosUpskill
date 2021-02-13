/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.controller;

import t4j.app.dto.CategoriaTarefaDTO;
import t4j.app.dto.RegistoAreasAtividadeDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.service.AreaAtividadeService;
import t4j.app.service.CompetenciasTecnicasService;

/**
 *
 * @author user
 */
public class UIDefinirCategoriaTarefaController {

    public UIDefinirCategoriaTarefaController() {
    }

    public RegistoAreasAtividadeDTO getRegistoAreasAtividadeDTO() {
        return AreaAtividadeService.getRegistoAreasAtividade();
    }

    public RegistoCompetenciasTecnicasDTO getRegistoCompetenciasTecnicas() {
        return CompetenciasTecnicasService.getRegistoCompetenciasTecnicas();
    }

    public boolean addCategoriaTarefa(CategoriaTarefaDTO ctdto) {
        return CategoriaTarefasService.addCategoriaTarefa(ctdto);
    }
    
}
