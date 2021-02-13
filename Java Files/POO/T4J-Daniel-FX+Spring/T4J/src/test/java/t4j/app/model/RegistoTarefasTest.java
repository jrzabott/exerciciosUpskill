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

public class RegistoTarefasTest {

    private RegistoTarefas tarefas, tarefas2, tarefas3;
    private Tarefa tarefa, tarefa2, tarefa3;
    private CategoriaTarefa cat;
    private AreaAtividade at;
    private CompetenciaTecnica ct;
    private CaraterCompetenciaTecnica cct;
    private GrauProficiencia grau;
    private Object obj;

    public RegistoTarefasTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(true, ct, grau);
        ArrayList<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
        listaCCT.add(cct);
        cat = new CategoriaTarefa("Upskill", at, listaCCT);
        tarefa = new Tarefa("UPskill", "Designação", "Descrição Informal", "Descrição Técnica", "760", "5000", cat);
        tarefa2 = new Tarefa("UPskill2", "Designação", "Descrição Informal", "Descrição Técnica", "760", "5000", cat);
        tarefa3 = new Tarefa("UPskill", "Designação", "Descrição Informal", "Descrição Técnica", "760", "5000", cat);

        tarefas = new RegistoTarefas();
        tarefas.addTarefa(tarefa);
        tarefas2 = new RegistoTarefas(tarefas);
        tarefas3 = new RegistoTarefas(tarefas);
        tarefas3.addTarefa(tarefa2);
        obj = new Object();
        
        
    }

    /**
     * Test of getTarefas method, of class RegistoTarefas.
     */
    @Test
    public void testGetTarefas() {
        System.out.println("getTarefas");
        tarefas.addTarefa(tarefa2);
        ArrayList<Tarefa> listaTarefas = new ArrayList<>();
        listaTarefas.add(tarefa);
        listaTarefas.add(tarefa2);
        assertEquals(listaTarefas, tarefas.getTarefas());
    }

    /**
     * Test of getTarefaByReferencia method, of class RegistoTarefas.
     */
    @Test
    public void testGetTarefaTrue() {
        System.out.println("getTarefaTrue");
        String ref = "UPskill";
        assertEquals(tarefa, tarefas.getTarefaByReferencia(ref));
    }

    @Test
    public void testGetTarefaFalse() {
        System.out.println("getTarefaFalse");
        String ref = "UPskill2";
        assertEquals(null, tarefas.getTarefaByReferencia(ref));
    }

    /**
     * Test of addTarefa method, of class RegistoTarefas.
     */
    @Test
    public void testAddTarefaTrue() {
        System.out.println("addTarefaTrue");
        assertTrue(tarefas.addTarefa(tarefa2));
    }
    
    @Test
    public void testAddTarefaCodigoDuplicado() {
        System.out.println("addTarefaCodigoDuplicado");
        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> {tarefas.addTarefa(tarefa3);});
        assertEquals("Já existe uma tarefa com essa referência!", exception.getMessage());
    }
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(tarefas, tarefas);
        assertEquals(tarefas3, tarefas3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(tarefas, tarefas2);
        assertEquals(tarefas2, tarefas);
        // Testes de insucesso
        assertNotEquals(tarefas, tarefas3);
        assertNotEquals(tarefas3, tarefas);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(tarefas, null);
        assertNotEquals(tarefas3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(tarefas, obj);
        assertNotEquals(tarefas2, obj);
        assertNotEquals(tarefas3, obj);
    }
}
