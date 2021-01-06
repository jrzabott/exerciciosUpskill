/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciopedrapapeltesoura;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class JanKenPonGame {
    JanKenPonEnum p1Choice, p2Choice;
    int p1Victories, p2Victores;
    
    public void getChoice(int player){
        Scanner s = new Scanner(System.in);
        System.out.println(String.format("Player %d, entre com sua opção:%n1.Pedra%n2.Papel%n3.Tesoura:", player));
        int choice = s.nextInt();
        s.close();

        System.out.println(choice);
    }
}
