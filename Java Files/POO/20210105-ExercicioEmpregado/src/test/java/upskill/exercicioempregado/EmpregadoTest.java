/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.exercicioempregado;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import upskill.utilitarios.Data;
import upskill.utilitarios.Tempo;

/**
 *
 * @author user
 */
public class EmpregadoTest {
    
    Empregado instance = new Empregado("FirstName", "LastName");
    
    public EmpregadoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testGetPrimeiroNome() {
        System.out.println("getPrimeiroNome");
        String expResult = "FirstName";
        String result = instance.getPrimeiroNome();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUltimoNome() {
        System.out.println("getUltimoNome");
        String expResult = "LastName";
        String result = instance.getUltimoNome();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDataContrato() {
        System.out.println("getDataContrato");
        Data expResult = new Data();
        Data result = instance.getDataContrato();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHoraEntrada() {
        System.out.println("getHoraEntrada");
        Tempo expResult = new Tempo();
        Tempo result = instance.getHoraEntrada();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHoraSaida() {
        System.out.println("getHoraSaida");
        Tempo expResult = new Tempo();
        Tempo result = instance.getHoraSaida();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPrimeiroNome() {
        System.out.println("setPrimeiroNome");
        String primeiroNome = "xxx";
        Empregado instance = new Empregado("", "");
        instance.setPrimeiroNome(primeiroNome);
        assertEquals(instance.getPrimeiroNome(), primeiroNome);
    }

    @Test
    public void testSetUltimoNome() {
        System.out.println("setUltimoNome");
        String ultimoNome = "yyy";
        Empregado instance = new Empregado("", "");
        instance.setUltimoNome(ultimoNome);
        assertEquals(instance.getUltimoNome(), ultimoNome);
    }

    @Test
    public void testCalculateHorasTrabalhoSemanal() {
        System.out.println("calculateHorasTrabalhoSemanal");
        Tempo t1 = new Tempo(8);
        Tempo t2 = new Tempo(17);
        Data d = new Data();
        Empregado instance = new Empregado("xxx", "yyy", d, t1, t2);
        double expResult = 9.0 * 5.0;
        double result = instance.calculateHorasTrabalhoSemanal();
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testCalculateTempoContrato() {
        System.out.println("calculateTempoContrato");
        Empregado instance = new Empregado();
        Data d = new Data(1, 1, 2);
        int expResult = 737794;
        int result = instance.calculateTempoContrato();
        assertEquals(expResult, result);
    }
    
}
