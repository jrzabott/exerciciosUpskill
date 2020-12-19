/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter13;

/**
 *
 * @author user
 */
public class GenArraysDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer n[] = {1, 2, 3, 4, 5};
        
        GenArrays<Integer> iOb = new GenArrays<Integer>(50, n);
        
        // Can't create an array of type-especific generic refs
        // Gen<Integer> gens[[ = new Gen<Integer>[10]: // This is wrong;
        
        // However, this is OK:
        GenArrays<?> gens[] = new GenArrays<?>[10];
    }
    
}
