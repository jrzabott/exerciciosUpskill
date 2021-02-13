package t4j.app.service;

import java.util.ArrayList;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoGrausProficienciaDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.Plataforma;
import t4j.app.repo.Dados;

public class GrausProficienciaService {


    /**
     *
     * @param codCT código da competência técnica da qual se pretende o registo de graus de proficiência
     * @return o registo de graus de proficiência de uma competência técnica identifica pelo código de competência técnica
     */
    public static RegistoGrausProficienciaDTO getGrausProficiencia(String codCT) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica competenciaTecnica = plataforma.getRegistoCompetenciasTecnicas().getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
        ArrayList<GrauProficiencia> grausProficiencia = competenciaTecnica.getGrausProficiencia();
        RegistoGrausProficienciaDTO registoGrausProficienciaDTO = Mapper.listGrau2GrauDTO(grausProficiencia);
        return registoGrausProficienciaDTO;
    }

    /**
     *
     * @param codCT código da competência técnica da qual que pretende obter um grau de proficiência identificada pelo seu valor
     * @param valor valor do grau de proficiência que se pretende
     * @return um grau de proficiência identificado pelo seu valor e que pertende a uma competência técnica identificada pelo código de competência técnica
     */
    public static GrauProficienciaDTO getGrauProficiencia(String codCT, String valor) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica competenciaTecnica = plataforma.getRegistoCompetenciasTecnicas().getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
        if (competenciaTecnica == null) {
            return null;
        }
        GrauProficiencia grauProficiencia = competenciaTecnica.getGrauProficiencia(valor);
        if (grauProficiencia == null) {
            return null;
        }
        GrauProficienciaDTO grauProficienciaDTO = Mapper.grau2GrauDTO(grauProficiencia);
        if (grauProficienciaDTO != null) {
            return grauProficienciaDTO;
        } else {
            throw new ConversaoException("GrauProficienciaDTO");
        }
    }

    /**
     *
     * @param codCT código de competência técnica da qual se pretende adicionar um grau de proficiência
     * @param grauProficienciaDTO grau de proficiência que se pretende adicionar à competência técnica identificada pelo código de competência técnica
     */
    public static void addGrauProficiencia(String codCT, GrauProficienciaDTO grauProficienciaDTO) {
        GrauProficiencia grauProficiencia = Mapper.grauDTO2Grau(grauProficienciaDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (grauProficiencia != null) {
            CompetenciaTecnica competenciaTecnica = plataforma.getRegistoCompetenciasTecnicas().getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
            if (competenciaTecnica != null) {
                competenciaTecnica.addGrauProficiencia(grauProficiencia);
                Dados.guardarDados(plataforma);
            } else {
                throw new ElementoNaoExistenteException(codCT + ": Competência técnica não existe");
            }
        } else {
            throw new ConversaoException("GrauProficienciaDTO");
        }
    }

    /**
     *
     * @param codCT código da competência técnica à qual pertende atualizar o grau de proficiência identificado pelo seu valor
     * @param valor do valor do grau de proficiência que se pretende atualizar
     * @param grauProficienciaDTO grau de proficiência a ser atualizado identificado pelo seu valor de grau de proficiência e que corresponde a uma competência técnica identificada pelo seu código de competência técnica
     */
    public static void updateGrauProficiencia(String codCT, String valor, GrauProficienciaDTO grauProficienciaDTO) {
        GrauProficiencia grauProficiencia = Mapper.grauDTO2Grau(grauProficienciaDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (grauProficiencia != null) {
            CompetenciaTecnica competenciaTecnica = plataforma.getRegistoCompetenciasTecnicas().getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
            if (competenciaTecnica == null) {
                throw new ElementoNaoExistenteException(codCT + ": Competência técnica não existe");
            }
            competenciaTecnica.updateGrauProficiencia(codCT, grauProficiencia);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("TerrenoDTO");
        }
    }

    /**
     *
     * @param codCT código da competência técnica da qual se pretende remover um grau de proficiência identificado pelo seu valor
     * @param valor valor do grau de proficiência que se pretende remover pertencente à competência técnica identificada pelo código de competência técnica
     */
    public static void removeGrauProficiencia(String codCT, String valor) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica competenciaTecnica = plataforma.getRegistoCompetenciasTecnicas().getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
        if (competenciaTecnica != null) {
            competenciaTecnica.removeGrauProficiencia(valor);
        }
        Dados.guardarDados(plataforma);
    }
}
