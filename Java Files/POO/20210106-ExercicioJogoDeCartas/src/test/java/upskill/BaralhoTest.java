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
public class BaralhoTest {
    
    public BaralhoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getCartas method, of class Baralho.
     */
    @Test
    public void testGetCartas() {
        System.out.println("getCartas");
        Baralho instance = new Baralho();
        List<Carta> expResult = null;
        List<Carta> result = instance.getCartas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCartas method, of class Baralho.
     */
    @Test
    public void testSetCartas() {
        System.out.println("setCartas");
        List<Carta> cartas = null;
        Baralho instance = new Baralho();
        instance.setCartas(cartas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of baralhar method, of class Baralho.
     */
    @Test
    public void testBaralhar() {
        System.out.println("baralhar");
        Baralho instance = new Baralho();
        instance.baralhar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirarCarta method, of class Baralho.
     */
    @Test
    public void testRetirarCarta() {
        System.out.println("retirarCarta");
        Baralho instance = new Baralho();
        Carta expResult = null;
        Carta result = instance.retirarCarta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Baralho.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Baralho instance = new Baralho();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Baralho.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Baralho instance = new Baralho();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Baralho.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Baralho instance = new Baralho();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
