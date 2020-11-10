/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.tributaveis;

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
public class MoradiaTest {
    
    public MoradiaTest() {
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
    public void testCalcularImposto() {
        System.out.println("calcularImposto");
        Moradia instance = new Moradia("Rua das Flores, 123", 90, Moradia.CINZENTO);
        double expResult = 180.0;
        double result = instance.calcularImposto();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    
}
