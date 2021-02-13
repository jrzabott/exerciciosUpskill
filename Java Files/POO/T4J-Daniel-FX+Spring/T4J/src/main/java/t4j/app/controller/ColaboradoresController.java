package t4j.app.controller;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t4j.app.dto.ColaboradorDTO;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.service.OrganizacoesService;

@RestController
@RequestMapping("/api")
public class ColaboradoresController {

    /**
     *
     * @param nifOrganizacaoString NIF da organização da qual se pretende os seus colaboradores
     * @return o registo de colaboradores de uma determinada organização identificada pelo seu NIF
     */
    @GetMapping(value = "/organizacoes/{nifOrganizacao}/colaboradores", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getColaboradores(@PathVariable("nifOrganizacao") String nifOrganizacaoString) {
        try {
            OrganizacaoDTO odto = OrganizacoesService.getOrganizacaoByNif(nifOrganizacaoString);
            if (odto.getColaboradores().size() > 0) {
                return new ResponseEntity<>(odto.getColaboradores(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param nifOrganizacaoString NIF da organização da qual se pretende os seus colaboradores
     * @return a lista de colaboradores de uma determinada organização identificada pelo seu NIF
     */
    public ArrayList<ColaboradorDTO> getColaboradoresUI(String nifOrganizacaoString) {
        OrganizacaoDTO odto = OrganizacoesService.getOrganizacaoByNif(nifOrganizacaoString);
        ArrayList<ColaboradorDTO> listColaboradores = new ArrayList<>(odto.getColaboradores());
        return listColaboradores;
    }
}
