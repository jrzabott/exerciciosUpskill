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

/**
 *
 * @author Upskill
 */
public class RegistoCategoriasTest {
    private AreaAtividade at;
    private CompetenciaTecnica ct;
    private CaraterCompetenciaTecnica cct;
    private GrauProficiencia grau;
    private CategoriaTarefa cat, cat2, cat3;
    private RegistoCategorias regCat, regCat2, regCat3;
    private Object obj;
    
    public RegistoCategoriasTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(true, ct, grau);
        ArrayList<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
        listaCCT.add(cct);
        cat = new CategoriaTarefa("Upskill", at, listaCCT);
        cat2 = new CategoriaTarefa("Upskill2", at, listaCCT);
        cat3 = new CategoriaTarefa("Upskill", at, listaCCT);
        regCat = new RegistoCategorias();
        regCat.addCategoria(cat);
        regCat2 = new RegistoCategorias(regCat);
        regCat3 = new RegistoCategorias(regCat);
        regCat3.addCategoria(cat2);
        obj = new Object();
        
    }
    

    /**
     * Test of getCategorias method, of class RegistoCategorias.
     */
    @Test
    public void testGetCategorias() {
        System.out.println("getCategorias");
        regCat.addCategoria(cat2);
        ArrayList<CategoriaTarefa> listaCat = new ArrayList<>();
        listaCat.add(cat);
        listaCat.add(cat2);
        assertEquals(listaCat, regCat.getCategorias());
    }

    /**
     * Test of getCategoriaById method, of class RegistoCategorias.
     */
//    @Test
    public void testGetCategoriaByIdTrue() {
        System.out.println("getCategoriaByIdTrue");
        int catId = 0;
        assertEquals(cat, regCat.getCategoriaById(catId));
    }
    
    @Test
    public void testGetCategoriaByIdFalse() {
        System.out.println("getCategoriaByIdFalse");
        int catId = 1;
        assertEquals(null, regCat.getCategoriaById(catId));
    }

    /**
     * Test of addCategoria method, of class RegistoCategorias.
     */
    @Test
    public void testAddCategoriaTrue() {
        System.out.println("addCategoriaTrue");
        assertTrue(regCat.addCategoria(cat2));
    }
    
//    @Test
    public void testAddTarefaCodigoDuplicado() {
        System.out.println("addCategoriaCodigoDuplicado");
        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> {regCat.addCategoria(cat3);});
        assertEquals("Já existe uma categoria com este ID!", exception.getMessage());
    }

    /**
     * Test of equals method, of class RegistoCategorias.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(regCat, regCat);
        assertEquals(regCat3, regCat3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(regCat, regCat2);
        assertEquals(regCat2, regCat);
        // Testes de insucesso
        assertNotEquals(regCat, regCat3);
        assertNotEquals(regCat3, regCat);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(regCat, null);
        assertNotEquals(regCat3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(regCat, obj);
        assertNotEquals(regCat2, obj);
        assertNotEquals(regCat3, obj);
    }
    
}
