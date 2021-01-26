
package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "terrenos") 
public class ListaTerrenoDTO {
    
    @JacksonXmlElementWrapper(useWrapping = false) 
    @JacksonXmlProperty(localName = "terrenos") 
    private List<TerrenoDTO> listaTerrenos;

    public ListaTerrenoDTO() { 
        this.listaTerrenos = new ArrayList<>();
    }
    
//    public ListaTerrenoDTO(ListaTerrenoDTO lista){
//        this.listaTerrenos = new ArrayList<>(lista.getTerrenos());
//    }

    public List<TerrenoDTO> getTerrenos() { 
        return listaTerrenos;
    }

    public void setTerrenos(List<TerrenoDTO> terrenosT) { 
        this.listaTerrenos = terrenosT;
    }

    
    
}
