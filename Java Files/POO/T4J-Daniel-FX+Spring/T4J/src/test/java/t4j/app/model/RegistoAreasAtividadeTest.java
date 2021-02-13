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
public class RegistoAreasAtividadeTest {
    private RegistoAreasAtividade regAT, regAT2, regAT3;
    private AreaAtividade at, at2, at3;
    private Object obj;
    
    public RegistoAreasAtividadeTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        at2 = new AreaAtividade("ITTEC2", "Tecnologia, Educação e Cidadania",
                "Atividades relacionadas à Educação, Tecnologia, Inteligência, Meio Ambiente, Saúde, Trabalho e Cidadania");
        at3 = new AreaAtividade("ITTEC", "Tecnologia da Informação ", "Atividades relacionadas à informações e tecnologias ");
        regAT = new RegistoAreasAtividade();
        regAT.addAreaAtividade(at);
        regAT2 = new RegistoAreasAtividade(regAT);
        regAT3 = new RegistoAreasAtividade(regAT);
        regAT3.addAreaAtividade(at2);
        obj = new Object();
    }


    /**
     * Test of getAreasAtividade method, of class RegistoAreasAtividade.
     */
    @Test
    public void testGetAreasAtividade() {
        System.out.println("getAreasAtividade");
        regAT.addAreaAtividade(at2);
        ArrayList<AreaAtividade> listaAT = new ArrayList<>();
        listaAT.add(at);
        listaAT.add(at2);
        assertEquals(listaAT, regAT.getAreasAtividade());
    }

    /**
     * Test of getAreaAtividade method, of class RegistoAreasAtividade.
     */
    @Test
    public void testGetAreaAtividadeTrue() {
        System.out.println("getAreaAtividadeFalse");
        String cod = "ITTEC";
        assertEquals(at, regAT.getAreaAtividadeByCodigoAreaAtividade(cod));
    }
    
    @Test
    public void testGetAreaAtividadeFalse() {
        System.out.println("getAreaAtividadeFalse");
        String cod = "ITTEC2";
        assertEquals(null, regAT.getAreaAtividadeByCodigoAreaAtividade(cod));
    }

    /**
     * Test of addAreaAtividade method, of class RegistoAreasAtividade.
     */
    @Test
    public void testAddAreaAtividadeTrue() {
        System.out.println("addAreaAtividadeTrue");
        assertTrue(regAT.addAreaAtividade(at2));
    }
    
    @Test
    public void testAddAreaAtividadeCodigoDuplicado() {
        System.out.println("addAreaAtividadeCodigoDuplicado");
        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> {regAT.addAreaAtividade(at3);});
        assertEquals("Já existe uma área de atividade com esse código!", exception.getMessage());
    }
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(regAT, regAT);
        assertEquals(regAT3, regAT3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(regAT, regAT2);
        assertEquals(regAT2, regAT);
        // Testes de insucesso
        assertNotEquals(regAT, regAT3);
        assertNotEquals(regAT3, regAT);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(regAT, null);
        assertNotEquals(regAT3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(regAT, obj);
        assertNotEquals(regAT2, obj);
        assertNotEquals(regAT3, obj);
    }

}
