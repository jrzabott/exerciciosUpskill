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
public class ColaboradorTest {
    private Colaborador colabT, colab, colab2, colab3;
    private Object obj;
    public ColaboradorTest() {
        colab = new Colaborador("Joao", "Gestor", "911234567", "joao@org.com");
        colab2 = new Colaborador(colab);
        colab3 = new Colaborador("Joana", "Gestora", "911234568", "joana@org.com");
        obj = new Object();
        colabT = new Colaborador();
    }
    
    /**
     * Test of setNome method, of class Colaborador.
     */
    @Test
    public void testSetNome() {
        //Testes de sucesso
        String nome1 = "João Martins";
        colabT.setNome(nome1);
        assertEquals(nome1, colabT.getNome());
        //Testes de insucesso
//        System.out.println("setNome Vazia");
        String nome2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setNome(nome2);});
        assertEquals("Nome de colaborador inválido.", exception2.getMessage());
//        System.out.println("setNome maxLength");
        String nome3 = String.format("|%52d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setNome(nome3);});
        assertEquals("Nome de colaborador inválido.", exception3.getMessage());
//        System.out.println("setNome c/Carateres especiais");
        String nome4 = "João$";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setNome(nome4);});
        assertEquals("Nome de colaborador inválido.", exception4.getMessage());        
    }
    
    /**
     * Test of setFuncao method, of class Colaborador.
     */
    @Test
    public void testSetFuncao() {
        //Testes de sucesso
        String funcao1 = "Gestor";
        colabT.setFuncao(funcao1);
        assertEquals(funcao1, colabT.getFuncao());
        //Testes de insucesso
//        System.out.println("setFuncao Vazia");
        String funcao2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setFuncao(funcao2);});
        assertEquals("Função inválida.", exception2.getMessage());
//        System.out.println("setFuncao maxLength");
        String funcao3 = String.format("|%52d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setFuncao(funcao3);});
        assertEquals("Função inválida.", exception3.getMessage());
    }

    /**
     * Test of setTelefone method, of class Colaborador.
     */
    @Test
    public void testSetTelefone() {
        //Testes de sucesso
        String tlf1 = "911234567";
        colabT.setTelefone(tlf1);
        assertEquals(tlf1, colabT.getTelefone());
        //Testes de insucesso
//        System.out.println("setTelefone Vazio");
        String tlf2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setTelefone(tlf2);});
        assertEquals("Telefone de colaborador inválido.", exception2.getMessage());
//        System.out.println("setTelefone maxLength");
        String tlf3 = String.format("|%17d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setTelefone(tlf3);});
        assertEquals("Telefone de colaborador inválido.", exception3.getMessage());
//        System.out.println("setTelefone Carateres Inválidos");
        String tlf4 = "+351 911234567";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setTelefone(tlf4);});
        assertEquals("Telefone de colaborador inválido.", exception4.getMessage());        
    }
    
    /**
     * Test of setEmail method, of class Colaborador.
     */
    @Test
    public void testSetEmail() {
        //Testes de sucesso
        String email1 = "joao@org.com";
        colabT.setEmail(email1);
        assertEquals(email1, colabT.getEmail());
        //Testes de insucesso
//        System.out.println("setEmail Vazio");
        String email2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email2);});
        assertEquals("Email de colaborador inválido.", exception2.getMessage());
////        System.out.println("setEmail maxLength");
//        String email3 = String.format("|%50d|", 0);
//        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email3);});
//        assertEquals("Email de colaborador inválido.", exception3.getMessage());
//        System.out.println("setEmail Carateres Inválidos");
//        String email4 = "joao!@org.com";
//        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email4);});
//        assertEquals("Email de colaborador inválido.", exception4.getMessage());        
//        System.out.println("setEmail Inválidos");
        String email5 = "joaoorg.com";
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email5);});
        assertEquals("Email de colaborador inválido.", exception5.getMessage());        
//        System.out.println("setEmail Inválidos");
        String email6 = "joao@orgcom";
        Throwable exception6 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email6);});
        assertEquals("Email de colaborador inválido.", exception6.getMessage());                
//        System.out.println("setEmail Inválidos");
        String email7 = "jo ao@org.com";
        Throwable exception7 = assertThrows(ElementoInvalidoException.class, () -> {colabT.setEmail(email7);});
        assertEquals("Email de colaborador inválido.", exception7.getMessage());
    }

    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(colab, colab);
        assertEquals(colab3, colab3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(colab, colab2);
        assertEquals(colab2, colab);
        // Testes de insucesso
        assertNotEquals(colab, colab3);
        assertNotEquals(colab3, colab);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(colab, null);
        assertNotEquals(colab3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(colab, obj);
        assertNotEquals(colab2, obj);
        assertNotEquals(colab3, obj);
    }
    
}
