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
public class GenDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create Gen ref for INteger
        Gen<Integer> iOb;
        
        // Create a Gen<Integer> obj and assign its ref to iOb.
        // Notice the value 88 within an Integer obj.
        iOb = new Gen<Integer>(88);
        
        // Show the type of data used by iOb.
        iOb.showType();
        
        // Get the value in iOb. Notice that no cast is needed.
        int v = iOb.getob();
        System.out.println("value: " + v);
        System.out.println();
        
        // create a Gen object for Strings
        Gen<String> strOb = new Gen<String>("Generics Test");
        
        // Show the type of data used by streOb
        strOb.showType();
        
        // Get the value of strOb. Again, notice the no cast is needed.
        String str = strOb.getob();
        System.out.println("value: " + str);
    }
    
}
