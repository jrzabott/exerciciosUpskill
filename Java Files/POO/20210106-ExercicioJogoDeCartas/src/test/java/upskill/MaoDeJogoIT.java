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
public class MaoDeJogoIT {
    
    public MaoDeJogoIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getCartas method, of class MaoDeJogo.
     */
    @Test
    public void testGetCartas() {
        System.out.println("getCartas");
        MaoDeJogo instance = new MaoDeJogo();
        instance.addCarta(new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS));
        MaoDeJogo outraMao = new MaoDeJogo();
        outraMao.addCarta(new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS));
        List<Carta> expResult = outraMao.getCartas();
        List<Carta> result = instance.getCartas();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCarta method, of class MaoDeJogo.
     */
    @Test
    public void testAddCarta() {
        System.out.println("addCarta");
        Carta c = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        MaoDeJogo instance = new MaoDeJogo();
        boolean expResult = true;
        boolean result = instance.addCarta(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of tiposDeCarta method, of class MaoDeJogo.
     */
    @Test
    public void testTiposDeCarta() {
        System.out.println("tiposDeCarta");
        MaoDeJogo instance = new MaoDeJogo();
        List<Carta> expResult = instance.getCartas();
        List<Carta> result = instance.tiposDeCarta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenar method, of class MaoDeJogo.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        MaoDeJogo instance = new MaoDeJogo();
        instance.ordenar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contarCartasDoTipo method, of class MaoDeJogo.
     */
    @Test
    public void testContarCartasDoTipo() {
        System.out.println("contarCartasDoTipo");
        Carta.EnumCartaTipo cartaTipo = null;
        MaoDeJogo instance = new MaoDeJogo();
        int expResult = 0;
        int result = instance.contarCartasDoTipo(cartaTipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MaoDeJogo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MaoDeJogo instance = new MaoDeJogo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of equals method, of class MaoDeJogo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        MaoDeJogo instance = new MaoDeJogo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
