/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import upskill.AutarquiaWS.repo.ShapeTerreno;

/**
 *
 * @author user
 */
@JsonPropertyOrder({"radius"})
public class TerrenoCircularDTO extends TerrenoDTO {

    @JacksonXmlProperty(localName = "radius")
    private double radius;

    public TerrenoCircularDTO() {
        super.setShape(ShapeTerreno.CIRCLE);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
