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
public class TwoGen<T, V> {
    T ob1;
    V ob2;

    public TwoGen(T o1, V o2) {
        this.ob1 = o1;
        this.ob2 = o2;
    }
    
    T getOb1() {
        return ob1;
    }
    
    V getOb2() {
        return ob2;
    }

    boolean isSameType(TwoGen<T, V> o){
        return (ob1 == o.getOb1() && ob2 == o.getOb2());
    }
    
    public static void main(String[] args) {
        TwoGen<String, Integer> tg = new TwoGen<String, Integer>("Explicit Type", 100);
        TwoGen<String, Integer> tg2 = new TwoGen<>("Infered Type", 555);
        
        System.out.println("Explicit Type: " + tg.getOb1() + " " + tg.getOb2());
        System.out.println("Infered Type: " + tg2.getOb1() + " " + tg2.getOb2());
        System.out.println("They are equal? " + tg.isSameType(tg));
        System.out.println("They are equal? " + tg.isSameType(tg2));
        System.out.println("They are equal? " + tg.isSameType(new TwoGen<>("Banana", 101)));
        System.out.println("They are equal? " + tg.isSameType(new TwoGen<>("Explicit Type", 100)));
    }
    
}

