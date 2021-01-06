/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciopedrapapeltesoura;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Player {

    JanKenPonEnum choice;
    int victories;
    int id;
    static int countPlayer = 1;
    List<JanKenPonEnum> choices;

    public Player() {
        this.victories = 0;
        this.choices = new ArrayList<>();
        this.id  = countPlayer++;

    }

    public JanKenPonEnum getChoice() {
        return choice;
    }

    public void setChoice(JanKenPonEnum choice) {
        this.choice = choice;
        choices.add(choice);
    }

    public int getVictories() {
        return victories;
    }

//    public void setVictories(int victories) {
//        this.victories = victories;
//    }
    public void incVictories() {
        this.victories++;
    }

    public List<JanKenPonEnum> getChoices() {
        return choices;
    }

    public int getId() {
        return id;
    }

    public static int getCountPlayer() {
        return countPlayer;
    }

    @Override
    public String toString() {
        return "Player{" + "choice=" + choice + ", victories=" + victories + ", choices=" + choices + ", id=" + id + '}';
    }

    
}
