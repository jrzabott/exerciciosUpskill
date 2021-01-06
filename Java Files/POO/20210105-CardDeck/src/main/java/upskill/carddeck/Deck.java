/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class Deck {

    private List<Card> cards;
    private int id;
    private int cardsInTheDeck = 0;
    private static int deckCount = 0;

    public Deck() {
        id = deckCount++;
        cards = new ArrayList<>();
        createCards();
        shuffleDeck();
    }

    private void createCards() {
        cards.clear();
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                this.getCards().add(new Card(rank, suit));
                cardsInTheDeck++;
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.getCards());
    }

    public void unShuffleDeck() {
        cards.clear();
        cardsInTheDeck = 0;
        createCards();
    }

    public Card pickCard() {
        Card pickedCard = getCards().get(--cardsInTheDeck);
        return pickedCard;
    }

    public boolean putCard(Card c) {
        if (getCards().contains(c)) {
            return false;
        }
        return this.cards.add(c);
    }

    public void putCardAtTheTop(Card c) {
        if (getCards().contains(c)) {
            return;
        };

        this.cards.add(++cardsInTheDeck, c);
    }

    public boolean discardTopCard() {
        if (getCards().isEmpty()) {
            return false;
        }
//        System.out.println("Discarded:: " + getCards().get(--cardsInTheDeck));
//        return getCards().remove(getCards().get(cardsInTheDeck));
        return getCards().remove(getCards().get(--cardsInTheDeck));

    }

    /**
     * @return the cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the cardsInTheDeck
     */
    public int getCardsInTheDeck() {
        return cardsInTheDeck;
    }

    /**
     * @return the deckCount
     */
    public static int getDeckCount() {
        return deckCount;
    }

}
