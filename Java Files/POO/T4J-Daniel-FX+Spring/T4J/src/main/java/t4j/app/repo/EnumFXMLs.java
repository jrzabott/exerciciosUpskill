package t4j.app.repo;

public enum EnumFXMLs {

    /**
     * Constante - caminho até à interface gráfica da janela principal e título da janela
     */
    MAIN_SCENE("/fxml/MainScene.fxml", "TASKS 4 JOE - T4J"),
    /**
     * Constante - caminho até à interface gráfica da janela de login e título da janela
     */
    AUTENTICACAO("/fxml/UIAutenticacao.fxml", "Login"),
    /**
     * Constante - caminho até à interface gráfica da janela de definição de área de trabalho e título da janela
     */
    DEFINIR_AREA_ATIVIDADE("/fxml/UIDefinirAreaAtividade.fxml", "Area de Atividade"),
    /**
     * Constante - caminho até à interface gráfica da janela de definição de categoria de tarefa e título da janela
     */
    DEFINIR_CATEGORIA_TAREFA("/fxml/UIDefinirCategoriaTarefa.fxml", "Categoria de Tarefa"),
    /**
     * Constante - caminho até à interface gráfica da janela de definição de competência técnica e título da janela
     */
    DEFINIR_COMPETENCIA_TECNICA("/fxml/UIDefinirCompetenciaTecnica.fxml", "Competencia Técnica"),
    /**
     * Constante - caminho até à interface gráfica da janela de especificação de um colaborador e título da janela
     */
    ESPECIFICAR_COLABORADOR("/fxml/UIEspecificarColaborador.fxml", "Colaborador"),
    /**
     * Constante - caminho até à interface gráfica da janela de especificação de uma tarefa e título da janela
     */
    ESPECIFICAR_TAREFA("/fxml/UIEspecificarTarefa.fxml", "Tarefa"),
    /**
     * Constante - caminho até à interface gráfica da janela de registo de uma organização e título da janela
     */
    REGISTAR_ORGANIZACAO("/fxml/UIRegistarOrganizacao.fxml", "Organização");

    /**
     * Variável de instância - caminho
     */
    private final String path;

    /**
     * Variável de instância - título
     */
    private final String title;

    /**
     * Construtor completo de enumeração de FXML's
     *
     * @param path
     * @param title
     */
    private EnumFXMLs(String path, String title) {
        this.path = path;
        this.title = title;
    }

    /**
     * Construtor parcial de enumeração de FXML's
     *
     * @param path
     */
    private EnumFXMLs(String path) {
        this.path = path;
        this.title = "";
    }

    /**
     *
     * @return caminho
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @return título
     */
    public String getTitle() {
        return title;
    }
}
