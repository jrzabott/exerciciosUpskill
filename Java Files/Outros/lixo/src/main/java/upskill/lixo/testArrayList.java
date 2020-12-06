/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.lixo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class testArrayList {
    int num;
    ArrayList<String> Atletas;

    public testArrayList(int num) {
        this.num = num;
        this.Atletas = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return "testArrayList{" + "num=" + num + ", Atletas=" + Atletas + '}';
    }
    
    
    
    
}
