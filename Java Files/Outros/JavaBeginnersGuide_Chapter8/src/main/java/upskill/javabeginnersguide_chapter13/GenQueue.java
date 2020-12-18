/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter13;

/**
 *
 * @author Damniel Junior
 *  A generic, fixed-size queue class.
 */
public class GenQueue<T> implements IGenQ<T>{
    private T q[];
    private int putloc, getloc; // put and get indices

    // construct an empry queue with the fiven array.

    public GenQueue(T[] aRef) {
        this.q = aRef;
        this.putloc = this.getloc = 0;
    }
    
    /**
     *
     * @param ch
     * @throws QueueFullException
     */
    @Override
    public void put(T ch) throws QueueFullException {
        if (putloc == q.length               ) {
            throw new QueueFullException(q.length);
        }
        q[putloc++] = ch;
    }

    @Override
    public T get() throws QueueEmptyException {
        if (getloc == putloc) {
            throw new QueueEmptyException();
        }
        return q[getloc++];
    }
    
}
