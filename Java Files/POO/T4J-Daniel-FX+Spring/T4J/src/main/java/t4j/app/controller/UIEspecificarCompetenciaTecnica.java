package t4j.app.controller;

import java.util.ArrayList;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.service.CompetenciasTecnicasService;

public class UIEspecificarCompetenciaTecnica {

    /**
     *
     * @param codigoCompetenciaTecnica código da competência técnica
     * @param descricaoBreve descrição breve da competência técnica
     * @param descricaoDetalhada descrição detalhada da competência técnica
     * @param areaAtividade área de atividade da competência técnica
     * @param grausProficiencia grau de proficiência da competência técnica
     * @return true se foi especificada uma nova competência técnica e false se contrário
     */
    public static boolean especificarCompetenciaTecnica(String codigoCompetenciaTecnica, String descricaoBreve, String descricaoDetalhada, AreaAtividadeDTO areaAtividade, ArrayList<GrauProficienciaDTO> grausProficiencia) {
        boolean result;
        CompetenciaTecnicaDTO ctdto = new CompetenciaTecnicaDTO();
        ctdto.setCodigoCompetenciaTecnica(codigoCompetenciaTecnica);
        ctdto.setDescricaoBreve(descricaoBreve);
        ctdto.setDescricaoDetalhada(descricaoDetalhada);
        ctdto.setAreaAtividade(areaAtividade);
        ctdto.setGrausProficiencia(grausProficiencia);
        result = CompetenciasTecnicasService.addCompetenciaTecnica(ctdto);
        return result;
    }
}
