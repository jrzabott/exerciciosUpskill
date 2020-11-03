/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class MainCumprimentar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(String.format("%04d",2));
        Scanner s = new Scanner(System.in);
        
        System.out.println("Entre com nome da pessoa ");
        String nome = s.nextLine();
        
        
        Cumprimentar pessoa1 = new Cumprimentar(nome);
        Cumprimentar pessoa2 = new Cumprimentar();

        System.out.println("pessoa1 = " + pessoa1.getName());
        pessoa1.setName("Jorge Alberto");
        pessoa1.setIdade(37);
        System.out.println("pessoa1 = " + pessoa1.getName());
        System.out.println("pessoa2 = " + pessoa2.getName());
        System.out.println(pessoa1);
        System.out.println(pessoa2);
    }

}
