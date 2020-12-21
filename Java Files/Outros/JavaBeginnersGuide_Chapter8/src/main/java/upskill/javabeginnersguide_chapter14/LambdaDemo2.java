/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter14;

interface NumericTest {
    boolean test(int n, int m);
}

/**
 *
 * @author user
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        // check if a number a factor of another.
        NumericTest isFactor = (n, d) -> (n % d) == 0;
        
        if (isFactor.test(10, 2)) {
            System.out.println("2 is a factor of 10");
        }
        if (!isFactor.test(10, 3)) {
            System.out.println("3 is not a factor of 10");
        }
        System.out.println();
        
        // this lambda returns true if the first argument is less than the second
        NumericTest lessThan = (n, m) -> (n < m);
        
        if (lessThan.test(2, 10)) {
            System.out.println("2 is less than 10");
        }
        if (!lessThan.test(10, 2)) {
            System.out.println("10 is not less than 2");
        }
        System.out.println();
        
        // This exp returns true is abs values of the arguments are equal
        NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
        
        if (absEqual.test(2, -2)) {
            System.out.println("Abs of values 4 and -4 are equal");
        }
        if (!absEqual.test(-10, 19)) {
            System.out.println("Abs values of 10 and 10 are not equal");
        }
        System.out.println();
    }
}
