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
public class AreaAtividadeTest {
    private AreaAtividade atT, at, at2, at3, at4;
    private Object obj;
    public AreaAtividadeTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        at2 = new AreaAtividade(at);
        at3 = new AreaAtividade("ITTEC2", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        obj = new Object();
        atT = new AreaAtividade();
    }
    
    /**
     * Test of setCod method, of class AreaAtividade.
     */
    @Test
    public void testSetCod() {
        //Testes de sucesso
        String at1 = "AT1";
        atT.setCodigoAreaAtividade(at1);
        assertEquals(at1, atT.getCodigoAreaAtividade());
        //Testes de insucesso
//        System.out.println("setCodigo Vazio");
        String at2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {atT.setCodigoAreaAtividade(at2);});
        assertEquals("Código inválido.", exception2.getMessage());
//        System.out.println("setCodigo maxLength");
        String at3 = String.format("|%22d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {atT.setCodigoAreaAtividade(at3);});
        assertEquals("Código inválido.", exception3.getMessage());
//        System.out.println("setCodigo c/Carateres especiais");
        String at4 = "Codigo4$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {atT.setCodigoAreaAtividade(at4);});
        assertEquals("Código inválido.", exception4.getMessage());        
    }
    
    /**
     * Test of setDescBreve method, of class AreaAtividade.
     */
    @Test
    public void testSetDescBreve() {
        //Testes de sucesso
        String descBreve1 = "Descrição Breve";
        atT.setDescricaoBreve(descBreve1);
        assertEquals(descBreve1, atT.getDescricaoBreve());
        //Testes de insucesso
//        System.out.println("setDescBreve Vazia");
        String descBreve2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {atT.setDescricaoBreve(descBreve2);});
        assertEquals("Descrição breve inválida.", exception2.getMessage());
//        System.out.println("setDescBreve maxLength");
        String descBreve3 = String.format("|%260d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {atT.setDescricaoBreve(descBreve3);});
        assertEquals("Descrição breve inválida.", exception3.getMessage());
    }
    
    /**
     * Test of setDescDetalhada method, of class AreaAtividade.
     */
    @Test
    public void testSetDescDetalhada() {
        //Testes de sucesso
        String descDetalhada1 = "Descrição Detalhada";
        atT.setDescricaoDetalhada(descDetalhada1);
        assertEquals(descDetalhada1, atT.getDescricaoDetalhada());
        //Testes de insucesso
//        System.out.println("setDescDetalhada Vazia");
        String descDetalhada2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {atT.setDescricaoDetalhada(descDetalhada2);});
        assertEquals("Descrição detalhada inválida.", exception2.getMessage());
    }
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(at, at);
        assertEquals(at3, at3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(at, at2);
        assertEquals(at2, at);
        // Testes de insucesso
        assertNotEquals(at, at3);
        assertNotEquals(at3, at);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(at, null);
        assertNotEquals(at3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(at, obj);
        assertNotEquals(at2, obj);
        assertNotEquals(at3, obj);
    }

}
