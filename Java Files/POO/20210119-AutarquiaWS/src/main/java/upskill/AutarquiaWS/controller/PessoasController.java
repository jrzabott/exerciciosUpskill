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
import upskill.AutarquiaWS.dto.ListaPessoaDTO;
import upskill.AutarquiaWS.dto.PessoaDTO;
import upskill.AutarquiaWS.service.PessoasService;

@RestController
@RequestMapping("/api")
/**
 *
 * @author user
 */
public class PessoasController {

    @RequestMapping(
            value = "/pessoas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoas() {
        try {
            ListaPessoaDTO listaPessoaDTO = PessoasService.getPessoas();
            if (listaPessoaDTO.getPessoas().size() > 0) {
                return new ResponseEntity<>(listaPessoaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(
            value = "/pessoas/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getPessoa(@PathVariable("id") long nif) {
        try {
            PessoaDTO pessoaDTO = PessoasService.getPessoa(nif);
            if (pessoaDTO != null) {
                return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/pessoas",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addPessoa(
            @RequestBody PessoaDTO pessoaDTO) {
        try {
            PessoasService.addPessoa(pessoaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/pessoas/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updatePessoa(
            @PathVariable("id") long nif,
            @RequestBody PessoaDTO pessoaDTO) {
        try {
            PessoasService.updatePessoa(nif, pessoaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(
            value = "/pessoas/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removePessoa(
            @PathVariable("id") long nif) {
        try {
            PessoasService.removePessoa(nif);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
