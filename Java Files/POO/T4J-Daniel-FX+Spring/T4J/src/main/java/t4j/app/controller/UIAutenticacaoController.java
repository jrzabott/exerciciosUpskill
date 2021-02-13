package t4j.app.controller;

import t4j.app.dto.UserInfoDTO;
import t4j.app.service.UsersService;
import t4j.app.ui.MainSceneController;

public class UIAutenticacaoController {

    /**
     *
     */
    private MainSceneController mainSceneController;

    /**
     *
     */
    private UIApplicationController appController;

    /**
     *
     * @param username identifica do utilizador
     * @param password password do tilizador
     * @return true se login efetuado e false se contrário
     */
    public boolean login(String username, String password) {
        UserInfoDTO u = this.mainSceneController.getUidto();
        u.setUsername(username);
        u.setPassword(password);
        return UsersService.login(u);
    }

    /**
     *
     * @return true se logout efetuado e false se contrário
     */
    public boolean logout() {
        UserInfoDTO u = this.mainSceneController.getUidto();
        return UsersService.logout(u);
    }

    /**
     *
     * @return os papell do utilizador
     */
    public String getRoles() {
        UserInfoDTO u = this.mainSceneController.getUidto();
        return UsersService.getRoles(u);
    }

    /**
     *
     * @return o controlller principal
     */
    public MainSceneController getMainSceneController() {
        return mainSceneController;
    }

    /**
     *
     * @param mainSceneController controller principal
     */
    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    /**
     *
     * @return controller da aplicação
     */
    public UIApplicationController getAppController() {
        return appController;
    }

    /**
     *
     * @param appController controller da aplicação
     */
    public void setAppController(UIApplicationController appController) {
        this.appController = appController;
    }

    /**
     *
     * @param u informação do utilizador que pretende efetuar o login
     * @return true se login efetuado e false se contrário
     */
    public boolean login(UserInfoDTO u) {
        boolean result = false;
        result = UsersService.login(u);
        return result;
    }
}
