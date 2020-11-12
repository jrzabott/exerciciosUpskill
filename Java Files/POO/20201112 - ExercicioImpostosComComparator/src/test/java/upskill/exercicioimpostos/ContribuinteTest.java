/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioimpostos;

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
public class ContribuinteTest {
    
    public ContribuinteTest() {
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
     * Test of calcularImposto method, of class Contribuinte.
     */
    @Test
    public void testCalcularImpostoReformado() {
        System.out.println("calcularImposto");
        Contribuinte instance = new Reformado("Valter Coelho", "Olival", 600, 400);
        double expResult = 18.0;
        double result = instance.calcularImposto();
        assertEquals(expResult, result, 0.001);
    }
    /**
     * Test of calcularImposto method, of class Contribuinte.
     */
    @Test
    public void testCalcularImpostoDesempregado() {
        System.out.println("calcularImposto");
        Contribuinte instance = new Desempregado("Luís Vidal", "Lisboa", 230, 1);
        double expResult = 4.6;
        double result = instance.calcularImposto();
        assertEquals(expResult, result, 0.001);
    }
    /**
     * Test of calcularImposto method, of class Contribuinte.
     */
    @Test
    public void testCalcularImpostoTrabContaOutrem() {
        System.out.println("calcularImposto");
        Contribuinte instance = new TrabalhadorContaOutrem("Ana", "Ovar", 1800, 300, "CMM");
        double expResult = 24.0;
        double result = instance.calcularImposto();
        assertEquals(expResult, result, 0.001);
    }
    /**
     * Test of calcularImposto method, of class Contribuinte.
     */
    @Test
    public void testCalcularImpostoTrabContaPropria() {
        System.out.println("calcularImposto");
        Contribuinte instance = new TrabalhadorContaPropria("Mário", "Guarda", 1500, 300, "Eletricista");
        double expResult = 6.0;
        double result = instance.calcularImposto();
        assertEquals(expResult, result, 0.001);
    }
   
    
}
