/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import upskill.AutarquiaWS.repo.ShapeTerreno;

/**
 *
 * @author user
 */
@JsonPropertyOrder({"number", "length", "width"})
public class TerrenoRetangularDTO extends TerrenoDTO {
    @JacksonXmlProperty(localName = "length")
    private double length;
    @JacksonXmlProperty(localName = "width")
    private double width;

    public TerrenoRetangularDTO() {
        super();
        super.setShape(ShapeTerreno.RECTANGLE);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    

}
