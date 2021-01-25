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
@JsonPropertyOrder({"number", "a", "b", "c"})
public class TerrenoTriangularDTO extends TerrenoDTO {

     @JacksonXmlProperty(localName = "a")
    private double a;
     @JacksonXmlProperty(localName = "b")
    private double b;
     @JacksonXmlProperty(localName = "c")
    private double c;

    public TerrenoTriangularDTO() {
        super();
        super.setShape(ShapeTerreno.TRIANGLE);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    

}
