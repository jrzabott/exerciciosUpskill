/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VideoPokerMachine vpm = new VideoPokerMachine();

        List<Card> myHand = new ArrayList<>();
        myHand.add(new Card(CardRank.R9, CardSuit.CLUBS));
        myHand.add(new Card(CardRank.RT, CardSuit.CLUBS));
        myHand.add(new Card(CardRank.RJ, CardSuit.CLUBS));
        myHand.add(new Card(CardRank.RQ, CardSuit.CLUBS));
        myHand.add(new Card(CardRank.RK, CardSuit.CLUBS));

        vpm.setHand(myHand);
        System.out.println(vpm.getHand());
        System.out.println("vpm.isFlush() - " + vpm.isFlush());
        System.out.println("vpm.isStraight() - " + vpm.isStraight());
        System.out.println("vpm.isStraightFlush()" + " - " + vpm.isStraightFlush());
        System.out.println("vpm.isRoyalFlush()" + " - " + vpm.isRoyalFlush());
        System.out.println("vpm.isFourOfAKind()" + " - " + vpm.isFourOfAKind());
        System.out.println("vpm.isFullHouse()" + " - " + vpm.isFullHouse());
        System.out.println("vpm.isThreeOfAKind()" + " - " + vpm.isThreeOfAKind());
        System.out.println("vpm.isTwoPairs()" + " - " + vpm.isTwoPairs());
        System.out.println("vpm.isPair()" + " - " + vpm.isPair());
        

//        int countFlush = 0;
//        for (int i = 0; i < 20000; i++) {
//            vpm.newHand();
//            if (vpm.isFlush()) {
//                System.out.println(vpm.getHand() + " - " + vpm.isFlush());
//                countFlush++;
//            }
//
//        }
//        System.out.println("Flushes: " + countFlush);

    }

}
