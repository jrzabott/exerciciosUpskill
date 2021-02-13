package t4j.app.controller;

import t4j.app.dto.OrganizacaoDTO;
import t4j.app.service.OrganizacoesService;

public class UIRegistarOrganizacaoController {

    /**
     *
     * @param odto organização a ser adicionada
     * @return true se registou uma nova organização e false se contrário
     */
    public static boolean registarOrganizacao(OrganizacaoDTO odto) {
        return OrganizacoesService.addOrganizacao(odto);
    }
}
