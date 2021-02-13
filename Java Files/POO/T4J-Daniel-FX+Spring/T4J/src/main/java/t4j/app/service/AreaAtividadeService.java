package t4j.app.service;

import java.util.ArrayList;
import t4j.app.dto.Mapper;
import t4j.app.dto.RegistoAreasAtividadeDTO;
import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.exception.ConversaoException;
import t4j.app.model.AreaAtividade;
import t4j.app.model.Plataforma;
import t4j.app.model.RegistoAreasAtividade;
import t4j.app.repo.Dados;

public class AreaAtividadeService {

    /**
     * 
     * @return o registo de áreas de atividade
     */
    public static RegistoAreasAtividadeDTO getRegistoAreasAtividade() {
        RegistoAreasAtividadeDTO raadto;
        Plataforma plataforma = Dados.carregarDados();
        RegistoAreasAtividade raa = plataforma.getRegistoAreasAtividade();
        ArrayList<AreaAtividade> areasAtividade = raa.getAreasAtividade();
        raadto = Mapper.listAtividade2AreaAtividadeDTO(areasAtividade);
        return raadto;
    }

    /**
     * 
     * @param codigo código da área de atividade que se pretende
     * @return uma área de atividade identificada pelo seu código
     */
    public static AreaAtividadeDTO getAreaAtividade(String codigo) {
        Plataforma plataforma = Dados.carregarDados();
        AreaAtividade area = plataforma.getRegistoAreasAtividade().getAreaAtividadeByCodigoAreaAtividade(codigo);
        AreaAtividadeDTO areaAtividadeDTO = Mapper.areaAtividade2AreaAtividadeDTO(area);
        return areaAtividadeDTO;
    }

    /**
     * 
     * @param areaDTO área de atividade a ser adicionada
     * @return true se adicionou uma nova área de atividade passada por parâmetro e false se contrário
     */
    public static boolean addAreaAtividade(AreaAtividadeDTO areaDTO) {
        AreaAtividade area = Mapper.areaAtividadeDTO2AreaAtividade(areaDTO);
        Plataforma plataforma = Dados.carregarDados();
        RegistoAreasAtividade raa = plataforma.getRegistoAreasAtividade();
        boolean result = raa.addAreaAtividade(area);
        Dados.guardarDados(plataforma);
        return result;
    }

    /**
     * 
     * @param codigoAreaAtividade código da área de atividade que se pretende atualizar
     * @param areaAtividadeDTO área de atividade identificada pelo seu código de área de atividade a ser atualizada
     */
    public static void updateAreaAtividade(String codigoAreaAtividade, AreaAtividadeDTO areaAtividadeDTO) {
        AreaAtividade areaAtividade = Mapper.areaAtividadeDTO2AreaAtividade(areaAtividadeDTO);
        Plataforma plataforma = Dados.carregarDados();
        if (areaAtividade != null) {
            plataforma.getRegistoAreasAtividade().updateAreaAtividade(codigoAreaAtividade, areaAtividade);
            Dados.guardarDados(plataforma);
        } else {
            throw new ConversaoException("AreaAtividadeDTO");
        }
    }

    /**
     * 
     * @param codigoAreaAtividade código da área de atividade que se pretende remover
     */
    public static void removeAreasAtividade(String codigoAreaAtividade) {
        Plataforma plataforma = Dados.carregarDados();
        RegistoAreasAtividade raa = plataforma.getRegistoAreasAtividade();
        raa.removeAreaAtividade(codigoAreaAtividade);
        Dados.guardarDados(plataforma);
    }
}
