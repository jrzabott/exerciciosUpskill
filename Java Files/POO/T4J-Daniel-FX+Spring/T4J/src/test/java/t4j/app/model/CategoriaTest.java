/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.model;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoDuplicadoException;
import t4j.app.exception.ElementoInvalidoException;

/**
 *
 * @author Upskill
 */
public class CategoriaTest {
    private AreaAtividade at;
    private CompetenciaTecnica ct;
    private CaraterCompetenciaTecnica cct, cct2, cct3;
    private GrauProficiencia grau, grau2;
    private ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
    private ArrayList<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
    private CategoriaTarefa catT, cat, cat2, cat3;
    private Object obj;
    
    public CategoriaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        grau2 = new GrauProficiencia("2", "Designação");
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(true, ct, grau);
        cct2 = new CaraterCompetenciaTecnica(true, ct, grau2);
        cct3 = new CaraterCompetenciaTecnica(false, ct, grau);
        listaCCT.add(cct);
        cat = new CategoriaTarefa("Upskill", at, listaCCT);
        cat2 = new CategoriaTarefa(cat);
        cat3 = new CategoriaTarefa("Upskill2", at, listaCCT);
        obj = new Object();
        catT = new CategoriaTarefa();
    }
    
    /**
     * Test of setDescricao method, of class CategoriaTarefa.
     */
    @Test
    public void testSetDescricao() {
        //Testes de sucesso
        String descricao1 = "Descrição";
        catT.setDescricaoCategoria(descricao1);
        assertEquals(descricao1, catT.getDescricaoCategoria());
        //Testes de insucesso
//        System.out.println("setDescricao Vazia");
        String descricao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {catT.setDescricaoCategoria(descricao2);});
        assertEquals("Descrição inválida.", exception2.getMessage());
    }
    
    
    /**
     * Test of addCaraterCT method, of class CategoriaTarefa.
     */
    @Test
    public void testAddCaraterCTTrue() {
        System.out.println("addCaraterCTTrue");
        assertTrue(cat.addCaraterCompetenciaTecnica(cct2));
    }
    
    @Test
    public void testAddCaraterCTFalse() {
        System.out.println("addCaraterCT");
        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> cat.addCaraterCompetenciaTecnica(cct3));
        String expectedResult = "Já existe um CCT com essa competência e grau!";
        assertEquals(exception.getMessage(), expectedResult);
    }

    /**
     * Test of equals method, of class CategoriaTarefa.
     */
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(cat, cat);
        assertEquals(cat3, cat3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(cat, cat2);
        assertEquals(cat2, cat);
        // Testes de insucesso
        assertNotEquals(cat, cat3);
        assertNotEquals(cat3, cat);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(cat, null);
        assertNotEquals(cat3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(at, obj);
        assertNotEquals(cat2, obj);
        assertNotEquals(cat3, obj);
    }
    
}
