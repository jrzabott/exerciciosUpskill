/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter08;

/**
 *
 * @author user
 */
// A character queue interface.
public interface ICharQ {
    
    // Put a char into the queue
    void put(char ch) throws QueueFullException;
    
    // Get a char from the queue
    char get() throws QueueEmptyException;
}
