/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class DeckTest {
        Deck instance;
    public DeckTest() {
        instance = new Deck();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testShuffleDeck() {
        System.out.println("shuffleDeck");
        instance.shuffleDeck();
        assertTrue(instance.getCardsInTheDeck() == 52);
        instance.unShuffleDeck();
    }

    @Test
    public void testPickCard() {
        System.out.println("pickCard");
        Card expResult = new Card(CardRank.RK, CardSuit.SPADES);
        Card result = instance.pickCard();
        assertEquals(expResult, result);
    }

    @Test
    public void testPutCard() {
        System.out.println("putCard");
        Card c = new Card(CardRank.RK, CardSuit.SPADES);
        instance.unShuffleDeck();
        
        String expResult = c.toString();
        instance.putCardAtTheTop(c);
        String result = "";
        
        result = instance.pickCard().toString();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testDiscardTopCard() {
        System.out.println("discardTopCard");
        boolean expResult = true;
        boolean result = instance.discardTopCard();
        assertEquals(expResult, result);
    }
}
