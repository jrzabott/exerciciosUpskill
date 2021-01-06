/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

/**
 *
 * @author user
 */
public enum HandResults {
    ROYAL_FLUSH(0),
    STRAIGHT_FLUSH(1),
    FOUR_OF_A_KIND(2),
    FULL_HOUSE (3),
    FLUSH(4),
    STRAIGHT(5),
    THREE_OF_A_KIND(6),
    TWO_PAIRS(7),
    ONE_PAIR(8),
    HIGH_CARD(9);
    
    private final int value;
    
    private HandResults(int i){
        value = i;
    }
}
