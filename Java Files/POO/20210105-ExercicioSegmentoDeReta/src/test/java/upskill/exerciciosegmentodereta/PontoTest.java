/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exerciciosegmentodereta;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class PontoTest {
    
    public PontoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testGetX() {
        System.out.println("getX");
        Ponto instance = new Ponto();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetY() {
        System.out.println("getY");
        Ponto instance = new Ponto();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetX() {
        System.out.println("setX");
        int X = 0;
        Ponto instance = new Ponto();
        instance.setX(X);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetY() {
        System.out.println("setY");
        int Y = 0;
        Ponto instance = new Ponto();
        instance.setY(Y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testMovePoint_int_int() {
        System.out.println("movePoint");
        int x1 = 0;
        int y1 = 0;
        Ponto instance = new Ponto();
        Ponto expResult = null;
        Ponto result = instance.movePoint(x1, y1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testMovePoint_Ponto() {
        System.out.println("movePoint");
        Ponto otherP = null;
        Ponto instance = new Ponto();
        Ponto expResult = null;
        Ponto result = instance.movePoint(otherP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testClone() {
        System.out.println("clone");
        Ponto instance = new Ponto();
        Ponto expResult = null;
        Ponto result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testIncX() {
        System.out.println("incX");
        int i = 0;
        Ponto instance = new Ponto();
        instance.incX(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testIncY() {
        System.out.println("incY");
        int i = 0;
        Ponto instance = new Ponto();
        instance.incY(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
