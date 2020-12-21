/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.javabeginnersguide_chapter14;

interface IntPredicate2 {

    boolean test(int n);
}

class MyIntNum {

    private int v;

    public MyIntNum(int v) {
        this.v = v;
    }

    int getNum() {
        return this.v;
    }

    boolean isFactor(int n) {
        return (v % n) == 0;
    }
}

/**
 *
 * @author user
 */
public class MethodRefDemo2 {

    public static void main(String[] args) {
        boolean result;

        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);

        //Here, a mthod ref to idFactor on myNum is created.
        IntPredicate2 ip = myNum::isFactor;

        // Now, it is used to call isFactor() via test()
        result = ip.test(3);
        if (result) {
            System.out.println("3 is a factor of " + myNum.getNum());
        }

        ip = myNum2::isFactor;
        result = ip.test(3);
        if (!result) {
            System.out.println("3 is not a factor of " + myNum2.getNum());

        }
    }
}
