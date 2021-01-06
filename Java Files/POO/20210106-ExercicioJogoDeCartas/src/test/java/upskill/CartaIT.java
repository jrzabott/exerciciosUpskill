/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class CartaIT {
    
    public CartaIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }


    /**
     * Test of equals method, of class Carta.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        Carta instance = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class Carta.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Carta instance = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        Carta.EnumCartaTipo expResult =Carta.EnumCartaTipo.OITO;
        Carta.EnumCartaTipo result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNaipe method, of class Carta.
     */
    @Test
    public void testGetNaipe() {
        System.out.println("getNaipe");
        Carta instance = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        Carta.EnumCartaNaipe expResult =Carta.EnumCartaNaipe.PAUS;
        Carta.EnumCartaNaipe result = instance.getNaipe();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Carta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Carta instance = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS);
        String expResult = new Carta(Carta.EnumCartaTipo.OITO, Carta.EnumCartaNaipe.PAUS).toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
