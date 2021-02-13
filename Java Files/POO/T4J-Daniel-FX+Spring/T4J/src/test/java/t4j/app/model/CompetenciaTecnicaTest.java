/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class CompetenciaTecnicaTest {
    private AreaAtividade at;
    private GrauProficiencia grau, grau2, grau3;
    private ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
    private CompetenciaTecnica ctT, ct, ct2, ct3;
    private Object obj;
    
    public CompetenciaTecnicaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        grau2 = new GrauProficiencia("2", "Designação");
        grau3 = new GrauProficiencia("1", "Designação2");
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ct2 = new CompetenciaTecnica(ct);
        ct3 = new CompetenciaTecnica("CodigoCT2", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ctT = new CompetenciaTecnica();
        obj = new Object();
    }   

    /**
     * Test of setCodCT method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetCodCT() {
        //Testes de sucesso
        String codCT1 = "CodCT1";
        ctT.setCodigoCompetenciaTecnica(codCT1);
        assertEquals(codCT1, ctT.getCodigoCompetenciaTecnica());
        //Testes de insucesso
//        System.out.println("setCodCT Vazio");
        String codCT2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {ctT.setCodigoCompetenciaTecnica(codCT2);});
        assertEquals("Código inválido.", exception2.getMessage());
//        System.out.println("setCodCT maxLength");
        String codCT3 = String.format("|%22d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {ctT.setCodigoCompetenciaTecnica(codCT3);});
        assertEquals("Código inválido.", exception3.getMessage());
//        System.out.println("setCodCT c/Carateres especiais");
        String codCT4 = "Ref1$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {ctT.setCodigoCompetenciaTecnica(codCT4);});
        assertEquals("Código inválido.", exception4.getMessage());        
    }
    
    /**
     * Test of setDescBreve method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetDescBreve() {
        //Testes de sucesso
        String descBreve1 = "Descrição Breve";
        ctT.setDescricaoBreve(descBreve1);
        assertEquals(descBreve1, ctT.getDescricaoBreve());
        //Testes de insucesso
//        System.out.println("setDescBreve Vazia");
        String descBreve2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {ctT.setDescricaoBreve(descBreve2);});
        assertEquals("Descrição breve inválida.", exception2.getMessage());
//        System.out.println("setDescBreve maxLength");
        String descBreve3 = String.format("|%62d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {ctT.setDescricaoBreve(descBreve3);});
        assertEquals("Descrição breve inválida.", exception3.getMessage());
    }

    /**
     * Test of setDescDetalhada method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetDescDetalhada() {
        //Testes de sucesso
        String descDetalhada1 = "Descrição Detalhada";
        ctT.setDescricaoDetalhada(descDetalhada1);
        assertEquals(descDetalhada1, ctT.getDescricaoDetalhada());
        //Testes de insucesso
//        System.out.println("setDescDetalhada Vazia");
        String descDetalhada2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {ctT.setDescricaoDetalhada(descDetalhada2);});
        assertEquals("Descrição detalhada inválida.", exception2.getMessage());
    }
    
    /**
     * Test of getGraus method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetGraus() {
        System.out.println("getGraus");
        ct.addGrauProficiencia(grau2);
        listaGraus.add(grau2);
        assertEquals(listaGraus, ct.getGrausProficiencia());
    }

    /**
     * Test of addGrauProficiencia method, of class CompetenciaTecnica.
     */
    @Test
    public void testAddGrauProficienciaTrue() {
        System.out.println("addGrauProficiencia");
        assertTrue(ct.addGrauProficiencia(grau2));
    }
    
    @Test
    public void testAddGrauProficienciaFalse() {
        System.out.println("addGrauProficienciaFalse");
        assertFalse(ct.addGrauProficiencia(grau3));
    }

    /**
     * Test of getGrau method, of class CompetenciaTecnica.
     */
//    @Test
    public void testGetGrau() {
        System.out.println("getGrau");
//        assertEquals(expResult, result);

    }
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(ct, ct);
        assertEquals(ct3, ct3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(ct, ct2);
        assertEquals(ct2, ct);
        // Testes de insucesso
        assertNotEquals(ct, ct3);
        assertNotEquals(ct3, ct);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(ct, null);
        assertNotEquals(ct3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(ct, obj);
        assertNotEquals(ct2, obj);
        assertNotEquals(ct3, obj);
    }
    
}
