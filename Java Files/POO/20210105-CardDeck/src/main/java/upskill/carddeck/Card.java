/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Card implements Comparable<Card>{

    private final CardRank rank;
    private final CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(Card c) {
        this.rank = c.getRank();
        this.suit = c.getSuit();
    }
    
    
    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("Card: %s of %s", getRank().name().charAt(1), getSuit().name());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.rank);
        hash = 59 * hash + Objects.hashCode(this.suit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (this.suit != other.suit) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Card o) {
        return this.getRank().getRankValue() - o.getRank().getRankValue();
    }

}
