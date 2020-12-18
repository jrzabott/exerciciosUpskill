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
public class NumericFns<T extends Number> {

    T num;

    //Pass the constructor a ref to a num object
    public NumericFns(T n) {
        num = n;
    }

    // return the reciprocal
    double reciprocal() {
        return 1 / num.doubleValue();
    }

    // return the fractional part of a number
    double faction() {
        return num.doubleValue() - num.intValue();
    }

    // Determine if abs valuues of 2 obj are the same
    boolean absEqual(NumericFns<?> ob) { // atentino to the WILDCARD symbol
        return (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue()));
    }
}
