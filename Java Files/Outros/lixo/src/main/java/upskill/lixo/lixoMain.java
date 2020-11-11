/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.lixo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class lixoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Double> myAL = new ArrayList<Double>();
        myAL.add(1.0);
        myAL.add(10.0);
        myAL.add(100.0);
        myAL.add(103.0);
        
        
        myAL.removeIf((t) -> {
            return (t % 5 == 0);
        });
        System.out.println(myAL);
        
    }
    
}
