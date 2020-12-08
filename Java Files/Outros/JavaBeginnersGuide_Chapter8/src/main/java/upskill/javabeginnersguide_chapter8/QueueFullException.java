/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter8;

/**
 *
 * @author user
 */
public class QueueFullException extends Exception{
    int size;

    public QueueFullException(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%nQueue is Full. Maximum size is %d.", this.size);
    }
    
    
}
