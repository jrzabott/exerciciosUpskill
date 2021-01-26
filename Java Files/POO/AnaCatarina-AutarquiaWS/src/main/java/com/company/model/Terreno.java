
package com.company.model;

import java.io.Serializable;
import java.util.Objects;


public class Terreno  implements Serializable {
    
    private int numeroTerreno;
    private String formatoTerreno;
    private double areaTerreno;
    
    private static final int NUMERO_TERRENO_POR_OMISSAO = 0;
    private static final String FORMATO_POR_OMISSAO = "sem formato";
    private static final double AREA_POR_OMISSAO = 0.0;
    
    public Terreno(int numero, String formato, double area){
        this.numeroTerreno = numero; 
        this.formatoTerreno = formato;
        this.areaTerreno = area;
    }
    
    public Terreno(){
        this.numeroTerreno = NUMERO_TERRENO_POR_OMISSAO;
        this.formatoTerreno = FORMATO_POR_OMISSAO;
        this.areaTerreno = AREA_POR_OMISSAO;
    }
    
    public Terreno(Terreno terreno){
        this.numeroTerreno = terreno.getNumeroTerreno(); 
        this.formatoTerreno = terreno.getFormatoTerreno();
        this.areaTerreno = terreno.getAreaTerreno();
    }

    public int getNumeroTerreno() {
        return numeroTerreno;
    }

    public String getFormatoTerreno() {
        return formatoTerreno;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }
    
    public void setNumeroTerreno(int numero) {
        this.numeroTerreno = numero;
    }

    public void setFormatoTerreno(String formatoTerreno) {
        this.formatoTerreno = formatoTerreno;
    }

    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }
    
    @Override
    public String toString() {
        return String.format("Número terreno: %d%nFormato terreno: %s%nÁrea terreno: %.2f%n", numeroTerreno, formatoTerreno, areaTerreno);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Terreno other = (Terreno) obj;
        if (this.numeroTerreno != other.numeroTerreno) {
            return false;
        }
        if (this.formatoTerreno != other.formatoTerreno) {
            return false;
        }
        if (this.areaTerreno != other.areaTerreno) {
            return false;
        }
        return true;
    }
}
