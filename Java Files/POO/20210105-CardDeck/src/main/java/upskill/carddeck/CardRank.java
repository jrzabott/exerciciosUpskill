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
public enum CardRank {
    RA (1), 
    R2 (2), 
    R3 (3), 
    R4 (4), 
    R5 (5), 
    R6 (6), 
    R7 (7), 
    R8 (8), 
    R9 (9), 
    RT (10), 
    RJ (11), 
    RQ (12), 
    RK (13);
    private final int rank;

    private CardRank(int rank) {
        this.rank = rank;
    }
    public int getRankValue(){
        return this.rank;
    }
    
}
