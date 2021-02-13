package t4j.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.RegistoGrausProficienciaDTO;
import t4j.app.dto.GrauProficienciaDTO;
import t4j.app.service.GrausProficienciaService;

@RestController
@RequestMapping("/api")
public class GrausProficienciaController {

    /**
     *
     * @param codCT código de competência técnica da qual se pretende a lista de graus de proficiência
     * @return o registo de graus de proficiência de uam determinada competência técnica identificada pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}/grausproficiencia",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getGrausProficiencia(@PathVariable("codigo") String codCT) {
        try {
            RegistoGrausProficienciaDTO registoGrausProficienciaDTO = GrausProficienciaService.getGrausProficiencia(codCT);
            if (registoGrausProficienciaDTO != null) {
                return new ResponseEntity<>(registoGrausProficienciaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param codigo código de competência técnica da qual se pretende a lista de graus de proficiência
     * @param valor o valor do grau de proficiência que se pretende
     * @return o grau de proficiência de um determinado valor pertence a uma determinada competência técnica identifica pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}/grausproficiencia/{valor}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getGrauProficiencia(@PathVariable("codigo") String codigo, @PathVariable("valor") String valor) {
        try {
            GrauProficienciaDTO grauProficienciaDTO = GrausProficienciaService.getGrauProficiencia(codigo, valor);
            if (grauProficienciaDTO != null) {
                return new ResponseEntity<>(grauProficienciaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param codigo código de competência técnica à qual se pretende adicionar um novo grau de proficiência
     * @param grauProficienciaDTO grau de proficiência que se pretende adicionar à competência técnica identifica pelo seu código de competência técnica
     * @return adicionada um grau de proficiência a uma determinada competência técnica identifica pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}/grausproficiencia",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addGrauProficiencia(@PathVariable("codigo") String codigo, @RequestBody GrauProficienciaDTO grauProficienciaDTO) {
        try {
            GrausProficienciaService.addGrauProficiencia(codigo, grauProficienciaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param codigo código de competência técnica à qual se pretende atulizar o grau de proficiência
     * @param valor valor do grau de proficiência a ser atualizado
     * @param grauProficienciaDTO grau de proficiência a ser atualizado no registo de gaus de proficiência
     * @return atualiza um grau de proficiência de uma determinada competência técnica identifica pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}/grausproficiencia/{valor}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateGrauProficiencia(@PathVariable("codigo") String codigo, @PathVariable("valor") String valor, @RequestBody GrauProficienciaDTO grauProficienciaDTO) {
        try {
            GrausProficienciaService.updateGrauProficiencia(codigo, valor, grauProficienciaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param codigo código de competência técnica da qual se prentende remover um grau de proficiência
     * @param valor valor do grau de proficiência que se pretende remover
     * @return remove um grau de proficiência identificada pelo seu valor correspondente a uam competência técnica identifica pelo código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}/grausproficiencia/{valor}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeGrauProficiencia(@PathVariable("codigo") String codigo, @PathVariable("idTerreno") String valor) {
        try {
            GrausProficienciaService.removeGrauProficiencia(codigo, valor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
