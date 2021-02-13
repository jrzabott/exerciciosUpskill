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
public class TarefaTest {
    private AreaAtividade at;
    private CategoriaTarefa cat;
    private CompetenciaTecnica ct;
    private CaraterCompetenciaTecnica cct;
    private GrauProficiencia grau;
    private Tarefa tarefaT;
    
    public TarefaTest() {
        at = new AreaAtividade("ITTEC", "Tecnologia da Informação", "Atividades relacionadas à informações e tecnologias");
        grau = new GrauProficiencia("1", "Designação");
        ArrayList<GrauProficiencia> listaGraus = new ArrayList<>();
        listaGraus.add(grau);
        ct = new CompetenciaTecnica("CodigoCT", "Descrição Breve", "Descrição Detalhada", at, listaGraus);
        cct = new CaraterCompetenciaTecnica(true, ct, grau);
        ArrayList<CaraterCompetenciaTecnica> listaCCT = new ArrayList<>();
        listaCCT.add(cct);
        cat = new CategoriaTarefa("Upskill", at, listaCCT);
        tarefaT = new Tarefa();
    }

    /**
     * Test of setRef method, of class Tarefa.
     */
    @Test
    public void testSetRef() {
        //Testes de sucesso
        String ref1 = "Ref1";
        tarefaT.setReferencia(ref1);
        assertEquals(ref1, tarefaT.getReferencia());
        //Testes de insucesso
//        System.out.println("setRef Vazia");
        String ref2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setReferencia(ref2);});
        assertEquals("Referência inválida.", exception2.getMessage());
//        System.out.println("setRef maxLength");
        String ref3 = String.format("|%22d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setReferencia(ref3);});
        assertEquals("Referência inválida.", exception3.getMessage());
//        System.out.println("setRef c/Carateres especiais");
        String ref4 = "Ref1$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setReferencia(ref4);});
        assertEquals("Referência inválida.", exception4.getMessage());        
    }
    
    /**
     * Test of setDesignacao method, of class Tarefa.
     */
    @Test
    public void testSetDesignacao() {
        //Testes de sucesso
        String designacao1 = "Designação";
        tarefaT.setDesignacao(designacao1);
        assertEquals(designacao1, tarefaT.getDesignacao());
        //Testes de insucesso
//        System.out.println("setDesignacao Vazia");
        String designacao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDesignacao(designacao2);});
        assertEquals("Designação inválida.", exception2.getMessage());
//        System.out.println("setDesignacao maxLength");
        String designacao3 = String.format("|%65d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDesignacao(designacao3);});
        assertEquals("Designação inválida.", exception3.getMessage());
    }

    /**
     * Test of setDescInformal method, of class Tarefa.
     */
    @Test
    public void testSetDescInformal() {
        //Testes de sucesso
        String descInformal1 = "Descrição Informal";
        tarefaT.setDescricaoInformal(descInformal1);
        assertEquals(descInformal1, tarefaT.getDescricaoInformal());
        //Testes de insucesso
//        System.out.println("setDescInformal Vazia");
        String descInformal2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDescricaoInformal(descInformal2);});
        assertEquals("Descrição informal inválida.", exception2.getMessage());
    }

    /**
     * Test of setDescTecnica method, of class Tarefa.
     */
    @Test
    public void testSetDescTecnica() {
        //Testes de sucesso
        String descTecnica1 = "Descrição Técnica";
        tarefaT.setDescricaoTecnica(descTecnica1);
        assertEquals(descTecnica1, tarefaT.getDescricaoTecnica());
        //Testes de insucesso
//        System.out.println("setDescTecnica Vazia");
        String descTecnica2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDescricaoTecnica(descTecnica2);});
        assertEquals("Descrição técnica inválida.", exception2.getMessage());
    }
    
    /**
     * Test of setDuracaoEstimada method, of class Tarefa.
     */
    @Test
    public void testSetDuracaoEstimada() {
        //Testes de sucesso
        String duracaoEst1 = "700";
        tarefaT.setDuracaoEstimada(duracaoEst1);
        assertEquals(duracaoEst1, tarefaT.getDuracaoEstimada());
        //Testes de insucesso
//        System.out.println("setDuracaoEstimada Vazia");
        String duracaoEst2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDuracaoEstimada(duracaoEst2);});
        assertEquals("Duração inválida.", exception2.getMessage());
//        System.out.println("setDuracaoEstimada Non-Digits");
        String duracaoEst3 = "700h";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDuracaoEstimada(duracaoEst3);});
        assertEquals("Duração inválida.", exception3.getMessage());
//        System.out.println("setDuracaoEstimada maxLength");
        String duracaoEst4 = "3000000";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setDuracaoEstimada(duracaoEst4);});
        assertEquals("Duração inválida.", exception4.getMessage());        
    }
    
    /**
     * Test of setCustoEstimado method, of class Tarefa.
     */
    @Test
    public void testSetCustoEstimado() {
        //Testes de sucesso
        String custoEst1 = "715.239";
        tarefaT.setCustoEstimado(custoEst1);
        assertEquals(custoEst1, tarefaT.getCustoEstimado());
        //Testes de insucesso
//        System.out.println("setCustoEstimado Vazio");
        String custoEst2 = "   ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setCustoEstimado(custoEst2);});
        assertEquals("Custo inválido.", exception2.getMessage());
////        System.out.println("setCustoEstimado Non-Digits");
        String custoEst3 = "700h";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setCustoEstimado(custoEst3);});
        assertEquals("Custo inválido.", exception3.getMessage());
////        System.out.println("setCustoEstimado maxLength");
        String custoEst4 = "300.000.000.000,00";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {tarefaT.setCustoEstimado(custoEst4);});
        assertEquals("Custo inválido.", exception4.getMessage());        
    }

}
