package t4j.app.controller;

import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.RegistoOrganizacoesDTO;
import t4j.app.service.ColaboradoresService;
import t4j.app.service.OrganizacoesService;

public class UIEspeficificarColaboradorController {

    /**
     *
     * @param organizacaoNif nif da organização à qual se pretende adicionar um novo colaborador
     * @param cdto colaborador a ser adicionado à organização identificada pelo nif
     * @return true se foi especificado um novo colaborador à organização identificada pelo nif passado por parâmetro e false se contrário
     */
    public boolean especificarColaborador(String organizacaoNif, ColaboradorDTO cdto) {
        boolean result = ColaboradoresService.addColaborador(organizacaoNif, cdto);
        return result;
    }

    /**
     *
     * @return registo de organizações
     */
    public RegistoOrganizacoesDTO getRegistoOrganizacoes() {
        return OrganizacoesService.getRegistoOrganizacoes();
    }
}
