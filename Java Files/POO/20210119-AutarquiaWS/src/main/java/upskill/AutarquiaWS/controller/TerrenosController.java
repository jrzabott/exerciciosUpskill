/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import upskill.AutarquiaWS.dto.ErroDTO;
import upskill.AutarquiaWS.dto.ListaTerrenoDTO;
import upskill.AutarquiaWS.dto.TerrenoDTO;
import upskill.AutarquiaWS.service.TerrenosService;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class TerrenosController {

//    @RequestMapping(value = "/freguesias/{freguesiaId}/terrenos",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getTerrenos() {
//        try {
//            System.out.println("Teste");
//            return new ResponseEntity<>(HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
    @RequestMapping(value = "/freguesias/{freguesiaId}/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenos(
            @PathVariable("freguesiaId") long freguesiaId
    ) {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getTerrenos(freguesiaId);
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{freguesiaId}/terrenos",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerreno(
            @PathVariable("freguesiaId") long freguesiaId,
            @RequestBody TerrenoDTO terrenoDTO
    ) {
        try {
            TerrenosService.addTerreno(freguesiaId, terrenoDTO);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
