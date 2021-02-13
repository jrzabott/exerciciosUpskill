package t4j.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t4j.app.dto.ErroDTO;
import t4j.app.dto.RegistoAreasAtividadeDTO;
import t4j.app.service.AreaAtividadeService;

@RestController
@RequestMapping("/api")
public class AreaAtividadesController {

    /**
     *
     * @return o registo de áreas de atividade
     */
    @GetMapping(value = "/areaatividades", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAreaAtividades() {
        try {
            RegistoAreasAtividadeDTO areasAtividadeDTO = AreaAtividadeService.getRegistoAreasAtividade();
            if (areasAtividadeDTO.getAtividades().size() > 0) {
                return new ResponseEntity<>(areasAtividadeDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
