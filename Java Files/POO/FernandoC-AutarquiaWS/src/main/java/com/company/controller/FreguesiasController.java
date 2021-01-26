/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.FreguesiaDTO;
import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.ListaPessoaDTO;
import com.company.service.FreguesiasService;
import com.company.service.PessoasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
@RequestMapping("/api")
public class FreguesiasController {
    
     @RequestMapping(value = "/freguesias", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
     public ResponseEntity<Object> getFreguesias() {
        try {
            ListaFreguesiaDTO listaFreguesiaDTO = FreguesiasService.getFreguesias();
            if (listaFreguesiaDTO.getFreguesias().size() > 0) {
                return new ResponseEntity<>(listaFreguesiaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
@RequestMapping(value = "/freguesias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFreguesia(@PathVariable("id") int id) {
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

    @RequestMapping(value = "/freguesias", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addFreguesia(@RequestBody FreguesiaDTO freguesiaDTO) {
        try {
            FreguesiasService.addFreguesia(freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/freguesias/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateFreguesia(@PathVariable("id") int id, @RequestBody FreguesiaDTO freguesiaDTO) {
        try {
            FreguesiasService.updateFreguesia(id, freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeFreguesia(@PathVariable("id") int id) {
        try {
            FreguesiasService.removeFreguesia(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}

