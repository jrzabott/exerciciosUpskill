/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Carta {

    private final EnumCartaTipo tipo;
    private final EnumCartaNaipe naipe;

    public static enum EnumCartaTipo {
        DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI, AS
    }

    public static enum EnumCartaNaipe {
        COPAS, ESPADAS, OUROS, PAUS
    }

    public Carta(EnumCartaTipo tipo, EnumCartaNaipe naipe) {
        this.tipo = tipo;
        this.naipe = naipe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getTipo());
        hash = 23 * hash + Objects.hashCode(this.getNaipe());
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
        final Carta other = (Carta) obj;
        if (this.getTipo() != other.getTipo()) {
            return false;
        }
        if (this.getNaipe() != other.getNaipe()) {
            return false;
        }
        return true;
    }

    /**
     * @return the tipo
     */
    public EnumCartaTipo getTipo() {
        return tipo;
    }

    /**
     * @return the naipe
     */
    public EnumCartaNaipe getNaipe() {
        return naipe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carta{ ").append(tipo);
        sb.append(" de ").append(naipe);
        sb.append(" }\n");
        return sb.toString();
    }
    
    
}
