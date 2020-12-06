
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Subject implements ISubject{

    List<IObserver> observers;
    public static final Subject INSTANCE = new Subject();
    String state;

    private Subject() {
        this.observers = new ArrayList();
        this.state = "Initial State";
    }
    
    public static Subject getInstance() {
        return INSTANCE;
    }
    
    @Override
    public void addObserver(IObserver o) {
        this.observers.add(o);
    }

    @Override
    public boolean removeObserver(IObserver o) {
        return this.observers.remove(o);
    }

    @Override
    public void updateObservers() {
        for (IObserver observer : observers) {
            observer.updateSubject(this);
        }
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void setState(String newState) {
        this.state = newState;
        this.updateObservers();
    }

    @Override
    public String toString() {
        return "Subject{" + "observers=" + observers + ", state=" + state + '}';
    }
    
    
}
