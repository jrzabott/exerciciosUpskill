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
public class TrabalhadorVencimentoComparatorTest {

    public TrabalhadorVencimentoComparatorTest() {
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
     * Test of compare method, of class TrabalhadorVencimentoComparator.
     */
    @Test
    public void testCompareEqual() {
        System.out.println("\n\nCompare Equal Earnings");
        Trabalhador o1 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        Trabalhador o2 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        TrabalhadorVencimentoComparator instance = new TrabalhadorVencimentoComparator();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        System.out.printf("%.2f | %.2f | %d%n", o1.calcularVencimento(), o2.calcularVencimento(), result);
        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class TrabalhadorVencimentoComparator.
     */
    @Test
    public void testCompareLesser() {
        System.out.println("\n\ncompare Lesser Earnings");
        Trabalhador o1 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        Trabalhador o2 = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        TrabalhadorVencimentoComparator instance = new TrabalhadorVencimentoComparator();
        int expResult = 1;
        int result = instance.compare(o1, o2);
        System.out.printf("%.2f | %.2f | %d%n", o1.calcularVencimento(), o2.calcularVencimento(), result);

        assertEquals(expResult, result);
    }

    /**
     * Test of compare method, of class TrabalhadorVencimentoComparator.
     */
    @Test
    public void testCompareGreater() {
        System.out.println("\n\ncompare Greater Earnings");
        Trabalhador o1 = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        Trabalhador o2 = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorVencimentoComparator instance = new TrabalhadorVencimentoComparator();
        System.out.printf("%.2f | %.2f%n", o1.calcularVencimento(), o2.calcularVencimento());
        int expResult = -1;
        int result = instance.compare(o1, o2);
        System.out.printf("%.2f | %.2f | %d%n", o1.calcularVencimento(), o2.calcularVencimento(), result);

        assertEquals(expResult, result);
    }

}
