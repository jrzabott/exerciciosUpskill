/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class GrauProficienciaTest {
    private GrauProficiencia grauT, grau, grau2, grau3;
    private Object obj;
    public GrauProficienciaTest() {
        grauT = new GrauProficiencia();
        grau = new GrauProficiencia("1", "Designação");
        grau2 = new GrauProficiencia(grau);
        grau3 = new GrauProficiencia("2", "Designação");
        obj = new Object();
    }

    /**
     * Test of getValor method, of class GrauProficiencia.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        String valor = "1";
        grauT.setValorGrauProficiencia(valor);
        assertEquals(valor, grauT.getValorGrauProficiencia());
    }

    /**
     * Test of setValor method, of class GrauProficiencia.
     */
    @Test
    public void testSetValor() {
        //Testes de sucesso
        String valor1 = "1";
        grauT.setValorGrauProficiencia(valor1);
        assertEquals(valor1, grauT.getValorGrauProficiencia());
        //Testes de insucesso
//        System.out.println("setValor Non-Digit");
        String valor2 = "1a";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {grauT.setValorGrauProficiencia(valor2);});
        assertEquals("Valor inválido.", exception2.getMessage());
//        System.out.println("setValor Vazio");
        String valor3 = "  ";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {grauT.setValorGrauProficiencia(valor3);});
        assertEquals("Valor inválido.", exception3.getMessage());
//        System.out.println("setValor maxLength");
        String valor4 = "123";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {grauT.setValorGrauProficiencia(valor4);});
        assertEquals("Valor inválido.", exception4.getMessage());
    }

    /**
     * Test of getDesignacao method, of class GrauProficiencia.
     */
//    @Test
    public void testGetDesignacao() {
        System.out.println("getDesignacao");
        String designacao = "Designacao";
        grauT.setDesignacaoGrauProficiencia(designacao);
        assertEquals(designacao, grauT.getDesignacaoGrauProficiencia());
    }

    /**
     * Test of setDesignacao method, of class GrauProficiencia.
     */
    @Test
    public void testSetDesignacao() {
        //Testes de sucesso
        String designacao1 = "Designação";
        grauT.setDesignacaoGrauProficiencia(designacao1);
        assertEquals(designacao1, grauT.getDesignacaoGrauProficiencia());
        //Testes de insucesso
//        System.out.println("setDesignacao Vazia");
        String designacao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {grauT.setDesignacaoGrauProficiencia(designacao2);});
        assertEquals("Designação inválida.", exception2.getMessage());
//        System.out.println("setDesignacao maxLength");
        String designacao3 = String.format("|%260d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {grauT.setDesignacaoGrauProficiencia(designacao3);});
        assertEquals("Designação inválida.", exception3.getMessage());
    }

    /**
     * Test of equals method, of class GrauProficiencia.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(grau, grau);
        assertEquals(grau3, grau3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(grau, grau2);
        assertEquals(grau2, grau);
        // Testes de insucesso
        assertNotEquals(grau, grau3);
        assertNotEquals(grau3, grau);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(grau, null);
        assertNotEquals(grau3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(grau, obj);
        assertNotEquals(grau2, obj);
        assertNotEquals(grau3, obj);
    }
    
    
    
}
