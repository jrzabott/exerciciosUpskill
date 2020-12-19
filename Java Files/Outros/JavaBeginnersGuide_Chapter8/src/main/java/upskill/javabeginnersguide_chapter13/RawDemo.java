/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter13;

class RawGen<T> {

    T ob;

    // Pass the constructor a ref to an obj of type T
    RawGen(T o) {
        ob = o;
    }

    // return ob
    T getOb() {
        return ob;
    }
}

/**
 *
 * @author user
 */
public class RawDemo {

    public static void main(String[] args) {
        // create Gen for Int
        RawGen<Integer> iOb = new RawGen<Integer>(88);

        // create Gen for String
        RawGen<String> sOb = new RawGen<String>("Generics Test");

        // create raw-type Gen and give it a Double value;
        RawGen raw = new RawGen(98.6);

        // Cast here is necessary because type is unknown
        double d = (double) raw.getOb();
        System.out.println("value: " + d);

        // The use of a raw type can lead to runtime exceptions. Some examples
        // int i = (Integer) raw.getOb(); // this causes a runtime error
        sOb = raw; // OK, but potentially wrong.
        // String str = sOb.getOb(); // runtime error
        raw = iOb; // OK, but potentially wrong
        // d = (Double) raw.getOb(); // runtime error

    }
}
