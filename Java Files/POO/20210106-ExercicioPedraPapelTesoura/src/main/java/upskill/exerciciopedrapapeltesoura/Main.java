/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciopedrapapeltesoura;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanKenPonGame game = new JanKenPonGame();

        Player p1 = new Player();
        Player p2 = new Player();

        game.addPlayer(p1);
        game.addPlayer(p2);

        int p1Choice;
        int p2Choice;

        while (!game.isThereAWinner()) {

            p1Choice = game.getPlayerChoice(p1);
            game.setChoice(p1Choice, p1);
            p2Choice = game.getPlayerChoice(p2);
            game.setChoice(p2Choice, p2);

            Player winner = game.checkHands(p1, p2);
            game.processRoundResult(winner);

            System.out.println("p1 || " + p1);
            System.out.println("p2 || " + p2);
            System.out.println("");
            System.out.println("Round Winner: " + winner);
            System.out.println("");
        }

        Player gameWinner = game.getWinner();
        System.out.println("All time Winner!!! -  " + gameWinner);
    }

}
