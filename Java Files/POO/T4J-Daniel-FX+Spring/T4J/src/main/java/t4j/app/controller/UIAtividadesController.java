package t4j.app.controller;

import t4j.app.dto.AreaAtividadeDTO;
import t4j.app.service.AreaAtividadeService;

public class UIAtividadesController {

    /**
     * 
     * @param codigoAreaAtividade código da área de atividade a ser registada
     * @param descBreve descrição breve da área de atividade a ser registada
     * @param descDetalhada descrição detalhada da área de atividade a ser registada
     * @return true se registo de uma nova área de atividade efetuado e false se contrário
     */
    public static boolean registarAreaAtividade(String codigoAreaAtividade, String descBreve, String descDetalhada) {
        boolean result;
        AreaAtividadeDTO aadto = new AreaAtividadeDTO();
        aadto.setCodigo(codigoAreaAtividade);
        aadto.setDescBreve(descBreve);
        aadto.setDescDetalhada(descDetalhada);

        result = AreaAtividadeService.addAreaAtividade(aadto);
        return result;
    }
}
