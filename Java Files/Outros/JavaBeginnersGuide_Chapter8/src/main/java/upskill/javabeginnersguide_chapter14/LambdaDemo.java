/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter14;

interface MyValue {

    double getValue();
}

interface MyParamValue {

    double getValue(double v);
}
// both above interfaces are called "FUNCTIONAL INTERFACES" due to the fact
// both have only a single method.

/**
 *
 * @author user
 */
public class LambdaDemo {

    public static void main(String[] args) {

        MyValue myVal; // interface reference

        // Here, the lambda exp is simply a constant expression.
        // When, it is assigned to myVal, a class instance is constructed in which
        // the lambda expression implements the getValue() method in MyValue.
        myVal = () -> 98.6;
        
        // call getValue(), which is provided by the previously assigned
        // lambda expression
        System.out.println("A constant value: " + myVal.getValue());
        
        // Now, create a parametrized lambda expression and assign it to a
        // MyParamValue reference. This lambda expression returns the reciprocal of its argument.
        MyParamValue myPVal = (n) -> 1.0 / n;
        
        // Call getValue(v) through myPVal reference.
        System.out.println("Reciprocal of 4 is " + myPVal.getValue(4));
        System.out.println("Reciprocal of 8 is " + myPVal.getValue(8));
        
        // A Lambda exp must be compatible with the method defined by the functional interface.
        // Therefore, these won't work
        // myVal = () -> "three"; // Error, String not compatible with double!
        // myPVal = () -> Math.random(); // Error: parameter required.
    }
}
