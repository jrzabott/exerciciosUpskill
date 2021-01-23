/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import upskill.AutarquiaWS.repo.ShapeTerreno;

/**
 *
 * @author user
 */
//@JsonPropertyOrder({"number", "shape", "freguesiaId"})
//@JacksonXmlRootElement(localName = "terreno")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(name = "TerrenoCircular", value = TerrenoCircularDTO.class),
    @JsonSubTypes.Type(name = "TerrenoRetangular", value = TerrenoRetangularDTO.class),
    @JsonSubTypes.Type(name = "TerrenoTriangular", value = TerrenoTriangularDTO.class)
})
public abstract class TerrenoDTO {

    @JacksonXmlProperty(localName = "number")
    private long number;
    @JacksonXmlProperty(localName = "shape")
    private ShapeTerreno shape;

    public  TerrenoDTO() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public ShapeTerreno getShape() {
        return shape;
    }

    public void setShape(ShapeTerreno shape) {
        this.shape = shape;
    }

}
