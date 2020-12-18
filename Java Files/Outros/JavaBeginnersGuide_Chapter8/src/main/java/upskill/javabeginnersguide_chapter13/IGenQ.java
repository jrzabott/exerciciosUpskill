/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter13;

/**
 *
 * @author Daniel Junior
 * Generic queue interface
 */
public interface IGenQ<T> {
    // put an item into the queue.
    void put (T ch) throws QueueFullException;
    
    // Get an item from the queue;

    /**
     *
     * @return
     * @throws QueueEmptyException
     */
    T get() throws QueueEmptyException;
}
