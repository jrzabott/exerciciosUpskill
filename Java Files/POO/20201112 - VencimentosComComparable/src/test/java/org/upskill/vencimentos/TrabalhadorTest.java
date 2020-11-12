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
public class TrabalhadorTest {

    public TrabalhadorTest() {
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
     * Test of calcularVencimento method, of class Trabalhador.
     */
    @Test
    public void testCalcularVencimentoComissao() {
        System.out.println("calcularVencimento");
        Trabalhador instance = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        float expResult = 590.0F;
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularVencimento method, of class Trabalhador.
     */
    @Test
    public void testCalcularVencimentoHora() {
        System.out.println("calcularVencimento");
        Trabalhador instance = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        float expResult = 560.0F;
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularVencimento method, of class Trabalhador.
     */
    @Test
    public void testCalcularVencimentoPeca() {
        System.out.println("calcularVencimento");
        Trabalhador instance = new TrabalhadorPeca("Jorge Silva", 20, 30);
        float expResult = 910.0F;
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToAnEqual() {
        System.out.println("compareTo");
        Trabalhador o = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);;
        Trabalhador instance = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToAGreater() {
        System.out.println("compareTo");
        Trabalhador o = new TrabalhadorPeca("Jorge Silva", 20, 30);
        Trabalhador instance = new TrabalhadorComissao("Susana Ferreira", 
                                                          500.0f, 1500.0f, 6f); ;
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Trabalhador.
     */
    @Test
    public void testCompareToAnLesser() {
        System.out.println("compareTo");
        Trabalhador o = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        Trabalhador instance = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

}
