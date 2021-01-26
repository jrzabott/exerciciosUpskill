/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author Home
 */
@JsonPropertyOrder({"id", "nomeFreguesia"})
@JacksonXmlRootElement(localName = "freguesia")
public class FreguesiaDTO {
    @JacksonXmlProperty(localName = "nomeFreguesia")
    private String nomeFreguesia;
    @JacksonXmlProperty(localName = "id")
    private int id;
    
    public FreguesiaDTO(){
        
    }

    public String getNomeFreguesia() {
        return nomeFreguesia;
    }

    public void setNomeFreguesia(String nomeFreguesia) {
        this.nomeFreguesia = nomeFreguesia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
