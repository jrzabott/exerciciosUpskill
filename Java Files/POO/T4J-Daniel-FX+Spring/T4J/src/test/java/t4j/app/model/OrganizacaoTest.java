package t4j.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoInvalidoException;

public class OrganizacaoTest {
    private Organizacao orgT, org, org2, org3;
    private EnderecoPostal endereco ;
    private Colaborador gestor, colab, colab2;
    private Object obj;
    
    public OrganizacaoTest() {
        endereco = new EnderecoPostal("Rua org", "4000-001", "Porto");
        gestor = new Colaborador("Joao", "Gestor", "911234567", "joao@org.com");
//        org = new Organizacao("Org", "123456789", "www.org.com", "221234567", "geral@org.com", endereco, gestor);
        colab = new Colaborador("Marta Costa", "Consultora", "912345678", "marta@org.com");
//        colab2 = new Colaborador("Joao", "Gestor", "911234567", "joao@org.com");
        orgT = new Organizacao();
        org = new Organizacao("nome", "123456789", "www.org.com", "221234567", "geral@org.com", endereco, gestor);
        org2 = new Organizacao(org);
        org3 = new Organizacao(org);
//        org3.getColaboradores().add(colab);
        obj = new Object();
    }
    
    /**
     * Test of setNome method, of class Organizacao.
     */
    @Test
    public void testSetNome() {
        //Testes de sucesso
        String nome1 = "Organização";
        orgT.setNome(nome1);
        assertEquals(nome1, orgT.getNome());
        //Testes de insucesso
//        System.out.println("setNome Vazio");
        String nome2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setNome(nome2);});
        assertEquals("Nome de organização inválido.", exception2.getMessage());
//        System.out.println("setNome maxLength");
        String nome3 = String.format("|%60d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setNome(nome3);});
        assertEquals("Nome de organização inválido.", exception3.getMessage());
    }
    
    /**
     * Test of setNif method, of class Organizacao.
     */
    
    @Test
    public void testSetNif() {
        //Testes de sucesso
        String nif1 = "123456789";
        orgT.setNif(nif1);
        assertEquals(nif1, orgT.getNif());
        //Testes de insucesso
//        System.out.println("setNif Vazio");
        String nif2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setNif(nif2);});
        assertEquals("NIF inválido. Introduza NIF com 9 dígitos.", exception2.getMessage());
//        System.out.println("setNif DiffLength");
        String nif3 = "12345678";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setNif(nif3);});
        assertEquals("NIF inválido. Introduza NIF com 9 dígitos.", exception3.getMessage());
//        System.out.println("setNif Non-Digit");
        String nif4 = "12345678a";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setNif(nif4);});
        assertEquals("NIF inválido. Introduza NIF com 9 dígitos.", exception4.getMessage());
    }
    
    /**
     * Test of setWebsite method, of class Organizacao.
     */
    @Test
    public void testSetWebsite() {
        //Testes de sucesso
        String website1 = "www.org.com";
        String http = "http://";
        orgT.setWebsite(website1);
        assertEquals(http+=website1, orgT.getWebsite());
        //Testes de insucesso
//        System.out.println("setWebsite Vazio");
        String website2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setWebsite(website2);});
        assertEquals("Website inválido.", exception2.getMessage());
//        System.out.println("setWebsite Inválido");
        String website3 = "www.orgcom";
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setWebsite(website3);});
        assertEquals("Website inválido.", exception3.getMessage());
//        System.out.println("setWebsite Inválido");
        String website4 = "wwworgcom";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setWebsite(website4);});
        assertEquals("Website inválido.", exception4.getMessage());
//        System.out.println("setWebsite Inválido");
        String website5 = "ww!.org.com";
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setWebsite(website5);});
        assertEquals("Website inválido.", exception5.getMessage());
//        System.out.println("setWebsite maxLength");
//        String website6 = String.format("|%80d|", 0);
//        Throwable exception6 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setWebsite(website6);});
//        assertEquals("Website inválido.", exception6.getMessage());        
    }
    
    /**
     * Test of setTelefone method, of class Organizacao.
     */
    @Test
    public void testSetTelefone() {
        //Testes de sucesso
        String telefone1 = "911234567";
        orgT.setTelefone(telefone1);
        assertEquals(telefone1, orgT.getTelefone());
        //Testes de insucesso
//        System.out.println("setTelefone Vazio");
        String telefone2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setTelefone(telefone2);});
        assertEquals("Telefone de organização inválido.", exception2.getMessage());
//        System.out.println("setTelefone maxLength");
        String telefone3 = String.format("|%18d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setTelefone(telefone3);});
        assertEquals("Telefone de organização inválido.", exception3.getMessage());
//        System.out.println("setTelefone com espaços");
        String telefone4 = "91 1234567";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setTelefone(telefone4);});
        assertEquals("Telefone de organização inválido.", exception4.getMessage());        
    }
    
    /**
     * Test of setEmail method, of class Organizacao.
     */
    @Test
    public void testSetEmail() {
        //Testes de sucesso
        String email1 = "geral@org.com";
        orgT.setEmail(email1);
        assertEquals(email1, orgT.getEmail());
        //Testes de insucesso
//        System.out.println("setTelefone Vazio");
        String email2 = "  ";
        Throwable exception2 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setEmail(email2);});
        assertEquals("Email de organização inválido.", exception2.getMessage());
//        System.out.println("setEmail maxLength");
        String email3 = String.format("|%60d|", 0);
        Throwable exception3 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setEmail(email3);});
        assertEquals("Email de organização inválido.", exception3.getMessage());
//        System.out.println("setEmail Inválido");
        String email4 = "geralorg.com";
        Throwable exception4 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setEmail(email4);});
        assertEquals("Email de organização inválido.", exception4.getMessage());        
        String email5 = "geral@orgcom";
        Throwable exception5 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setEmail(email5);});
        assertEquals("Email de organização inválido.", exception5.getMessage());        
        String email6 = "ger al@orgcom";
        Throwable exception6 = assertThrows(ElementoInvalidoException.class, () -> {orgT.setEmail(email4);});
        assertEquals("Email de organização inválido.", exception6.getMessage());        
    }

//    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(org, org);
        assertEquals(org3, org3);
    }

//    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(org, org2);
        assertEquals(org2, org);
        // Testes de insucesso
        assertNotEquals(org, org3);
        assertNotEquals(org3, org);
    }

//    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(org, null);
        assertNotEquals(org3, null);
        assertNotEquals(obj, null);
    }

//    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(org, obj);
        assertNotEquals(org2, obj);
        assertNotEquals(org3, obj);
    }

//    @Test
//    public void testAddColaboradorOrganizacao() {
//        System.out.println("addColaboradorOrganizacao");
//        assertTrue(org.getColaboradores().addColaborador(colab));
//    }
//    
//    @Test
//    public void testAddColaboradorOrganizacaoDuplicado() {
//        System.out.println("addColaboradorOrganizacaoDuplicado");
//        org.getColaboradores().addColaborador(gestor);
//        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> {org.getColaboradores().addColaborador(colab2);});
//        assertEquals("Já existe um colaborador com esse email!", exception.getMessage());
//    }
}
