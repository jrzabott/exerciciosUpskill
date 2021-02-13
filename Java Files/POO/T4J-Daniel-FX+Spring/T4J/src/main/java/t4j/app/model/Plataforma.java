package t4j.app.model;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import sun.security.jca.GetInstance;
import t4j.app.exception.ElementoNaoExistenteException;
import t4j.app.model.RegistoOrganizacoes;
import t4j.app.repo.ConnectionFactory;
import t4j.app.repo.UsersAPI;

@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Plataforma implements Serializable {

    /**
     * Variável de instância - designação da plataforma
     */
    private String designacao;

    /**
     * Variável de instância - registo de organizações
     */
    private RegistoOrganizacoes registoOrganizacoes;

    /**
     * Variável de instância - registo de áreas de atividade
     */
    private RegistoAreasAtividade registoAreasAtividade;

    /**
     * Variável de instância - registo de competências técnicas
     */
    private RegistoCompetenciasTecnicas registoCompetenciasTecnicas;

    /**
     * Variável de instância - registo de categorias
     */
    private RegistoCategorias registoCategorias;

    /**
     * Variável de instância - registo de tarefas
     */
    private RegistoTarefas registoTarefas;

    /**
     * Variável de instância - usersAPI
     */
    private UsersAPI usersAPI;

    /**
     * Constante - app_key
     */
    private final static String APP_KEY
            = "IBD0DEHBDID62EB1EAZBEoA95E3cB5BD5135d01F0FqE6eDDoD4yDEX05RFEF19q9BY04KBE03A919hAFM06";
    public static final String TITULO_APLICACAO = "Tasks For Joe - T4J";

    private static Plataforma plataforma;
    
    private Connection connection;

    public static Plataforma getInstance() {
        if (Plataforma.plataforma == null) {
            Plataforma.plataforma = new Plataforma(TITULO_APLICACAO);
        }
        return Plataforma.plataforma;
    }

    /**
     * Construtor da pllataforma
     *
     * @param designacao designação da plataforma
     */
    private Plataforma(String designacao) {
        this.designacao = designacao;
        this.registoOrganizacoes = new RegistoOrganizacoes();
        this.usersAPI = new t4j.app.repo.UsersAPI(APP_KEY);
        this.registoAreasAtividade = new RegistoAreasAtividade();
        this.registoCategorias = new RegistoCategorias();
        this.registoCompetenciasTecnicas = new RegistoCompetenciasTecnicas();
        this.registoTarefas = new RegistoTarefas();
        this.connection = ConnectionFactory.getConnectionFactory().getConnection().getConnection();
    }

    /**
     *
     * @return designação
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     *
     * @return registo de organizações
     */
    public RegistoOrganizacoes getRegistoOrganizacoes() {
        return registoOrganizacoes;
    }

    /**
     *
     * @return registo de áreas de atividade
     */
    public RegistoAreasAtividade getRegistoAreasAtividade() {
        return registoAreasAtividade;
    }

    /**
     *
     * @return registo de competências técnicas
     */
    public RegistoCompetenciasTecnicas getRegistoCompetenciasTecnicas() {
        return registoCompetenciasTecnicas;
    }

    /**
     *
     * @return registo de categorias
     */
    public RegistoCategorias getRegistoCategorias() {
        return registoCategorias;
    }

    /**
     *
     * @return registo de tarefas
     */
    public RegistoTarefas getRegistoTarefas() {
        return registoTarefas;
    }

    /**
     *
     * @return usersAPI
     */
    public UsersAPI getUsersAPI() {
        return usersAPI;
    }

    public static String getTITULO_APLICACAO() {
        return TITULO_APLICACAO;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
