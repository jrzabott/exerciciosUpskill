/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
@JacksonXmlRootElement(localName = "terrenos")
public class ListaTerrenoDTO {
    
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "terreno")
    private ArrayList<TerrenoDTO> terrenos;

    public ListaTerrenoDTO() {
    }
    
    public ArrayList<TerrenoDTO> getTerrenos(){
        return terrenos;
    }
    
    public void setTerrenos(ArrayList<TerrenoDTO> terrenos){
        this.terrenos = terrenos;
    }
    
}
