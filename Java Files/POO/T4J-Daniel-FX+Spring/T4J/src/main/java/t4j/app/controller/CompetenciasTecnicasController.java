package t4j.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t4j.app.dto.CompetenciaTecnicaDTO;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.RegistoCompetenciasTecnicasDTO;
import t4j.app.service.CompetenciasTecnicasService;

@RestController
@RequestMapping("/api")
public class CompetenciasTecnicasController {

    /**
     * 
     * @return o registo de competências técnicas
     */
    @RequestMapping(value = "/competenciastecnicas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCompetenciasTecnicas() {
        try {
            RegistoCompetenciasTecnicasDTO registoCompetenciaTecnicaDTO = CompetenciasTecnicasService.getRegistoCompetenciasTecnicas();
            if (registoCompetenciaTecnicaDTO != null) {
                return new ResponseEntity<>(registoCompetenciaTecnicaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param codCT código da competência técnica que se pretende
     * @return uma comptência técnica identificada pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCompetenciaTecnica(@PathVariable("codigo") String codCT) {
        try {
            CompetenciaTecnicaDTO competenciaTecnicaDTO = CompetenciasTecnicasService.getCompetenciaTecnica(codCT);
            if (competenciaTecnicaDTO != null) {
                return new ResponseEntity<>(competenciaTecnicaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param competenciaTecnicaDTO competência técnica a ser adicionada ao registo de competências técnicas
     * @return adiciona uma nova competência técnica ao registo de competências técnicas
     */
    @RequestMapping(value = "/competenciastecnicas",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCompetenciaTecnica(@RequestBody CompetenciaTecnicaDTO competenciaTecnicaDTO) {
        try {
            CompetenciasTecnicasService.addCompetenciaTecnica(competenciaTecnicaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param codCT código da competência técnica que se pretende atualizar
     * @param competenciaTecnicaDTO competência técnica a ser atualizada no registo de competências técnicas
     * @return atualiza uma competência técnica identificada pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCompetenciaTecnica(@PathVariable("codigo") String codCT, @RequestBody CompetenciaTecnicaDTO competenciaTecnicaDTO) {
        try {
            CompetenciasTecnicasService.updateCompetenciaTecnica(codCT, competenciaTecnicaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param codCT código da competência técnica que se pretende remover
     * @return remove uma competência técnica identificada pelo seu código de competência técnica
     */
    @RequestMapping(value = "/competenciastecnicas/{codigo}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeCompetenciaTecnica(@PathVariable("referencia") String codCT) {
        try {
            CompetenciasTecnicasService.removeCompetenciaTecnica(codCT);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
