/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class VideoPokerMachine {

    private Deck deck;
    private List<Card> hand;

    public VideoPokerMachine() {
        this.deck = new Deck();
        this.hand = new ArrayList<>();
        this.hand = generate5CardHand();
    }

    private void rebuildDeck() {
        this.deck = null;
        this.deck = new Deck();
    }

    public void newHand() {
        this.hand = generate5CardHand();
    }

    private List<Card> generate5CardHand() {
        if (hand.size() != 0) {
            this.hand.clear();
        }
        rebuildDeck();
//        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.deck.discardTopCard();
            this.hand.add(deck.pickCard());
        }
        return hand;
    }

    public List<Card> getHand() {
        return hand;
    }
    
    //TODO Criar Função evalHand()
    //TODO Criar prêmios para acertos
    //TODO Criar Fluxo de Caixa/Fichas

    public boolean isFlush() {

        for (CardSuit suit : CardSuit.values()) {
            int countSuit = 0;
            for (Card card : hand) {
                if (card.getSuit() == suit) {
                    countSuit++;
                }
            }
            if (countSuit == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraight() {
        boolean result = true;
        List<Card> temp = new ArrayList<>(this.hand);
        Collections.sort(temp);
//        System.out.println("\nTemp Sorted Hand: " + temp + "\n");
        for (int i = 1; i < temp.size() - 1; i++) {
            int thisCard = temp.get(i).getRank().getRankValue();
            int nextCard = temp.get(i + 1).getRank().getRankValue();
            if (nextCard - thisCard != 1) {
                result = false;
            }
        }
        if (temp.get(0).getRank() == CardRank.RA && temp.get(4).getRank() == CardRank.RK && result) {
            result = true;
        }
        return result;
    }

    public boolean isStraightFlush() {
        return isFlush() && isStraight();
    }
    
    public boolean isRoyalFlush(){
        int countCards = 0;
        if (isStraightFlush()) {
            for (Card card : hand) {
                countCards += card.getRank().getRankValue();
            }
        }
        
        int somaValoresRoyalFlush = (
                CardRank.RA.getRankValue()
                + CardRank.RT.getRankValue()
                + CardRank.RJ.getRankValue()
                + CardRank.RQ.getRankValue()
                + CardRank.RK.getRankValue()
                );
        
        return isStraightFlush() && countCards == somaValoresRoyalFlush;
    }

    public boolean isFourOfAKind() {
        int countRank = 0;
        List<CardRank> ranks = new ArrayList<>();
        for (Card card : hand) {
            ranks.add(card.getRank());
        }
        for (CardRank rank : ranks) {
            if (Collections.frequency(ranks, rank) == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse() {
        List<Card> temp = new ArrayList<>(this.hand);
        List<CardRank> ranks = new ArrayList<>();

        Collections.sort(temp, Collections.reverseOrder());
        for (Card card : temp) {
            if (!ranks.contains(card.getRank())) {
                ranks.add(card.getRank());
            }
        }
        return (ranks.size() == 2) ? true : false;
    }

    public boolean isThreeOfAKind() {
        List<CardRank> uniqueRanks = new ArrayList<>();
        List<CardRank> handRanks = new ArrayList<>();

        for (Card card : hand) {
            if (!uniqueRanks.contains(card.getRank())) {
                uniqueRanks.add(card.getRank());
            }
            handRanks.add(card.getRank());
        }
        if (uniqueRanks.size() == 3) {
            for (CardRank rank : uniqueRanks) {
                if (Collections.frequency(handRanks, rank) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTwoPairs() {
        List<CardRank> uniqueRanks = new ArrayList<>();
        List<CardRank> handRanks = new ArrayList<>();

        for (Card card : hand) {
            if (!uniqueRanks.contains(card.getRank())) {
                uniqueRanks.add(card.getRank());
            }
            handRanks.add(card.getRank());
        }
        if (uniqueRanks.size() == 3) {
            int countPair = 0;
            for (CardRank rank : uniqueRanks) {
                if (Collections.frequency(handRanks, rank) == 2) {
                    countPair++;
                }
            }
            if (countPair == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isPair() {
        List<CardRank> ranks = new ArrayList<>();

        for (Card card : hand) {
            if (!ranks.contains(card.getRank())) {
                ranks.add(card.getRank());
            }
        }
        if (ranks.size() == 4) {
            return true;
        }
        return false;
    }

//    public CardRank highestRankOnAFullHouse(){
//        List<Card> temp = new ArrayList<>(this.hand);
//        List<CardRank> ranks = new ArrayList<>();
//        Collections.sort(temp);
//        
//        for (Card card : temp) {
//            if (!ranks.contains(card.getRank())) {
//                ranks.add(card.getRank());
//            }
//        }
//        
//        if (ranks.contains(CardRank.RA)) {
//            return CardRank.RA;
//        } else {
//            return temp.get(temp.size() - 1).getRank();
//        }
//    }
//
//    public CardRank lowestRankOnAFullHouse(){
//        List<Card> temp = new ArrayList<>(this.hand);
//        List<CardRank> ranks = new ArrayList<>();
//        Collections.sort(temp);
//        
//        for (Card card : temp) {
//            if (!ranks.contains(card.getRank())) {
//                ranks.add(card.getRank());
//            }
//        }
//        
//        if (ranks.contains(CardRank.RA)) {
//            return CardRank.RA;
//        } else {
//            return temp.get(temp.size() - 4).getRank();
//        }
//    }
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setHand() {
        this.hand = generate5CardHand();
    }

}
