/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciocar4rent;

/**
 *
 * @author user
 */
public class CarMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Car c1 = new Car("BB-15-AA", 1990, 10, 100, 1300);
       Car c2 = new Car("CC-15-AA", 2017, 12, 150, 1600);
       Car c3 = new Car("XP-15-TO", 2020, 18, 300, 2000);
       
        System.out.println(c1.getClassificacao());
        System.out.println(c2.getClassificacao());
        System.out.println(c3.getClassificacao());
        
        c1.setANO_CLASSIFICACAO_RECENTE(3);
        
        System.out.println(c1.getClassificacao());
        System.out.println(c2.getClassificacao());
        System.out.println(c3.getClassificacao());

    }
    
}
