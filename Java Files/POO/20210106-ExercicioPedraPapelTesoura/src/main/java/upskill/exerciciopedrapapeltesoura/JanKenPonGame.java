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

    public void addPlayer(Player p){
        players.add(p);
    }
    
    public int getPlayerChoice(Player player) {
        Scanner s = new Scanner(System.in);
        System.out.println(String.format(
                "%nPlayer %d, entre com sua opção:%n1.Pedra%n2.Papel%n3.Tesoura:",
                 player.getId()));
        int choice = Integer.parseInt(s.nextLine());
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
    
    public void processRoundResult(Player p){
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
    
    
}
