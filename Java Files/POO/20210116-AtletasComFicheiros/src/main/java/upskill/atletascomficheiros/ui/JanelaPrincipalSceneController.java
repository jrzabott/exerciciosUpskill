/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.atletascomficheiros.ui;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import upskill.atletascomficheiros.controller.ApplicationController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class JanelaPrincipalSceneController implements Initializable {

    private final String ATLETA_AMADOR_SCENE_XML = "/fxml/AtletaAmadorScene.fxml";
    private final String ATLETA_PROFISSIONAL_SCENE_XML = "/fxml/AtletaProfissionalScene.fxml";
    private final String ATLETA_SEMIPROFISSIONAL_SCENE_XML = "/fxml/AtletaSemiProfissionalScene.fxml";
    private final String TITULO_APLICACAO = "Atletas com Ficheiros";

    private ApplicationController appController;

    private AtletaAmadorUI amadorUI;
    private AtletaProfissionalUI profissionalUI;
    private AtletaSemiProfissionalUI semiProfissionalUI;

    private FXMLLoader loader;

    private Parent root;
    private Scene scene;
    private Stage stage;

    public ApplicationController getAppController() {
        return appController;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loader = new FXMLLoader();

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Novo Atleta ");
        stage.setResizable(false);

        appController = new ApplicationController();

    }

    private void setCorretScene(Scene aScene) {
        this.stage.setScene(aScene);
    }

    private void loadAtletaAmadorUI() {
//        amadorUI = loadAtletaUI(ATLETA_AMADOR_SCENE_XML).getController();
        loadAtletaUI(ATLETA_AMADOR_SCENE_XML);
        stage.show();
    }

    private void loadAtletaProfissionalUI() {
        loadAtletaUI(ATLETA_PROFISSIONAL_SCENE_XML);
        stage.show();
    }

    private void loadAtletaUI(String resourceXML) {
        try {
            loader = new FXMLLoader(getClass().getResource(resourceXML));
            root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            switch (resourceXML) {
                case ATLETA_AMADOR_SCENE_XML:
                    amadorUI = loader.getController();
                    amadorUI.associarParentUI(this);
                    break;
                case ATLETA_PROFISSIONAL_SCENE_XML:
                    profissionalUI = loader.getController();
                    profissionalUI.associarParentUI(this);
                    break;
                case ATLETA_SEMIPROFISSIONAL_SCENE_XML:
                    semiProfissionalUI = loader.getController();
                    semiProfissionalUI.associarParentUI(this);
                    break;
                default:
            }

        } catch (IOException ex) {
            System.out.println("\n\n============================================");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            AlertUI.createUI(Alert.AlertType.ERROR, TITULO_APLICACAO, "Erro.", ex.getMessage() + "\n" + Arrays.toString(ex.getStackTrace()));
        }
    }

    private void loadSemiAtletaProfissionalUI() {
        loadAtletaUI(ATLETA_SEMIPROFISSIONAL_SCENE_XML);
        stage.show();
    }

    @FXML
    private void menuItemAmadorAction(ActionEvent event) {
        loadAtletaAmadorUI();
    }

    @FXML
    private void menuItemProfissionalAction(ActionEvent event) {
        loadAtletaProfissionalUI();
    }

    @FXML
    private void menuItemSairAction(ActionEvent event) {
    }

    @FXML
    private void menuItemSemiProfissionalAction(ActionEvent event) {
        loadAtletaProfissionalUI();
    }

    @FXML
    private void teclaPressionadaAction(KeyEvent event) {
    }

}
