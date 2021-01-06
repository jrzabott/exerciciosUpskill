/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Baralho {

    private List<Carta> cartas;
    private EnumTipoBaralho tipoBaralho;
    private static final EnumTipoBaralho TIPO_BARALHO_OMISSAO = EnumTipoBaralho.C52;

    public enum EnumTipoBaralho {
        C40, C52
    }

    {
        this.cartas = new ArrayList<>();
    }

    public Baralho(EnumTipoBaralho tipoBaralho) {
        this.tipoBaralho = tipoBaralho;
        criarCartas(tipoBaralho);
    }

    public Baralho() {
        criarCartas(TIPO_BARALHO_OMISSAO);
        this.tipoBaralho = TIPO_BARALHO_OMISSAO;
    }

    /**
     * @return the cartas
     */
    public List<Carta> getCartas() {
        return cartas;
    }

    /**
     * @param cartas the cartas to set
     */
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    private void criarCartas(EnumTipoBaralho tipoBaralho) {
        switch (tipoBaralho) {
            case C40:
                criar40Cartas();
                break;
            case C52:
                criar52Cartas();
                break;
            default:
                criar52Cartas();
        }
    }

    private void criar52Cartas() {
        for (Carta.EnumCartaNaipe naipe : Carta.EnumCartaNaipe.values()) {
            for (Carta.EnumCartaTipo tipo : Carta.EnumCartaTipo.values()) {
                cartas.add(new Carta(tipo, naipe));
            }

        }
    }

    private void criar40Cartas() {
        for (Carta.EnumCartaNaipe naipe : Carta.EnumCartaNaipe.values()) {
            for (Carta.EnumCartaTipo tipo : Carta.EnumCartaTipo.values()) {
                if (tipo != Carta.EnumCartaTipo.OITO
                        && tipo != Carta.EnumCartaTipo.NOVE
                        && tipo != Carta.EnumCartaTipo.DEZ) {
                    cartas.add(new Carta(tipo, naipe));

                }
            }

        }
    }

    public void baralhar() {
        Collections.shuffle(this.cartas);
    }

    public Carta retirarCarta() {
        Carta result;
        result = cartas.get(cartas.size() - 1);
        cartas.remove(cartas.size() - 1);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Baralho{cartas=").append(cartas);
        sb.append(", tipoBaralho=").append(tipoBaralho);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cartas);
        hash = 29 * hash + Objects.hashCode(this.tipoBaralho);
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
        final Baralho other = (Baralho) obj;
        if (!Objects.equals(this.cartas, other.cartas)) {
            return false;
        }
        if (this.tipoBaralho != other.tipoBaralho) {
            return false;
        }
        return true;
    }

}
