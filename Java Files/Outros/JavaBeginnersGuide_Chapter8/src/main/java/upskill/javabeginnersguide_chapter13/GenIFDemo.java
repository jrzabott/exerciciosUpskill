/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter13;

interface Containment<T> {

    boolean contains(T o);
}

class MyClass<T> implements Containment<T> {

    T[] arrayRef;

    public MyClass(T[] o) {
        this.arrayRef = o;
    }

    @Override
    public boolean contains(T o) {
        for (T x : arrayRef) {
            if (x.equals(o)) {
                return true;
            }
        }
        return false;
    }

}

/**
 *
 * @author user
 */
public class GenIFDemo {
    public static void main(String[] args) {
        Integer x[] = {1, 2, 3};
        
        MyClass<Integer> ob = new MyClass<Integer>(x);
        if (ob.contains(2)) {
            System.out.println("2 is in ob");
        } else {
            System.out.println("2 not in ob");
        }
        if (ob.contains(4)) {
            System.out.println("4 is in ob");
        } else {
            System.out.println("4 not in ob");
        }
    }
}
