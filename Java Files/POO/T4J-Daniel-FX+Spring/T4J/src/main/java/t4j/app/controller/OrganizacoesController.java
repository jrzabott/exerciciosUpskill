package t4j.app.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.RegistoOrganizacoesDTO;
import t4j.app.service.OrganizacoesService;

@RestController
@RequestMapping("/api")
public class OrganizacoesController {

    /**
     * 
     * @return o registo de organizações
     */
    @GetMapping(value = "/organizacoes", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getRegistoOrganizacoes() {
        try {
            RegistoOrganizacoesDTO ro = OrganizacoesService.getRegistoOrganizacoes();
            if (ro.getOrganizacoes().size() > 0) {
                return new ResponseEntity<>(ro, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @return o registo de organizações
     */
    public RegistoOrganizacoesDTO getRegistoOrganizacoesUI() {
        RegistoOrganizacoesDTO result = OrganizacoesService.getRegistoOrganizacoes();
        return result;
    }

    /**
     * 
     * @param odto organização a ser adicionada ao registo de organizações
     * @return adiciona uma nova organização ao registo de organizações
     */
    @PostMapping(value = "/organizacoes", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
//    @RequestMapping(value = "/organizacoes", 
//            consumes = MediaType.APPLICATION_XML_VALUE, 
//            produces = MediaType.APPLICATION_XML_VALUE,
//            method = RequestMethod.POST)
    public ResponseEntity<Object> addOrganizacao(@RequestBody OrganizacaoDTO odto) {
        try {
            OrganizacoesService.addOrganizacao(odto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
//System.out.println("Post OK");
//            return new ResponseEntity<>( HttpStatus.OK);
    }

}
