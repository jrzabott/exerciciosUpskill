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
class FixedQueue implements ICharQ {

    private char q[]; // this array holds the queue
    private int putloc, getloc; //put and get indices
    
    // Construct an empty queue given its size.
    public FixedQueue(int size){
        this.q = new char[size];
        this.putloc = this.getloc = 0;
    }
    
    //put a char into the array
    @Override
    public void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        
        q[putloc++] = ch;
    }

    // Get a char from the queue
    @Override
    public char get() {
        if (getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        
        return q[getloc++];
    }
    
}
