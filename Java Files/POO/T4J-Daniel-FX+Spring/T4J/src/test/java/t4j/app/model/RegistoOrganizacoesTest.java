package t4j.app.model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import t4j.app.exception.ElementoDuplicadoException;

public class RegistoOrganizacoesTest {

    private RegistoOrganizacoes regOrg;
    private Organizacao org, org2, org3;
    private EnderecoPostal endereco, endereco2;
    private Colaborador gestor, colab;

    public RegistoOrganizacoesTest() {
        endereco = new EnderecoPostal("Rua org", "4000-001", "Porto");
        gestor = new Colaborador("Joao", "Gestor", "911234567", "joao@org.com");
        org = new Organizacao("Org", "123456789", "www.org.com", "221234567", "geral@org.com", endereco, gestor);
        org2 = new Organizacao("Org2", "456789123", "www.org2.com", "251234567", "geral@org2.com", endereco, gestor);
        org3 = new Organizacao("Org", "123456789", "www.org.com", "221234567", "geral@org.com", endereco, gestor);
        colab = new Colaborador("Marta Costa", "Consultora", "912345678", "marta@org.com");

        regOrg = new RegistoOrganizacoes();
        regOrg.addOrganizacao(org);
    }

    /**
     * Test of getOrganizacoes method, of class RegistoOrganizacoes.
     */
    @Test
    public void testGetOrganizacoes() {
        System.out.println("getOrganizacoes");
        regOrg.addOrganizacao(org2);
        ArrayList<Organizacao> listaOrg = new ArrayList<>();
        listaOrg.add(org);
        listaOrg.add(org2);
        ArrayList<Organizacao> result = regOrg.getOrganizacoes();
        assertEquals(listaOrg, result);
    }

    /**
     * Test of getOrganizacaoByNif method, of class RegistoOrganizacoes.
     */
    @Test
    public void testGetOrganizacaoByNifTrue() {
        System.out.println("getOrganizacaoByNifTrue");
        String nif = "123456789";
        Organizacao result = regOrg.getOrganizacaoByNif(nif);
        assertEquals(org, result);
    }

    @Test
    public void testGetOrganizacaoByNifFalse() {
        System.out.println("getOrganizacaoByNifFalse");
        String nif = "456789123";
        Organizacao result = regOrg.getOrganizacaoByNif(nif);
        assertEquals(null, result);
    }

    /**
     * Test of getOrganizacaoByEmail method, of class RegistoOrganizacoes.
     */
    @Test
    public void testGetOrganizacaoByEmailTrue() {
        System.out.println("getOrganizacaoByEmailTrue");
        String email = "geral@org.com";
        Organizacao result = regOrg.getOrganizacaoByEmail(email);
        assertEquals(org, result);
    }

    @Test
    public void testGetOrganizacaoByEmailFalse() {
        System.out.println("getOrganizacaoByEmailFalse");
        String email = "geral@org2.com";
        Organizacao result = regOrg.getOrganizacaoByEmail(email);
        assertEquals(null, result);
    }

    /**
     * Test of addOrganizacao method, of class RegistoOrganizacoes.
     */
    @Test
    public void testAddOrganizacaoTrue() {
        System.out.println("addOrganizacaoTrue");
        assertTrue(regOrg.addOrganizacao(org2));
    }

    @Test
    public void testAddOrganizacaoNifDuplicado() {
        System.out.println("addOrganizacaoNifDuplicado");
        Throwable exception = assertThrows(ElementoDuplicadoException.class, () -> {
            regOrg.addOrganizacao(org3);
        });
        assertEquals("Já existe uma organização com esse NIF!", exception.getMessage());
    }
    
}
