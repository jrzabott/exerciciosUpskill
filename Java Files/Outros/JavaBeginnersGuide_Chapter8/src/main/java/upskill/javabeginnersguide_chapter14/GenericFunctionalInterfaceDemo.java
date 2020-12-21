/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter14;

// A generic interface with two params that return boolean result
interface SomeTest<T> {

    boolean test(T n, T m);
}

/**
 *
 * @author user
 */
public class GenericFunctionalInterfaceDemo {

    public static void main(String[] args) {

        // This exp determines if one int is a factor of another
        SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2)) {
            System.out.println("2 is a factor of 10\n");
        }

        // This lambda dets if one Double is a factor of another
        SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
        if (isFactorD.test(212.0, 4.0)) {
            System.out.println("4.0 is a factor os 212.0");
        }

        // One string is part of another
        SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
        if (isIn.test("Generic Functional Interface", "face")) {
            System.out.println("'face' is found");
        } else {
            System.out.println("'face' not found");
            
        }
    }
}
