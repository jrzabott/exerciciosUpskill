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
public class TerrenoTriangular extends Terreno {

    private double a;
    private double b;
    private double c;

    private static final double A_SIDE_DEFAULT = 0.0;
    private static final double B_SIDE_DEFAULT = 0.0;
    private static final double C_SIDE_DEFAULT = 0.0;

    public TerrenoTriangular(double a, double b, double c) {
        super(ShapeTerreno.TRIANGLE);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TerrenoTriangular(double a, double b, double c, long number) {
        super(number, ShapeTerreno.TRIANGLE);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TerrenoTriangular() {
        super(ShapeTerreno.TRIANGLE);
    }

    public TerrenoTriangular(TerrenoTriangular terreno) {
        super(terreno.getNumber(), terreno.getShape());
        this.a = terreno.getA();
        this.b = terreno.getB();
        this.c = terreno.getC();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a < 0) {
            throw new TerrenoTamanhoInvalidoException(a + ": 1º Lado do Terreno Inválido.");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (b < 0) {
            throw new TerrenoTamanhoInvalidoException(b + ": 2º Lado do Terreno Inválido.");
        }
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if (c < 0) {
            throw new TerrenoTamanhoInvalidoException(c + ": 3º Lado do Terreno Inválido.");
        }
        this.c = c;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.a) ^ (Double.doubleToLongBits(this.a) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.c) ^ (Double.doubleToLongBits(this.c) >>> 32));
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
        final TerrenoTriangular other = (TerrenoTriangular) obj;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.getA())) {
            return false;
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.getB())) {
            return false;
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(other.getC())) {
            return false;
        }
        return true;
    }

    public double calcularArea() {
        double result;
        double perimeter = (1 / 2) * (a + b + c);
        result = Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
        return result;
    }

}
