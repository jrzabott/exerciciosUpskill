/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciopedrapapeltesoura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class JanKenPonGame {

    List<Player> players;
    int round;

    public JanKenPonGame() {
        this.players = new ArrayList<Player>();
        this.round = 1;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public int getPlayerChoice(Player player) {
        Scanner s = new Scanner(System.in);

        int choice = 0;
        boolean logicTest = false;
        logicTest = (choice < 1 || choice > 3);
        while (choice < 1 || choice > 3) {
            System.out.println(String.format(
                    "%nPlayer %d, entre com sua opção:%n1.Pedra%n2.Papel%n3.Tesoura:",
                    player.getId()));
            String temp = s.nextLine();
            try {
                choice = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                choice = 0;
            }
            logicTest = (choice < 1 || choice > 3);
        }
        return choice;
    }

    public void setChoice(int choice, Player player) {
        switch (choice) {
            case 1:
                player.setChoice(JanKenPonEnum.PEDRA);
                break;
            case 2:
                player.setChoice(JanKenPonEnum.PAPEL);
                break;
            case 3:
                player.setChoice(JanKenPonEnum.TESOURA);
                break;
            default:
        }
    }

    public Player checkHands(Player p1, Player p2) {
        Player result = null;

        switch (p1.getChoice()) {
            case PAPEL:
                switch (p2.getChoice()) {
                    case TESOURA:
                        return p2;
                    case PEDRA:
                        return p1;
                    default:
                }
                break;
            case PEDRA:
                switch (p2.getChoice()) {
                    case PAPEL:
                        return p2;
                    case TESOURA:
                        return p1;
                    default:
                }
                break;
            case TESOURA:
                switch (p2.getChoice()) {
                    case PEDRA:
                        return p2;
                    case PAPEL:
                        return p1;
                    default:
                }
                break;
            default:
        }

        return result;
    }

    public void processRoundResult(Player p) {
        if (p != null) {
            p.incVictories();
        }
    }

    public boolean isThereAWinner() {
        for (Player player : players) {
            if (player.getVictories() == 3) {
                return true;
            }
        }
        return false;
    }

    public Player getWinner() {
        for (Player player : players) {
            if (player.getVictories() == 3) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }

    public void addTwoPlayers() {
        Player p1 = new Player();
        Player p2 = new Player();

        addPlayer(p1);
        addPlayer(p2);
    }

    public void startGame() {
        addTwoPlayers();

        while (!isThereAWinner()) {
            for (Player p : players) {
                setChoice(getPlayerChoice(p), p);
            }

            Player winner = checkHands(players.get(0), players.get(1));
            processRoundResult(winner);

            System.out.println("");
            System.out.println("Round " + round++ + " : " + ((winner != null) ? "P" + winner.getId() + " won this Round. P1 ("+players.get(0).getChoice().name()+" x " + players.get(1).getChoice().name() + ") P2" : "Too bad. It's a draw... Keep Playing!!!"));
            System.out.println("");
        }
        Player gameWinner = getWinner();

        System.out.println("..... ----- ===== ########## ===== ----- .....");
        System.out.println("All time Winner!!! -  " + gameWinner);
        System.out.println("..... ----- ===== ########## ===== ----- .....");
    }
}
