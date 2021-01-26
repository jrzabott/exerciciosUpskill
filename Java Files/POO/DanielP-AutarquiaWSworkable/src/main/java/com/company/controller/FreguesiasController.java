package com.company.controller;

import com.company.dto.ErroDTO;
import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.FreguesiaDTO;
import com.company.service.FreguesiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FreguesiasController {

    @RequestMapping(value = "/freguesias",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoas() {
        try {
            ListaFreguesiaDTO listaFreguesiaDTO = FreguesiaService.getFreguesias();
            if (listaFreguesiaDTO.getFreguesias().size() > 0) {
                return new ResponseEntity<>(listaFreguesiaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFreguesia(@PathVariable("nome") String nome) {
        try {
            FreguesiaDTO freguesiaDTO = FreguesiaService.getFreguesia(nome);
            if (freguesiaDTO != null) {
                return new ResponseEntity<>(freguesiaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addFreguesia(@RequestBody FreguesiaDTO freguesiaDTO) {
        try {
            FreguesiaService.addFreguesia(freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updatePessoa(@PathVariable("nome") String nome, @RequestBody FreguesiaDTO freguesiaDTO) {
        try {
            FreguesiaService.updateFreguesia(nome, freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
     @RequestMapping(value = "/freguesias/{nome}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removePessoa(@PathVariable("nome") String nome) {
        try {
            FreguesiaService.removeFreguesia(nome);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
