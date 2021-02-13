package t4j.app.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import t4j.app.controller.OrganizacoesController;
import t4j.app.controller.UIApplicationController;
import t4j.app.controller.UIAutenticacaoController;
import t4j.app.dto.UserInfoDTO;
import t4j.app.model.Plataforma;
import t4j.app.repo.ConnectionFactory;
import t4j.app.repo.EnumFXMLs;

public class MainSceneController implements Initializable {

    private final String TITULO_APLICACAO = "Tasks For Joe - T4J";
    private final String MENU_ITEM_LOGIN_TEXT = "Login ...";

    private UIApplicationController appController;
    private DefinirAreaAtividadeController areaAtividade;
    private DefinirCategoriaTarefaController categoriaTarefa;
    private DefinirCompetenciaTecnicaController competenciaTecnica;
    private AutenticacaoController autenticacaoController;
    private EspecificarColaboradorController especificarColaboradorController;
    private EspecificarTarefaController especificarTarefaController;
    private RegistarOrganizacaoController registarOrganizacaoController;

    private Plataforma plataforma;

    private UIAutenticacaoController uiac;
    private UserInfoDTO uidto;
    private FXMLLoader loader;

    @FXML
    private Menu menuAdministracao;
    @FXML
    private Menu menuAjuda;
    @FXML
    private MenuBar menuBarMainScene;
    @FXML
    private Menu menuColaborador;
    @FXML
    private Menu menuFreelancer;
    @FXML
    private Menu menuGestor;
    @FXML
    private MenuItem menuItemLogin;
    @FXML
    private MenuItem menuItemRegistarOrganizacao;
    @FXML
    private MenuItem menuItemSair;
    @FXML
    private Menu menuPrincipal;
    @FXML
    private Menu menuUtilizadorNA;

    private Parent root;
    private Scene scene;
    private Stage stage;

    private OrganizacoesController oc = new OrganizacoesController();

    @FXML
    private Button btnDummy;
    @FXML
    private Button btnDummy2;
    @FXML
    private TextArea txtArea;
    @FXML
    private Label lblAppContext;
    @FXML
    private Label lblSessionInfo;
    @FXML
    private MenuItem menuItemLogout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loader = new FXMLLoader();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(EnumFXMLs.MAIN_SCENE.getTitle());
        stage.setResizable(false);

        // Application Controller, para poder interagir entre janelas e etc.
        appController = new UIApplicationController();
        appController.setMainSceneController(this);
        appController.setMainSceneMenuBar(this.menuBarMainScene);

        //<editor-fold defaultstate="collapsed">
        // Inicializar a interface de Login.
        // Se não utilizarmos o comando abaixo, a interface de Login irá 
        // ficar atrás da interface principal. Assim garantirmos que a janela
        // de login apenas será carregada após a janela principal.
        // </editor-fold>
        Platform.runLater(() -> {
            appController.hideMenuPrincipalItens();
            menuItemLogout.setDisable(true);
            menuItemLogin.setText(MENU_ITEM_LOGIN_TEXT);
        });
    }

    public UIApplicationController getAppController() {
        return appController;
    }

    public String getApp_context() {
        return uidto.getApp_context();
    }

    public void setApp_context(String app_context) {
        this.uidto.setApp_context(app_context);
    }

    public String getSession() {
        return this.uidto.getSession();
    }

    public UserInfoDTO getUidto() {
        return uidto;
    }

    public void setUidto(UserInfoDTO uidto) {
        this.uidto = uidto;
    }

    public void setUiac(UIAutenticacaoController uiac) {
        this.uiac = uiac;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    @FXML
    private void btnDummyAction(ActionEvent event) {
        UserInfoDTO u = new UserInfoDTO();
        u.setRolenames("freelancer");

        appController.showMenusByRole(u);
    }

    @FXML
    private void btnDummyAction2(ActionEvent event) {
        appController.hideMenuPrincipalItens();
    }

    @FXML
    private void btnHSAllMenus(ActionEvent event) {
        for (Menu menu : menuBarMainScene.getMenus()) {
            if ("Ajuda".equalsIgnoreCase(menu.getText())) {
                continue;
            }
            menu.setVisible(!menu.isVisible());
        }
    }

    @FXML
    private void menuItemDefinirAreaAtividade(ActionEvent event) {
        loadGUI(EnumFXMLs.DEFINIR_AREA_ATIVIDADE);
    }

    @FXML
    private void menuItemDefinirCategoriaTarefa(ActionEvent event) {
        loadGUI(EnumFXMLs.DEFINIR_CATEGORIA_TAREFA);
    }

    @FXML
    private void menuItemDefinirCompetenciaTecnica(ActionEvent event) {
        loadGUI(EnumFXMLs.DEFINIR_COMPETENCIA_TECNICA);
    }

    @FXML
    private void menuItemEspecificarColaboradorAction(ActionEvent event) {
        loadGUI(EnumFXMLs.ESPECIFICAR_COLABORADOR);
    }

    @FXML
    private void menuItemLoginAction(ActionEvent event) {
        if (menuItemLogin.getText().equalsIgnoreCase(MENU_ITEM_LOGIN_TEXT)) {
            loadGUI(EnumFXMLs.AUTENTICACAO);
        }
    }

    @FXML
    private void menuItemRegistarOrganizacaoAction(ActionEvent event) {
        loadGUI(EnumFXMLs.REGISTAR_ORGANIZACAO);
    }

    @FXML
    private void menuItemSair(ActionEvent event) {
        Window window = menuBarMainScene.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,
                WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void menuItemSairAction(ActionEvent event) {
        Window myWindow = menuBarMainScene.getScene().getWindow();
        myWindow.fireEvent(new WindowEvent(myWindow,
                WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private void menuItemSobre(ActionEvent event) {
        AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, TITULO_APLICACAO,
                "Acerca.",
                "@Copyright\nSprint 2 - Grupo 3\nBruno Barbosa, Daniel Junior, Fernando Crista, Jorge Pires\nUPskill 2020/2021")
                .show();
    }

    private void loadGUI(EnumFXMLs efxml) {
        try {
            loader = new FXMLLoader(getClass().getResource(efxml.getPath()));
            root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(efxml.getTitle());
            switch (efxml) {
                case DEFINIR_AREA_ATIVIDADE:
                    areaAtividade = loader.getController();
                    areaAtividade.associarParentUI(this);
                    break;
                case DEFINIR_CATEGORIA_TAREFA:
                    categoriaTarefa = loader.getController();
                    categoriaTarefa.associarParentUI(this);
                    break;
                case DEFINIR_COMPETENCIA_TECNICA:
                    competenciaTecnica = loader.getController();
                    competenciaTecnica.associarParentUI(this);
                    break;
                case AUTENTICACAO:
                    autenticacaoController = loader.getController();
                    autenticacaoController.associarParentUI(this);
                    break;
                case ESPECIFICAR_COLABORADOR:
                    especificarColaboradorController = loader.getController();
                    especificarColaboradorController.associarParentUI(this);
                    break;
                case ESPECIFICAR_TAREFA:
                    especificarTarefaController = loader.getController();
                    especificarTarefaController.associarParentUI(this);
                    break;
                case REGISTAR_ORGANIZACAO:
                    registarOrganizacaoController = loader.getController();
                    registarOrganizacaoController.associarParentUI(this);
                    break;
                case MAIN_SCENE:
                default:
            }
        } catch (IOException ex) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, TITULO_APLICACAO,
                    "Erro.", ex.getMessage() + "\n" + Arrays.toString(ex
                    .getStackTrace())).show();
        }
        stage.show();
    }

    @FXML
    private void menuItemLogoutAction(ActionEvent event) {
        if (logoutAction()) {
            return;
        }
    }

    public void setTxtLblSession(String roles) {
        lblSessionInfo.setText(roles);
    }

    public void setTxtLblAppContext(String ac) {
        lblAppContext.setText(ac);
    }

    public void setMenuItemLogoutDisabled(boolean login) {
        menuItemLogout.setDisable(login);
    }

    public void setMenuItemLoginText(String username) {
        menuItemLogin.setText(username);
    }

    public void setMenuAdministracaoVisible(boolean visible) {
        menuAdministracao.setVisible(visible);
    }

    public void setMenuColaborador(boolean visible) {
        menuColaborador.setVisible(visible);
    }

    public void setMenuGestor(boolean visible) {
        menuGestor.setVisible(visible);
    }

    public void setMenuFreelancer(boolean visible) {
        menuFreelancer.setVisible(visible);
    }

    public void setMenuUtilizadorNA(boolean visible) {
        menuUtilizadorNA.setVisible(visible);
    }

    public boolean logoutAction(boolean silentLogout) {
        boolean result = false;
        if (!this.uidto.getApp_context().isEmpty()) {
            result = this.uiac.logout();
        }
        if (!result) {
            if (!silentLogout) {
                Alert a = AlertaUI.criarAlerta(
                        Alert.AlertType.WARNING,
                        "Logout",
                        "Logout",
                        "Não há um utilizador logado.");
                a.show();
            }
            return true;
        }
        if (!silentLogout) {
            Alert a = AlertaUI.criarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Logout",
                    "Logout",
                    "Logout bem sucedido.");
            a.show();
            menuItemLogout.setDisable(true);
            menuItemLogin.setText(MENU_ITEM_LOGIN_TEXT);
            appController.hideMenuPrincipalItens();
            setMenuUtilizadorNA(true);
        }
        return false;
    }

    private boolean logoutAction() {
        return logoutAction(false);
    }

    @FXML
    private void menuItemEspecificarTarefaAction(ActionEvent event) {
        loadGUI(EnumFXMLs.ESPECIFICAR_TAREFA);
    }
}
