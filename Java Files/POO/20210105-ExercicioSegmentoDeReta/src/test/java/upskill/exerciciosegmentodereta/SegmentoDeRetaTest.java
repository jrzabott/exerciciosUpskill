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
public class SegmentoDeRetaTest {

    Ponto PA = new Ponto(0, 0);
    Ponto PB = new Ponto(0, 1);
    SegmentoDeReta instance = new SegmentoDeReta(PA, PB);

    public SegmentoDeRetaTest() {
    }

    /**
     * Test of getA method, of class SegmentoDeReta.
     */
    @org.junit.jupiter.api.Test
    public void testGetA() {
        System.out.println("getA");
        Ponto expResult = PA.clone();
        Ponto result = instance.getA();
        assertEquals(expResult, result);
    }

    /**
     * Test of getB method, of class SegmentoDeReta.
     */
    @org.junit.jupiter.api.Test
    public void testGetB() {
        System.out.println("getB");
        Ponto expResult = PB.clone();
        Ponto result = instance.getB();
        assertEquals(expResult, result);
    }

    /**
     * Test of setA method, of class SegmentoDeReta.
     */
    @org.junit.jupiter.api.Test
    public void testSetA() {
        System.out.println("setA");
        Ponto A = new Ponto(10, 10);
        SegmentoDeReta instance = new SegmentoDeReta();
        instance.setA(A);
        assertEquals(instance.getA(),A);
    }

    /**
     * Test of setB method, of class SegmentoDeReta.
     */
    @org.junit.jupiter.api.Test
    public void testSetB() {
        System.out.println("setB");
        Ponto B = new Ponto(10, 10);;
        SegmentoDeReta instance = new SegmentoDeReta();
        instance.setB(B);
        assertEquals(instance.getB(),B);
    }

//    /**
//     * Test of incY method, of class SegmentoDeReta.
//     */
//    @org.junit.jupiter.api.Test
//    public void testIncY() {
//        System.out.println("incY");
//        int i = 0;
//        SegmentoDeReta instance = new SegmentoDeReta();
//        instance.incY(i);
//        assertEquals(instance.getA().getY()et);
//    }
//
//    /**
//     * Test of incX method, of class SegmentoDeReta.
//     */
//    @org.junit.jupiter.api.Test
//    public void testIncX() {
//        System.out.println("incX");
//        int i = 0;
//        SegmentoDeReta instance = new SegmentoDeReta();
//        instance.incX(i);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of length method, of class SegmentoDeReta.
//     */
//    @org.junit.jupiter.api.Test
//    public void testLength() {
//        System.out.println("length");
//        SegmentoDeReta instance = new SegmentoDeReta();
//        double expResult = 0.0;
//        double result = instance.length();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of angleX method, of class SegmentoDeReta.
//     */
//    @org.junit.jupiter.api.Test
//    public void testAngleX() {
//        System.out.println("angleX");
//        SegmentoDeReta instance = new SegmentoDeReta();
//        double expResult = 0.0;
//        double result = instance.angleX();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
