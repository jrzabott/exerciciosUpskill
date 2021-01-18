/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upskill.atletascomficheiros.ui;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import upskill.atletascomficheiros.controller.ApplicationController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AtletaAmadorUI implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;
    @FXML
    private ComboBox<String> cmbBoxIntensidadeTreino;
    @FXML
    private ComboBox<String> cmbBoxTipoAtividades;
    @FXML
    private ToggleGroup generoToggleGroup;
    @FXML
    private RadioButton radioButtonFeminino;
    @FXML
    private RadioButton radioButtonMasculino;
    @FXML
    private TextField txtFieldAntiguidade;
    @FXML
    private TextField txtFieldFCR;
    @FXML
    private TextField txtFieldIDCivil;
    @FXML
    private TextField txtFieldIdade;
    @FXML
    private TextField txtFieldNome;
    @FXML
    private TextField txtFieldPremio;

    private ApplicationController appController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO fill cmbBoxTipoAtividade
        // TODO fill cmbBoxIntensidadeTreino

        Platform.runLater(() -> {
            appController = janelaPrincipalSceneController.getAppController();
            fillCmbBox(appController.getTipoAtividades(), cmbBoxTipoAtividades);
            fillCmbBox(appController.getIntensidadeTreinos(), cmbBoxIntensidadeTreino);
        });
    }

    private void fillCmbBox(String[] txtArr, ComboBox cmbBox) {
        cmbBox.getItems().addAll(Arrays.asList(txtArr));
    }

    @FXML
    private void btnAddAction(ActionEvent event) {
        System.out.println(((RadioButton)generoToggleGroup.getSelectedToggle()).getText());
        try {
            boolean added = appController.adicionarAtletaAmador(
                    txtFieldNome.getText(),
                    txtFieldIDCivil.getText(),
                    ((RadioButton)generoToggleGroup.getSelectedToggle()).getText(),
                    txtFieldIdade.getText(),
                    cmbBoxTipoAtividades.getValue(),
                    cmbBoxIntensidadeTreino.getValue(),
                    txtFieldFCR.getText(),
                    txtFieldPremio.getText(),
                    txtFieldAntiguidade.getText()
            );
            btnAdd.getScene().getWindow().hide();
            janelaPrincipalSceneController.atualizarLista();
        } catch (IllegalArgumentException illegalArgumentException) {
            AlertUI.createUI(Alert.AlertType.ERROR, "ERRO AO ADICIONAR ATLETA", "Erro ao criar novo atleta", illegalArgumentException.getMessage());
        }
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
    }

    private JanelaPrincipalSceneController janelaPrincipalSceneController;

    void associarParentUI(JanelaPrincipalSceneController jpsc) {
        this.janelaPrincipalSceneController = jpsc;
    }

}
