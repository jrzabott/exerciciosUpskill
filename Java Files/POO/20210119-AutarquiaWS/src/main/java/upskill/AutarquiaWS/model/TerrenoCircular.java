/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.model;

import upskill.AutarquiaWS.repo.ShapeTerreno;
import upskill.AutarquiaWS.exception.TerrenoTamanhoInvalidoException;

/**
 *
 * @author user
 */
public class TerrenoCircular extends Terreno {

    private double radius;
    private static final double RADIUS_DEFAULT = 0.0;

    public TerrenoCircular(double radius) {
        super();
        this.radius = radius;
    }

    public TerrenoCircular(double radius, long number) {
        super(number, ShapeTerreno.CIRCLE);
        this.radius = radius;
    }

    public TerrenoCircular() {
        super(ShapeTerreno.CIRCLE);
        this.radius = RADIUS_DEFAULT;
    }

    public TerrenoCircular(TerrenoCircular terreno) {
        super(terreno.getNumber(), terreno.getShape());
        this.radius = terreno.getRadius();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new TerrenoTamanhoInvalidoException(this.radius + ": Raio do terreno inválido.");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("radio: ").append(this.radius).append(" m2.\n");
        return sb.toString();
    }

    public double calcularArea() {
        double result = 0.0;
        result = Math.PI * this.radius * this.radius;
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        return hash;
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
        final TerrenoCircular other = (TerrenoCircular) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        return true;
    }
    
    

}
