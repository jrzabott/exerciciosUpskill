/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import upskill.model.Data;

/**
 *
 * @author user
 */
@Controller
public class DataController {

    static Data data = null;

    @GetMapping(value = "getDatas")
    public ResponseEntity<Object> getDatas() {
        if (data == null) {
            initData();
        }
        return new ResponseEntity<>(DataController.data.toString(), HttpStatus.OK);
    }
    public String getDatas2() {
        if (data == null) {
            initData();
        }
        return DataController.data.toString();
    }

    @GetMapping(value = "addDatas")
    public ResponseEntity<Object> addData() {
        if (data == null) {
            initData();
        }
        DataController.data.addData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void initData() {
        if (DataController.data == null) {
            DataController.data = new Data();
        }
    }

    @GetMapping(value = "/m")
    public ResponseEntity<Object> maps() {
        return new ResponseEntity<>("Qualquer coisa", HttpStatus.OK);
    }
}
