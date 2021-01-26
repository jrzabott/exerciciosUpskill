
package com.company.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty; 
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JsonPropertyOrder({"numero", "formato", "area"}) 
@JacksonXmlRootElement(localName = "terreno") 

public class TerrenoDTO {
    
    @JacksonXmlProperty(localName = "numero") private int numero;
    @JacksonXmlProperty(localName = "formato") private String formato;
    @JacksonXmlProperty(localName = "area") private double area;
    
    public TerrenoDTO(){
    }
    
    public int getNumero(){
    return numero;
    }

    public String getFormato() {
        return formato;
    }

    public double getArea() {
        return area;
    }
    
    public void setNumero(int numeroT){
        this.numero = numeroT;
    }

    public void setFormato(String formatoT) {
        this.formato = formatoT;
    }

    public void setArea(double areaT) {
        this.area = areaT;
    }
    
    
    
}
