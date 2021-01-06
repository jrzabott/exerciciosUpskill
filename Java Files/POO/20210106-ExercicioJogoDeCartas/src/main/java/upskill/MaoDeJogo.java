/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class MaoDeJogo {

    private List<Carta> cartas;

    public MaoDeJogo(List<Carta> cartas) {
        this.cartas = new ArrayList<>(cartas);
    }

    public MaoDeJogo() {
        cartas = new ArrayList<>();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public boolean addCarta(Carta c) {
        return cartas.add(c);
    }

    public List<Carta> tiposDeCarta() {
        List<Carta> tiposDeCarta = new ArrayList<>();
        for (Carta carta : this.getCartas()) {
            if (!tiposDeCarta.contains(carta)) {
                tiposDeCarta.add(carta);
            }
        }
        return tiposDeCarta;
    }
    
    public void ordenar(){
//        List<Carta> sortedCartas = new ArrayList<>(this.getCartas());
        Comparator<Carta> naipeComparator = Comparator.comparing(Carta::getNaipe);
        Comparator<Carta> tipoComparator = Comparator.comparing(Carta::getTipo);
        Comparator<Carta> multipleFieldComparator = naipeComparator.thenComparing(tipoComparator);
        
        Collections.sort(cartas, multipleFieldComparator);
    }
    
    public int contarCartasDoTipo(Carta.EnumCartaTipo cartaTipo){
        int count = 0;
        for (Carta carta : cartas) {
            if (carta.getTipo() == cartaTipo) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaoDeJogo{cartas=").append(cartas);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.cartas);
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
        final MaoDeJogo other = (MaoDeJogo) obj;
        if (!Objects.equals(this.cartas, other.cartas)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
