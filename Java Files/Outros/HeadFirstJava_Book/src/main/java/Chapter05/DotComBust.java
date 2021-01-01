/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter05;

import java.util.*;

/**
 *
 * @author user
 */
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // first make some dot coms and give them locations
        DotCom one = new DotCom();
        one.setName("Pets.com");
        
        DotCom two = new DotCom();
        one.setName("eToys.com");
        
        DotCom three = new DotCom();
        one.setName("Go2.com");
        
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println(String.format("%s %s %s", one.getName(), two.getName(), three.getName()));
        System.out.println("Try to sink them all in the fewest number of guesses.");
        
        for (DotCom dotCom : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotCom.setLocationCells(newLocation);
        }
    }
    
    private void startPlaying(){
        while (!dotComsList.isEmpty()) {            
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGess(userGuess);
        }
        finishGame();
    }

    private void checkUserGess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        
        for (DotCom dotCom : dotComsList) {
            result = dotCom.checkYourself(userGuess);
            if ("hit".equals(result)) {
                break;
            }
            if ("kill".equals(result)) {
                dotComsList.remove(dotCom);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fishes are dancing with your options.");
        }
    }
    
    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
