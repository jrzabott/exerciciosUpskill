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

    Ponto instance = new Ponto(0, 1);

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
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetY() {
        System.out.println("getY");
        int expResult = 1;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetX() {
        System.out.println("setX");
        int X = 1;
        instance.setX(X);
        assertEquals(X, instance.getX());
        instance.setX(0);

    }

    @Test
    public void testSetY() {
        System.out.println("setY");
        int Y = 0;
        Ponto instance = new Ponto();
        instance.setY(Y);
        assertEquals(Y, instance.getY());
        instance.setY(1);
    }

    @Test
    public void testMovePoint_int_int() {
        System.out.println("movePoint");
        int x1 = 1;
        int y1 = 0;
        Ponto instance = new Ponto(0, 1);
        Ponto expResult = new Ponto(1, 0);
        instance.movePoint(x1, y1);
        Ponto result = instance;
        assertEquals(expResult, result);
    }

    @Test
    public void testMovePoint_Ponto() {
        System.out.println("movePoint");
        Ponto otherP = new Ponto(1, 0);
        Ponto instance = new Ponto(0, 1);
        Ponto expResult = otherP.clone();
        instance.movePoint(otherP);
        Ponto result = instance;
        assertEquals(expResult, result);
    }

    @Test
    public void testClone() {
        System.out.println("clone");
        Ponto instance = new Ponto();
        Ponto expResult = new Ponto();
        Ponto result = instance.clone();
        assertEquals(expResult, result);
    }

    @Test
    public void testIncX() {
        System.out.println("incX");
        int i = 1;
        int x = 0;
        Ponto instance = new Ponto(x, 0);
        instance.incX(i);
        assertEquals(instance.getX(), x + i);
    }

    @Test
    public void testIncY() {
        System.out.println("incY");
        int i = 0;
        int y = 0;
        Ponto instance = new Ponto(0, y);
        instance.incY(i);
        assertEquals(instance.getY(), y + i);
    }

}
