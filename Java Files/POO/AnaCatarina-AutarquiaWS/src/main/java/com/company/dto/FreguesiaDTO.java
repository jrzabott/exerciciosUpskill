
package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"nome", "terrenos"}) 
@JacksonXmlRootElement(localName = "freguesia") 


public class FreguesiaDTO {
    
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "terrenos")
    private ListaTerrenoDTO terreno;
 
    public FreguesiaDTO() { 
    }

    public String getNome() {
        return nome;
    }

    public ListaTerrenoDTO getTerreno() {
        return terreno;
    }

    public void setNome(String nomeT) {
        this.nome = nomeT;
    }

    public void setTerreno(ListaTerrenoDTO terrenoT) {
        this.terreno = terrenoT;
    }
    
    
    
}
