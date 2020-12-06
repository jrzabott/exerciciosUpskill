/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public interface ISubject {
    void addObserver(IObserver o);
    boolean removeObserver(IObserver o);
    void updateObservers();
    String getState();
    void setState(String newState);
}
