/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter14;

interface IntPredicate {
    boolean test(int n);
}

// This class defines three static methods to check an int against some condition.
class MyIntPredicates {

    // static method that returns true if a number is prime.

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n / i; i++)
            if (n % i == 0) return false;
        return true;
    }
    
    static boolean isEven(int n){
        return (n % 2) == 0;
    }
    static boolean isPositive(int n){
        return (n > 0);
    }
}

/**
 *
 * @author user
 */
public class MethodRefDemo {
    // this method has a functional interface as the type os its 1st param.
    // Thus, it can be passed a red to any instance of that interface, including
    // one created by a method ref.
    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }
    
    public static void main(String[] args) {
        boolean result;
        
        // A method ref to isPrime is passed to numTest();
        result = numTest(MyIntPredicates::isPrime, 17);
        if (result) System.out.println("17 is prime");
        
        result = numTest(MyIntPredicates::isEven, 12);
        if (result) System.out.println("12 is even");
        
        result = numTest(MyIntPredicates::isPositive, 2);
        if (result) System.out.println("2 is positive");
        
        
    }
}
