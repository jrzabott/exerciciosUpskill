package t4j.app.controller;

import java.util.ArrayList;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.service.CompetenciasTecnicasService;

public class UIDefinirCompetenciaTecnicaController {

//    public boolean adicionarCompetenciaTecnica(String codAreaAtividade, CompetenciaTecnicaDTO ctdto) {
//        return CompetenciasTecnicasService.addCompetenciaTecnica(codAreaAtividade, ctdto);
//    }
    /**
     *
     * @param ctdto competência técnica a ser adicionada
     * @return adiciona uuma nova competência técnica
     */
    public boolean adicionarCompetenciaTecnica(CompetenciaTecnicaDTO ctdto) {
        return CompetenciasTecnicasService.addCompetenciaTecnica(ctdto);
    }
}
