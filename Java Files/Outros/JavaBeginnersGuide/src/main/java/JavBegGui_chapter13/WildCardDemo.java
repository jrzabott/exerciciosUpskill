/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavBegGui_chapter13;

/**
 *
 * @author user
 */
public class WildCardDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumericFns<Integer> iOb = new NumericFns<Integer>(6);
        NumericFns<Double> dOb = new NumericFns<Double>(-6.0);
//        NumericFns<Long> lOb = new NumericFns<Long>(5L);
        NumericFns<Long> lOb = new NumericFns<Long>(6L);
        
        System.out.println("Testing iOb and dOb.");
        System.out.println("Absolute values are: " + ((iOb.absEqual(dOb) ? "equal" : "different") + "."));
        
        System.out.println();
        
        System.out.println("Testing iOb and lOb.");
        System.out.println("Absolute values are: " + ((iOb.absEqual(lOb) ? "equal" : "different") + "."));
    }
    
}
