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
public class TerrenoRetangular extends Terreno {

    private double width;
    private double length;

    private static final double LENGTH_DEFAULT = 0.0;
    private static final double WIDTH_DEFAULT = 0.0;

    public TerrenoRetangular() {
        super(ShapeTerreno.RECTANGLE);
        this.length = LENGTH_DEFAULT;
        this.width = WIDTH_DEFAULT;
    }

    public TerrenoRetangular(double width, double length, long number) {
        super(number, ShapeTerreno.RECTANGLE);
        this.width = width;
        this.length = length;
    }

    public TerrenoRetangular(double width, double length) {
        super(ShapeTerreno.RECTANGLE);
        this.width = width;
        this.length = length;
    }

    public TerrenoRetangular(TerrenoRetangular terreno) {
        super(terreno.getNumber(), terreno.getShape());
        this.length = terreno.getLength();
        this.width = terreno.getWidth();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new TerrenoTamanhoInvalidoException(width + ": Largura inválida.");
        }
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            throw new TerrenoTamanhoInvalidoException(width + ": Comprimento inválido.");
        }
        this.length = length;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.length) ^ (Double.doubleToLongBits(this.length) >>> 32));
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
        final TerrenoRetangular other = (TerrenoRetangular) obj;
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("largura: ").append(this.width)
                .append(" comprimento: ").append(length)
                .append(" m2.\n");
        return sb.toString();
    }

    public double calcularArea() {
        double result = 0.0;
        result = getLength() * getWidth();
        return result;
    }

}
