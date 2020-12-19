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
public class Gen <T>{ // <T> is the generic type parameter
    T ob; // declare an object of type T
    
    // Pass the cnostrcutor a reference to
    // an object of type T.
    Gen(T o){
        ob = o;
    }
    
    // Return ob.
    T getob() {
        return ob;
    }
    
    // Show type of T
    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}
