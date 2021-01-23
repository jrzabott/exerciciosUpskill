package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nome"})
@JacksonXmlRootElement(localName = "freguesia")

public class FreguesiaDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;

    public FreguesiaDTO() {
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
