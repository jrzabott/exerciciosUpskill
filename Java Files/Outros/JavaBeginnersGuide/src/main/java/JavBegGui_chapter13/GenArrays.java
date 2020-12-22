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
public class GenArrays<T extends Number> {

    T ob;
    T vals[]; // OK

    GenArrays(T o, T nums[]) {
        ob = o;

        //this is illegal:
        // vals = new T[10];
        // however this is legal:
        vals = nums; // OK to assign ref to existent array
    }
}
