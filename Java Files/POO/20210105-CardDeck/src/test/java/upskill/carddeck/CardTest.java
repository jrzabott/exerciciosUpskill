/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.carddeck;

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
public class CardTest {
    
    Card AClubs, KHearts;
    
    public CardTest() {
        AClubs = new Card(CardRank.RA, CardSuit.CLUBS);
        KHearts = new Card(CardRank.RK, CardSuit.HEARTS);
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
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = AClubs;
        CardRank expResult = CardRank.RA;
        CardRank result = instance.getRank();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetRankValue() {
        System.out.println("getRankValue");
        Card instance = AClubs;
        int expResult = CardRank.RA.getRankValue();
        int result = instance.getRank().getRankValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = AClubs;
        CardSuit expResult = CardSuit.CLUBS;
        CardSuit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = AClubs;
        String expResult = "Card: A of CLUBS";
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Card(CardRank.RA, CardSuit.CLUBS);
        Card instance =  AClubs;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
