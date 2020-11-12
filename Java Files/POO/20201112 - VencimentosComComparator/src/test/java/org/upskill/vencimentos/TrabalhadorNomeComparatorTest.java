/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.upskill.vencimentos;

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
public class TrabalhadorNomeComparatorTest {

    public TrabalhadorNomeComparatorTest() {
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

    /**
     * Test of compare method, of class TrabalhadorNomeComparator.
     */
    @Test
    public void testCompareEqual() {
        Trabalhador o1 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        Trabalhador o2 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        TrabalhadorNomeComparator instance = new TrabalhadorNomeComparator();
        int result = instance.compare(o1, o2);
        System.out.println("Compare Equal: " + result);
        boolean expResult = true;
        assertEquals(expResult, result == 0);
    }

    /**
     * Test of compare method, of class TrabalhadorNomeComparator.
     */
    @Test
    public void testCompareLesser() {
        Trabalhador o1 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);;
        Trabalhador o2 = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        TrabalhadorNomeComparator instance = new TrabalhadorNomeComparator();
        int result = instance.compare(o1, o2);
        System.out.println("Compare Lesser: " + result);
        boolean expResult = true;
        assertEquals(expResult, result > 0);
    }

    /**
     * Test of compare method, of class TrabalhadorNomeComparator.
     */
    @Test
    public void testCompareGreater() {
        Trabalhador o1 = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        Trabalhador o2 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);;
        TrabalhadorNomeComparator instance = new TrabalhadorNomeComparator();
        int result = instance.compare(o1, o2);
        System.out.println("Compare Greater: " + result);
        boolean expResult = true;
        assertEquals(expResult, result < 0);
    }

}
