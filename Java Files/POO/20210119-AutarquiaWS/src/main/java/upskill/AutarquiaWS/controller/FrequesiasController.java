/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.controller;

import org.apache.coyote.http11.Http11AprProtocol;
import upskill.AutarquiaWS.dto.ListaFreguesiaDTO;
import upskill.AutarquiaWS.service.FreguesiasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import upskill.AutarquiaWS.dto.ErroDTO;
import upskill.AutarquiaWS.dto.FreguesiaDTO;
import upskill.AutarquiaWS.model.Freguesia;

@RestController
@RequestMapping("/api")
/**
 *
 * @author user
 */
public class FrequesiasController {

    @RequestMapping(
            value = "/freguesias",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<Object> getFreguesias() {
        try {
            ListaFreguesiaDTO listaFreguesiasDTO = FreguesiasService.getFreguesias();
            if (listaFreguesiasDTO.getFreguesias().size() > 0) {
                return new ResponseEntity<>(listaFreguesiasDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(
            value = "/freguesias/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFreguesia(@PathVariable("id") long id) {
        try {
            FreguesiaDTO freguesiaDTO = FreguesiasService.getFreguesia(id);
            if (freguesiaDTO != null) {
                return new ResponseEntity<>(freguesiaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(
            value = "/freguesias",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE)

    public ResponseEntity<Object> addFreguesia(@RequestBody FreguesiaDTO freguesiaDTO) {
        try {
            FreguesiasService.addFreguesia(freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(
            value = "/freguesias/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateFreguesia(@PathVariable("id") long id,
            @RequestBody FreguesiaDTO freguesiaDTO) {
        try {
            FreguesiasService.updateFreguesia(id, freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping( // TODO deleteFreguesia
            value = "/freguesias/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> deleteFreguesia(@PathVariable("id") long id) {
        try {
            FreguesiasService.removeFreguesia(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
