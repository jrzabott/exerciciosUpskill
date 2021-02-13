package t4j.app.service;

import java.util.ArrayList;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.AreaAtividade;
import t4j.app.model.CompetenciaTecnica;
import t4j.app.model.GrauProficiencia;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoAreasAtividade;
import t4j.app.model.RegistoCompetenciasTecnicas;
import t4j.app.repo.Dados;

public class CompetenciasTecnicasService {

    /**
     *
     * @return o registo de competências técnicas
     */
    public static RegistoCompetenciasTecnicasDTO getRegistoCompetenciasTecnicas() {
        Plataforma plataforma = Dados.carregarDados();
        RegistoCompetenciasTecnicasDTO rctDTO;
        RegistoCompetenciasTecnicas rct = plataforma.getRegistoCompetenciasTecnicas();
        ArrayList<CompetenciaTecnica> listaCT = rct.getCompetenciasTecnicas();
        rctDTO = Mapper.listCompetenciasTecnicas2CompetenciasTecnicasDTO(listaCT);
        return rctDTO;
    }

    /**
     *
     * @param codCT código de competência técnica que se pretende
     * @return uma competência técnica identificada pelo seu código de competência técnica
     */
    public static CompetenciaTecnicaDTO getCompetenciaTecnica(String codCT) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica ct = plataforma.getRegistoCompetenciasTecnicas().getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT);
        if (ct == null) {
            return null;
        }
        CompetenciaTecnicaDTO ctDTO = Mapper.competenciaTecnica2CompetenciaTecnicaDTO(ct);
        if (ctDTO != null) {
            return ctDTO;
        } else {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
    }

    /**
     *
     * @param ctDTO competência técnica a ser adicionada
     * @return true se adicionou uma nova competência técnica passada por parâmetro e false se contrário
     */
    public static boolean addCompetenciaTecnica(CompetenciaTecnicaDTO ctDTO) {
        Plataforma plataforma = Dados.carregarDados();

        // Preparar Area de Atividade. Codigo veio inserido na UI uma vez 
        // que ainda não existe uma AreaAtividadeDTO.
        AreaAtividadeDTO aadto = AreaAtividadeService
                .getAreaAtividade(ctDTO.getAreaAtividade().getCodigo());
        if (aadto == null) {
            throw new ConversaoException("AreaAtividadeDTO");
        }
        ctDTO.setAreaAtividade(aadto);

        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        if (ct != null) {
        } else {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
        boolean result = plataforma.getRegistoCompetenciasTecnicas().addCompetenciaTecnica(ct);
        Dados.guardarDados(plataforma);
        return result;
    }

    /**
     *
     * @param codCT código da competência técnica qe se pretende atualizar
     * @param ctDTO competência técnica identificada pelo seu código de competência técnica a ser atualizada
     */
    public static void updateCompetenciaTecnica(String codCT, CompetenciaTecnicaDTO ctDTO) {
        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        if (ct != null) {
            Plataforma plataforma = Dados.carregarDados();
            plataforma.getRegistoCompetenciasTecnicas().updateCompetenciaTecnica(codCT, ct);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("CompetenciaTecnicaDTO");
        }
    }

    /**
     *
     * @param codCT código da competência técnica que se pretende remover
     */
    public static void removeCompetenciaTecnica(String codCT) {
        Plataforma plataforma = Dados.carregarDados();
        plataforma.getRegistoCompetenciasTecnicas().removeCompetenciaTecnica(codCT);
        Dados.guardarDados(plataforma);
    }

    /**
     *
     * @param grauDTO grau de proficiência que se pretende adicionar à competência técnica passada por parâmetro
     * @param ctDTO competência técnica à qual se pretende adicionar uum grau de proficiência
     * @return true se adicionou um novo grau de proficiência a uma competência técnica DTO passada por parâmetro e false se contrário
     */
    public static boolean addGrauProficiencia(GrauProficienciaDTO grauDTO, CompetenciaTecnicaDTO ctDTO) {
        Plataforma plataforma = Dados.carregarDados();
        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctDTO);
        GrauProficiencia grau = Mapper.grauDTO2Grau(grauDTO);
        boolean result = ct.addGrauProficiencia(grau);
        Dados.guardarDados(plataforma);
        return result;
    }

//    public static boolean addCompetenciaTecnica(String codAreaAtividade, CompetenciaTecnicaDTO ctdto) {
//        // Carregar Dados da Plataforma e obter Area de Atividade a ser utilizada na competência técnica.
//        Plataforma plataforma = Dados.carregarDados();
//        RegistoAreasAtividade raa = plataforma.getRegistoAreasAtividade();
//        AreaAtividade aa = raa.getAreaAtividadeByCodigoAreaAtividade(codAreaAtividade);
//        if (aa == null) {
//            throw new ElementoNaoExistenteException(codAreaAtividade + ": Área de Atividade não existente.");
//        }
//        AreaAtividadeDTO aadto = Mapper.areaAtividade2AreaAtividadeDTO(aa);
//        
//        // Converter Area de Atividade Obtida para DTO e então submeter para conversão.
//        ctdto.setAreaAtividade(aadto);
//        CompetenciaTecnica ct = Mapper.competenciaTecnicaDTO2CompetenciaTecnica(ctdto);
//        if (ct == null) {
//            throw new ConversaoException("CompetenciaTecnicaDTO");
//        }
//
//
//        // Inserir Area de Atividade na CT a ser criada e solicitar o registo.
//        ct.setAreaAtividade(aa);
//        RegistoCompetenciasTecnicas rct = plataforma.getRegistoCompetenciasTecnicas();
//
//        boolean result = rct.addCompetenciaTecnica(ct);
//        Dados.guardarDados(plataforma);
//        return result;
//    }
}
