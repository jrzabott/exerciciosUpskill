package t4j.app.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import t4j.app.dto.AppContextDTO;
import t4j.app.dto.OrganizacaoDTO;
import t4j.app.dto.UserInfoDTO;
import t4j.app.exception.LoginServerException;
import t4j.app.exception.UsersAPIException;
import t4j.app.model.Plataforma;
import t4j.app.repo.ConnectionFactory;
import t4j.app.repo.Roles;
import t4j.app.repo.UsersAPI;
import t4j.app.ui.MainSceneController;
import t4j.app.repo.Roles;
import t4j.app.service.PlataformaService;

public class UIApplicationController {
    
    

    // <editor-fold defaultstate="collapsed">
    // Daniel Junior - 20210205 09:47 removido static e app_key
    // Muito provavelmente isso não será estático. Nem mesmo deveria estar aqui.
    //    private static final String APP_KEY = "IBD0DEHBDID62EB1EAZBEoA95E3cB5BD5135d01F0FqE6eDDoD4yDEX05RFEF19q9BY04KBE03A919hAFM06";
    //    public static String getAPP_KEY() {
    //        return APP_KEY;
    //    }
    //    private UsersAPI usersAPI;
    //
    //    public UIApplicationController() {
    //        this.userInfo = new UserInfoDTO();
    //        this.usersAPI = new UsersAPI(APP_KEY);
    //    }
    // </editor-fold>
    /**
     *
     */
    private MainSceneController mainSceneController;

    /**
     *
     */
    private MenuBar mainSceneMenuBar;

    /**
     *
     */
    private static final String MENU_AJUDA_ID = "menuAjuda";

    /**
     *
     */
    private static final String MENU_UTILIZADOR_NA_ID = "menuUtilizadorNA";

    /**
     *
     */
    private static final String MENU_PRINCIPAL_ID = "menuPrincipal";

    /**
     *
     */
    private UserInfoDTO userInfo;

    public UIApplicationController() {
            this.mainSceneController.setUidto(new UserInfoDTO());
            this.mainSceneController.setPlataforma(PlataformaService.getInstance());
    }

    /**
     *
     * @return
     */
    public MainSceneController getMainSceneController() {
        return mainSceneController;
    }

    /**
     *
     * @param mainSceneController
     */
    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    /**
     *
     * @return
     */
    public MenuBar getMainSceneMenuBar() {
        return mainSceneMenuBar;
    }

    /**
     *
     * @param mainSceneMenuBar
     */
    public void setMainSceneMenuBar(MenuBar mainSceneMenuBar) {
        this.mainSceneMenuBar = mainSceneMenuBar;
    }

    /**
     *
     * @return
     */
    public UserInfoDTO getUserInfoDTO() {
        return userInfo;
    }

    /**
     *
     * @param userInfoDTO
     */
    public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
        this.userInfo = userInfoDTO;
    }

    /**
     *
     */
    public void hideMenuPrincipalItens() {
        for (Menu menu : mainSceneMenuBar.getMenus()) {
            if (menu.getId().equalsIgnoreCase(MENU_AJUDA_ID)) {
                menu.setVisible(true);
                continue;
            }
            if (menu.getId().equalsIgnoreCase(MENU_UTILIZADOR_NA_ID)) {
                menu.setVisible(true);
                continue;
            }
            if (menu.getId().equalsIgnoreCase(MENU_PRINCIPAL_ID)) {
                menu.setVisible(true);
                continue;
            }
            menu.setVisible(false);
        }
    }

    /**
     *
     * @param u informação do utilizador
     */
    public void showMenusByRole(UserInfoDTO u) {
        hideMenuUtilizadorNA();
        String[] rolesStrings = u.getRolenames().split(",");
        ArrayList<Roles> roles = new ArrayList<>();
        for (String rolesString : rolesStrings) {
            for (Roles value : Roles.values()) {
                if (value.name().equalsIgnoreCase(rolesString.trim())) {
                    roles.add(value);
                }
            }
        }
        for (Roles role : roles) {
            switch (role) {
                case ADMINISTRATIVO:
                    showMenusAdministrativo();
                    break;
                case COLABORADOR:
                    showMenusColaborador();
                    break;
                case FREELANCER:
                    showMenusFreelancer();
                    break;
                case GESTOR:
                    showMenusGestor();
                    break;
                default:
            }
        }
    }

    /**
     * mostra o menu do interface gráfico referente ao administrativo
     */
    void showMenusAdministrativo() {
        mainSceneController.setMenuAdministracaoVisible(true);
    }

    /**
     * mostra o menu do interface gráfico referente ao colaborador
     */
    void showMenusColaborador() {
        mainSceneController.setMenuColaborador(true);
    }

    /**
     * mostra o menu do interface gráfico referente ao freelancer
     */
    void showMenusFreelancer() {
        mainSceneController.setMenuFreelancer(true);
    }

    /**
     * mostra o menu do interface gráfico referente ao gestor
     */
    void showMenusGestor() {
        mainSceneController.setMenuGestor(true);
    }

    /**
     * mostra o menu do interface gráfico referente ao utilizador não autenticado
     */
    void hideMenuUtilizadorNA() {
        mainSceneController.setMenuUtilizadorNA(false);
    }

    /**
     * mostra todos os itens do menu do interface gráfico
     */
    public void showAllMenuPrincipalItens() {
        mainSceneMenuBar.getMenus().forEach(menu -> {
            menu.setVisible(true);
        });
    }
}
