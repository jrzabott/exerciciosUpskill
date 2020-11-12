/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioimpostos;

import java.util.Comparator;

/**
 *
 * @author user
 */
public class ContribuinteNomeComparator implements Comparator<Contribuinte>{

    @Override
    public int compare(Contribuinte o1, Contribuinte o2) {
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
    
}
