/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciolojacomercial;

/**
 *
 * @author user
 */
public class LojaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //a criar 3 lojas
        Loja l1 = new Loja(1, "Primeira Loja", 20, 1000);
        Loja l2 = new Loja(2, "Segunda Loja", 45, 2000);
        Loja l3 = new Loja(3, "Terceira Loja", 123, 45000);
        
        Loja.setRendaFixa(1000);
        
        System.out.println(l1.getClassificaoLoja() + " " + l1.getArea() + " - " + l1.getRenda());
        System.out.println(l2.getClassificaoLoja() + " " + l2.getArea() + " - " + l2.getRenda());
        System.out.println(l3.getClassificaoLoja() + " " + l3.getArea() + " - " + l3.getRenda());
        
        Loja.setAREA_MAX_LOJA_MEDIA(50.0);
        
        System.out.println(l1.getClassificaoLoja() + " " + l1.getArea() + " - " + l1.getRenda());
        System.out.println(l2.getClassificaoLoja() + " " + l2.getArea() + " - " + l2.getRenda());
        System.out.println(l3.getClassificaoLoja() + " " + l3.getArea() + " - " + l3.getRenda());
        
    }
    
}
