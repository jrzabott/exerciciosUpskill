/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.service;

import t4j.app.model.Plataforma;
import t4j.app.ui.MainSceneController;

/**
 *
 * @author user
 */
public class PlataformaService {
    private static MainSceneController mainSceneController;
    private static Plataforma plataforma;

    public static MainSceneController getMainSceneController() {
        return mainSceneController;
    }

    public static Plataforma getPlataforma() {
        return plataforma;
    }

    public static void setMainSceneController(
            MainSceneController mainSceneController) {
        PlataformaService.mainSceneController = mainSceneController;
    }

    public static void setPlataforma(Plataforma plataforma) {
        PlataformaService.plataforma = plataforma;
    }
    
    public static Plataforma getInstance(){
        return Plataforma.getInstance();
    }
    
}
