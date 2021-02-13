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
public class RegistoCompetenciasTecnicasTest {
    private RegistoCompetenciasTecnicas regCT, regCT2, regCT3;
    private AreaAtividade at;
    private CompetenciaTecnica ct, ct2, ct3;
    private GrauProficiencia grau;
    private Object obj;
    
    public RegistoCompetenciasTecnicasTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ct2 = new CompetenciaTecnica("CodigoCT2", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        ct3 = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        regCT = new RegistoCompetenciasTecnicas();
        regCT.addCompetenciaTecnica(ct);
        regCT2 = new RegistoCompetenciasTecnicas(regCT);
        regCT3 = new RegistoCompetenciasTecnicas(regCT);
        regCT3.addCompetenciaTecnica(ct2);
        obj = new Object();
    }


    /**
     * Test of getComptecnicas method, of class RegistoCT.
     */
    @Test
    public void testGetComptecnicas() {
        System.out.println("getComptecnicas");
        regCT.addCompetenciaTecnica(ct2);
        ArrayList<CompetenciaTecnica> listaCT = new ArrayList<>();
        listaCT.add(ct);
        listaCT.add(ct2);
        assertEquals(listaCT, regCT.getCompetenciasTecnicas());
    }

    /**
     * Test of getCompTecnica method, of class RegistoCT.
     */
    @Test
    public void testGetCompTecnica() {
        System.out.println("getCompTecnica");
        String codCT = "CodigoCT";
        assertEquals(ct, regCT.getCompetenciaTecnicaByCodigoCompetenciaTecnica(codCT));
    }

    /**
     * Test of addCompTecnica method, of class RegistoCT.
     */
    @Test
    public void testAddCompTecnicaTrue() {
        System.out.println("addCompTecnicaTrue");
        assertTrue(regCT.addCompetenciaTecnica(ct2));
    }
    
    @Test
    public void testAddCompTecnicaCodigoDuplicado() {
        System.out.println("addCompTecnicaCodigoDuplicado");
        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> {regCT.addCompetenciaTecnica(ct3);});
        assertEquals("Já existe uma competência técnica com esse código!", exception.getMessage());
    }

    /**
     * Test of equals method, of class RegistoCT.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(regCT, regCT);
        assertEquals(regCT3, regCT3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(regCT, regCT2);
        assertEquals(regCT2, regCT);
        // Testes de insucesso
        assertNotEquals(regCT, regCT3);
        assertNotEquals(regCT3, regCT);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(regCT, null);
        assertNotEquals(regCT3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(regCT, obj);
        assertNotEquals(regCT2, obj);
        assertNotEquals(regCT3, obj);
    }
    
}
