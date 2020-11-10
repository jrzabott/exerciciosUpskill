/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioescola;

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
public class ProfessorTest {
    
    public ProfessorTest() {
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
     * Test of calcularPagamento method, of class Professor.
     */
    @Test
    public void testCalcularPagamentoAdjunto() {
        System.out.println("calcularPagamento");
        Professor instance = new Professor("Jorge", 123123, "adjunto");
        double expResult = 1800.0;
        double result = instance.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }
    /**
     * Test of calcularPagamento method, of class Professor.
     */
    @Test
    public void testCalcularPagamentoCoordenador() {
        System.out.println("calcularPagamento");
        Professor instance = new Professor("Paulo", 321321, "coordenador");
        double expResult = 2250.0;
        double result = instance.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }
    /**
     * Test of calcularPagamento method, of class Professor.
     */
    @Test
    public void testCalcularPagamentoAssistente() {
        System.out.println("calcularPagamento");
        Professor instance = new Professor("Daniel Junior", 666666, "assistente");
        double expResult = 1500.0;
        double result = instance.calcularPagamento();
        assertEquals(expResult, result, 0.0);
    }

}
