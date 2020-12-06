
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Observer implements IObserver{

    String obsState;
    int id;
    static int counter;

    public Observer() {
        this.obsState = "OBSERVER INITIAL STATE";
        this.id = ++Observer.counter;
    }
    
    
    
    @Override
    public void updateSubject(ISubject s) {
        this.obsState = s.getState();
        System.out.printf("ID: %d, ObsState: %s%n", this.id, this.obsState);
    }

    @Override
    public String toString() {
        return "Observer{" + "obsState=" + obsState + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.obsState);
        hash = 97 * hash + this.id;
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
        final Observer other = (Observer) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.obsState, other.obsState)) {
            return false;
        }
        return true;
    }
    
    
    
}
