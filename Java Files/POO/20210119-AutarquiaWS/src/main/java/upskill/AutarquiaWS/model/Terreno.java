/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.AutarquiaWS.model;

import upskill.AutarquiaWS.repo.ShapeTerreno;
import java.io.Serializable;
import java.util.Objects;
import upskill.AutarquiaWS.exception.IdInvalidoException;
import upskill.AutarquiaWS.exception.NumeroTerrenoInvalidoException;

/**
 *
 * @author user
 */
public abstract class Terreno implements Serializable {
    
    private long number;
    private ShapeTerreno shape;
    
    private static final ShapeTerreno SHAPE_TERRENO_DEFAULT = ShapeTerreno.RECTANGLE;
    private static long NUMBER_DEFAULT = 0;
    
    public Terreno() {
        this.number = NUMBER_DEFAULT;
        this.shape = SHAPE_TERRENO_DEFAULT;
    }
    
    public Terreno(long number, ShapeTerreno shape) {
        this.number = number;
        this.shape = shape;
    }
    
    public Terreno(ShapeTerreno shape) {
        this.shape = shape;
        this.number = NUMBER_DEFAULT;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Terreno número ").append(getNumber());
        sb.append(", com formato ").append(getShape().toString());
        sb.append("\n");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.number ^ (this.number >>> 32));
        hash = 67 * hash + Objects.hashCode(this.shape);
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
        final Terreno other = (Terreno) obj;
        if (this.number != other.number) {
            return false;
        }
        if (this.shape != other.shape) {
            return false;
        }
        return true;
    }

    /**
     * @return the number
     */
    public long getNumber() {
        return number;
    }

    /**
     * @return the shape
     */
    public ShapeTerreno getShape() {
        return shape;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(long number) {
        if (number < 0) {
            throw new NumeroTerrenoInvalidoException(number + ": Numero de Terreno inválido.");
        }
        this.number = number;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(ShapeTerreno shape) {
        this.shape = shape;
    }

}
