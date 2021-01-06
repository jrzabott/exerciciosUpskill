/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class BaralhoIT {
    
    public BaralhoIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of baralhar method, of class Baralho.
     */
    @Test
    public void testBaralhar() {
        System.out.println("baralhar");
        Baralho instance = new Baralho();
        instance.baralhar();
        Baralho expResult = new Baralho();
        assertNotEquals(expResult, instance);
    }

    /**
     * Test of retirarCarta method, of class Baralho.
     */
    @Test
    public void testRetirarCarta() {
        System.out.println("retirarCarta");
        Baralho instance = new Baralho();
        Carta expResult = new Baralho().retirarCarta();
        Carta result = instance.retirarCarta();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Baralho.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Baralho instance = new Baralho();
        String expResult = new Baralho().toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }


    /**
     * Test of equals method, of class Baralho.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Baralho obj = new Baralho();
//        obj.baralhar();
        Baralho instance = new Baralho();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
