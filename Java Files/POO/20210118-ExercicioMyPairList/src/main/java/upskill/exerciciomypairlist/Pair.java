/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciomypairlist;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author user
 * @param <T>
 * @param <U>
 */
public class Pair<T extends Comparable<T> & Serializable, U extends Comparable<U> & Serializable> implements Comparable<Pair<T, U>>, Serializable {
    
    private T first;
    private U second;
    
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair<T, U> o) {
        if (getFirst().compareTo(o.getFirst()) == 0) {
            return this.getSecond().compareTo(o.getSecond());
        } else {
            return this.getFirst().compareTo(o.getFirst());
        }
    }
    
       
    public T getFirst() {
        return this.first;
    }
    
    public void setFirst(T first) {
        this.first = first;
    }
    
    public U getSecond() {
        return this.second;
    }
    
    public void setSecond(U second) {
        this.second = second;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.first);
        hash = 29 * hash + Objects.hashCode(this.second);
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
        final Pair<?, ?> other = (Pair<?, ?>) obj;
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.second, other.second)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(first)
                .append(", ")
                .append(second)
                .append(")");
        return sb.toString();
    }
    
}
