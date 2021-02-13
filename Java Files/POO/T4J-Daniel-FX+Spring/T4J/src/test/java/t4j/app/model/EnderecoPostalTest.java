/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class EnderecoPostalTest {
    private EnderecoPostal endT, end, end2, end3;
    private Object obj;
    
    public EnderecoPostalTest() {
        end = new EnderecoPostal("Rua org", "4000-001", "Porto");
        end2 = new EnderecoPostal(end);
        end3 = new EnderecoPostal("Rua org2", "4000-001", "Porto");
        endT = new EnderecoPostal();
        obj = new Object();
    }
    
    /**
     * Test of setMorada method, of class EnderecoPostal.
     */
    @Test
    public void testSetMorada() {
        //Testes de sucesso
        String morada1 = "Morada nº1 - 3ºE";
        endT.setMorada(morada1);
        assertEquals(morada1, endT.getMorada());
        //Testes de insucesso
//        System.out.println("setMorada Vazia");
        String morada2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {endT.setMorada(morada2);});
        assertEquals("Morada inválida.", exception2.getMessage());
//        System.out.println("setMorada maxLength");
        String morada3 = String.format("|%260d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {endT.setMorada(morada3);});
        assertEquals("Morada inválida.", exception3.getMessage());
    }
    /**
     * Test of setMorada method, of class EnderecoPostal.
     */
    @Test
    public void testSetCodPostal() {
        //Testes de sucesso
        String codPostal1 = "4300-000";
        endT.setCodigoPostal(codPostal1);
        assertEquals(codPostal1, endT.getCodigoPostal());
        //Testes de insucesso
//        System.out.println("setCodPostal Vazio");
        String codPostal2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {endT.setCodigoPostal(codPostal2);});
        assertEquals("Código postal inválido.", exception2.getMessage());
//        System.out.println("setCodPostal maxLength");
        String codPostal3 = String.format("|%9d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {endT.setCodigoPostal(codPostal3);});
        assertEquals("Código postal inválido.", exception3.getMessage());
//        System.out.println("setCodPostal Inválido");
        String codPostal4 = "0000-100";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {endT.setCodigoPostal(codPostal4);});
        assertEquals("Código postal inválido.", exception4.getMessage());        
    }
    
    /**
     * Test of setLocalidade method, of class EnderecoPostal.
     */
    @Test
    public void testSetLocalidade() {
        //Testes de sucesso
        String local1 = "Águas Santas";
        endT.setLocalidade(local1);
        assertEquals(local1, endT.getLocalidade());
        //Testes de insucesso
//        System.out.println("setLocalidade Vazia");
        String local2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local2);});
        assertEquals("Localidade inválida.", exception2.getMessage());
//        System.out.println("setLocalidade maxLength");
        String local3 = String.format("|%52d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local3);});
        assertEquals("Localidade inválida.", exception3.getMessage());
//        System.out.println("setLocalidade Carateres Inválidos");
        String local4 = "Porto2";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {endT.setLocalidade(local4);});
        assertEquals("Localidade inválida.", exception4.getMessage());        
    }
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(end, end);
        assertEquals(end3, end3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(end, end2);
        assertEquals(end2, end);
        // Testes de insucesso
        assertNotEquals(end, end3);
        assertNotEquals(end3, end);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(end, null);
        assertNotEquals(end3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(end, obj);
        assertNotEquals(end2, obj);
        assertNotEquals(end3, obj);
    }
}
