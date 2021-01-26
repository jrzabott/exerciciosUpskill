/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

/**
 *
 * @author Home
 */
@JacksonXmlRootElement(localName = "freguesias")
public class ListaFreguesiaDTO {
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "freguesia")
    private ArrayList<FreguesiaDTO> freguesias;

    public ListaFreguesiaDTO() {
    }

    public ArrayList<FreguesiaDTO> getFreguesias() {
        return freguesias;
    }

    public void setFreguesias(ArrayList<FreguesiaDTO> freguesias) {
        this.freguesias = freguesias;
    }

    


    
}
