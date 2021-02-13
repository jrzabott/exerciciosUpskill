package t4j.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.RegistoTarefasDTO;
import t4j.app.dto.TarefaDTO;
import t4j.app.service.TarefasService;

@RestController
@RequestMapping("/api")
public class TarefasController {

    /**
     * 
     * @return o registo de tarefas
     */
    @RequestMapping(value = "/tarefas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTarefas() {
        try {
            RegistoTarefasDTO registoTarefasDTO = TarefasService.getRegistoTarefas();
            if (registoTarefasDTO != null) {
                return new ResponseEntity<>(registoTarefasDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param referencia referência da tarefa que se pretende obter
     * @return a tarefa identifica pela sua referência
     */
    @RequestMapping(value = "/tarefas/{referencia}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTarefa(@PathVariable("referencia") String referencia) {
        try {
            TarefaDTO tarefaDTO = TarefasService.getTarefa(referencia);
            if (tarefaDTO != null) {
                return new ResponseEntity<>(tarefaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param tarefaDTO tarefa que se petende adicionar ao registo de tarefas
     * @return adiciona uma nova tarefa ao registo de tarefas
     */
    @RequestMapping(value = "/tarefas",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTarefa(@RequestBody TarefaDTO tarefaDTO) {
        try {
            TarefasService.addTarefa(tarefaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param referencia referência da tarefa a ser atualizada no registo de tarefas
     * @param tarefaDTO tarefa que vai ser atualizada
     * @return atualizada uma determinada tarefa no registo de tarefas identifica pela sua referência de tarefa
     */
    @RequestMapping(value = "/tarefas/{referencia}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTarefa(@PathVariable("referencia") String referencia, @RequestBody TarefaDTO tarefaDTO) {
        try {
            TarefasService.updateTarefa(referencia, tarefaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /**
     * 
     * @param referencia referência da tarefa que se pretende remover do registo de tarefas
     * @return remove uam determinada tarefa do registo de tarefas identifica pela sua referência de tarefa
     */
    @RequestMapping(value = "/tarefas/{referencia}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeTarefa(@PathVariable("referencia") String referencia) {
        try {
            TarefasService.removeTarefa(referencia);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
