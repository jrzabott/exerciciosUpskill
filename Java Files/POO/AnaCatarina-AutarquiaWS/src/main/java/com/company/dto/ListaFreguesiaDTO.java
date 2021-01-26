
package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "freguesias") 


public class ListaFreguesiaDTO {
    
    @JacksonXmlElementWrapper(useWrapping = false) 
    @JacksonXmlProperty(localName = "freguesia") 
    private List<FreguesiaDTO> freguesias;

    public ListaFreguesiaDTO() { 
    }

    public List<FreguesiaDTO> getFreguesias() { 
        return freguesias;
    }

    public void setFreguesias(List<FreguesiaDTO> freguesia) { 
        this.freguesias = freguesia;
    }
    
}
